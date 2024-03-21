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

    @Schema(description = "Identity user.", example = "126485ikf03453")
    Integer user_id ;
    @Schema(description = "Id lector", example = "1")
    String reader_id;

    public ReaderRequestDto() {}

    public ReaderRequestDto(ReaderRequestDto other) {
        this.user_id  = other.user_id ;
        this.reader_id = other.reader_id;
    }

    public ReaderRequestDto withUserId(Integer user_id) {
        this.user_id = user_id;
        return this;
    }

    public ReaderRequestDto withReaderId(String reader_id) {
        this.reader_id = reader_id;
        return this;
    }

}
