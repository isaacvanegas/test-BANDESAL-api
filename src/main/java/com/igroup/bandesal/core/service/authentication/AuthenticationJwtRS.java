package com.igroup.bandesal.core.service.authentication;

import com.igroup.bandesal.core.dto.request.bandesal.ReaderRequestDto;
import com.igroup.bandesal.core.dto.request.security.AuthenticationRequestDto;
import com.igroup.bandesal.core.entity.ContextData;
import com.igroup.bandesal.core.request.bandesal.ReadRequestRQ;
import com.igroup.bandesal.core.request.secutiry.AuthenticationRequestRQ;
import com.igroup.bandesal.core.response.authentication.AuthenticationResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import java.util.UUID;

@Path("/jwt")
@ApplicationScoped
public class AuthenticationJwtRS {

    @HeaderParam("Token")
    private String token;
    @HeaderParam("TransactionId")
    private String transactionId;

    @Inject
    JwtService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
            operationId = "getJwt",
            summary = "get json web token",
            description = "Valida aceso y seccion para generar token"
    )
    @APIResponse(
            responseCode = "200",
            description = "Verifica solicitud de seccion y retorna token de autorizacion."
    )
    public AuthenticationResponse getJwt(
            @RequestBody(
                    required = true,
                    description = "Request de autenticacion.",
                    content = @Content(schema = @Schema(implementation = ReaderRequestDto.class))
            )
            AuthenticationRequestDto request) {
        return service.generateJwt(AuthenticationRequestRQ.of(buildContext(), request));
    }

    private ContextData buildContext() {

        return ContextData.builder()
                .setToken(token)
                .setTransactionId(getTransactionId(transactionId))
                .build();
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
}
