package com.igroup.bandesal.core.dto.request.security;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.igroup.bandesal.core.dto.request.bandesal.ReaderRequestDto;
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
@Schema(description = "Informacion del request.")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AuthenticationRequestDto  implements Request, Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "Url acces.", example = "/view/index.xhtml")
    Integer uri ;
    public AuthenticationRequestDto() {}

    public AuthenticationRequestDto(AuthenticationRequestDto other) {
        this.uri  = other.uri ;
    }

    public AuthenticationRequestDto withUri(Integer uri) {
        this.uri = uri;
        return this;
    }
}
