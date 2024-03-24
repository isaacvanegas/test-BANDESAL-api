package com.igroup.bandesal.core.response;

import com.igroup.bandesal.core.util.ModelObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@Schema(description = "Error type.")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ErrorType implements Serializable, ModelObject {

    private static final long serialVersionUID = 123456L;

    @Schema(description = "Error code.", example = "EXCEPTION")
    private String errorCode;
    @Schema(description = "message error.", example = "General exception.")
    private String errorMsg;

    public ErrorType() {
    }

    public ErrorType(ErrorType other) {
        this.errorCode = other.errorCode;
        this.errorMsg = other.errorMsg;
    }

    public ErrorType(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg != null ? errorMsg : "Unknown error";
    }

    public static ErrorType ok() {
        return new ErrorType("0", "Respuesta correcta");
    }


    public static ErrorType unauthorizedGenerateJWT(String msg) {
        return new ErrorType("UGJWT", msg);
    }

    public static ErrorType important(String msg) {
        return new ErrorType("EXCEPTION", msg);
    }
    
    public String getErrorCode() {
        return errorCode;
    }

    public ErrorType withErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public ErrorType withErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
