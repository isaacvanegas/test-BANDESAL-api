package com.igroup.bandesal.core.operation;



import com.igroup.bandesal.core.request.ObjectRQ;
import com.igroup.bandesal.core.request.Request;
import com.igroup.bandesal.core.response.ErrorType;
import com.igroup.bandesal.core.response.ResponseErrors;
import jakarta.enterprise.context.Dependent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;
import java.util.function.Supplier;

@Dependent
public class BaseOperation<Request extends com.igroup.bandesal.core.request.Request, Response extends ResponseErrors> {
    
    private static final Logger LOG = LoggerFactory.getLogger(BaseOperation.class);

    public Response execute(ObjectRQ<Request> request, Function<ObjectRQ<Request>, Response> execution, Supplier<Response> responseSupplier) {
        try {
            Response resp = execution.apply(request);
            if (resp.getError().isEmpty()) {
                resp.getError().add(ErrorType.ok());
            }
            return resp;
        } catch (Exception ex) {
            LOG.error("ApiException", ex);
            return getErrorResponse(ex, responseSupplier);
        }
    }
    
    private Response getErrorResponse(Exception exception, Supplier<Response> responseSupplier) {
        Response response = responseSupplier.get();
        response.getError().add(ErrorType.important(exception.getMessage()));
        return response;
    }
}
