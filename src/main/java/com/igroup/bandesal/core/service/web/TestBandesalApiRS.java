package com.igroup.bandesal.core.service.web;

import com.igroup.bandesal.core.dto.ReaderDto;
import com.igroup.bandesal.core.dto.request.bandesal.ReaderRequestDto;
import com.igroup.bandesal.core.entity.ContextData;
import com.igroup.bandesal.core.operation.OperationsManager;
import com.igroup.bandesal.core.request.bandesal.ReadRequestRQ;
import com.igroup.bandesal.core.response.ResponseErrors;
import com.igroup.bandesal.core.util.language.LabelEs;
import com.igroup.bandesal.core.util.logger.OperationAccessLogger;
import com.igroup.bandesal.core.util.logger.TimesLogger;
import io.quarkus.vertx.http.Compressed;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.function.Supplier;

@SecurityScheme(
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT"
)
@Path("/bandesal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestBandesalApiRS {

    @Inject
    OperationsManager operationsManager;
    @Inject
    OperationAccessLogger operationAccessLogger;
    @Inject
    TimesLogger timesLogger;
    @Inject
    LabelEs label;


    @HeaderParam("Token")
    private String token;
    @HeaderParam("TransactionId")
    private String transactionId;

    @POST
    @PermitAll
    @Compressed
    @Path("/getReader")
    @Operation(
            operationId = "getReader",
            summary = "Get Reader",
            description = "Busca lectores por id."
    )
    @APIResponse(
            responseCode = "200",
            description = "Retorna la versión actual de la applicación."
    )
    public ReaderDto getAppVersion(
            @RequestBody(
                    required = true,
                    description = "Request access data.",
                    content = @Content(schema = @Schema(implementation = ReaderRequestDto.class))
            )
            ReaderRequestDto request
    ) {
        LOG.info(label.getGetReaderApi());
        return log("GET_READER", () -> operationsManager
                .getReaderOperation()
                .execute(ReadRequestRQ.of(buildContext(), request)));
    }



    private static final Logger LOG = LoggerFactory.getLogger(TestBandesalApiRS.class);

    private <Response extends ResponseErrors> Response log(String operation, Supplier<Response> supplier) {
        logAccessRequest(operation);
        long init = System.currentTimeMillis();
        Response rs = supplier.get();
        long end = System.currentTimeMillis();
        timesLogger.log(getTransactionId(transactionId), operation, end - init);
        logAccessResponse(operation);
        return rs;
    }

    private void logAccessRequest(String operation) {
        operationAccessLogger.logRequest(getTransactionId(transactionId), operation);
    }

    private void logAccessResponse(String operation) {
        operationAccessLogger.logResponse(getTransactionId(transactionId), operation);
    }

    private String getTransactionId(String value) {
        final String localTransactionId;
        if (value == null || value.trim().isEmpty()) {
            localTransactionId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        } else {
            localTransactionId = value;
        }
        return localTransactionId;
    }

    private ContextData buildContext() {

        return ContextData.builder()
                .setToken(token)
                .setTransactionId(getTransactionId(transactionId))
                .build();
    }


}
