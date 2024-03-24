package com.igroup.bandesal.core.response.authentication;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.igroup.bandesal.core.response.ErrorType;
import com.igroup.bandesal.core.response.ResponseErrors;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Response autentication.")
public class AuthenticationResponse implements Serializable, ResponseErrors {

    @Schema(description = "Token jwt.")
    private String jwt;
    @Schema(description = "Si logra genera el token .")
    private boolean generateJwt;
    @Schema(description = "List of errors.")
    private List<ErrorType> error;

    public AuthenticationResponse(){}

    public AuthenticationResponse(AuthenticationResponse other) {
       this.jwt= other.jwt;
       this.generateJwt = other.generateJwt;
    }

    public AuthenticationResponse withJwt(String jwt) {
        this.jwt = jwt;
        return this;
    }

    public AuthenticationResponse withGenerateJwt(boolean generateJwt) {
        this.generateJwt = generateJwt;
        return this;
    }

    @Override
    public List<ErrorType> getError() {
        if (error == null) {
            error = new ArrayList<>();
        }
        return this.error;
    }
}
