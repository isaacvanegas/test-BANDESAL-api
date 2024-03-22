package com.igroup.bandesal.core.dto.request.bandesal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.igroup.bandesal.core.request.Request;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Información de request.")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReaderRequestDto  implements Request, Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Identity user.", example = "11234")
    Integer userId ;
    @Schema(description = "Id lector", example = "1")
    String readerId;

    public ReaderRequestDto() {}

    public ReaderRequestDto(ReaderRequestDto other) {
        this.userId  = other.userId ;
        this.readerId = other.readerId;
    }

    public ReaderRequestDto withUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public ReaderRequestDto withReaderId(String readerId) {
        this.readerId = readerId;
        return this;
    }

}
