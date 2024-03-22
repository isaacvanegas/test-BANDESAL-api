package com.igroup.bandesal.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.igroup.bandesal.core.response.ErrorType;
import com.igroup.bandesal.core.response.ResponseErrors;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Lista de lectores.")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ReaderDto implements ResponseErrors, Serializable {
    @Schema(description = "Id lector.", example = "1")
    private Integer id;
    @Schema(description = "Nombre.", example = "ISAAC VANEGAS PÉREZ")
    private String name;
    @Schema(description = "List of errors.")
    private List<ErrorType> error;

    @Override
    public List<ErrorType> getError() {
        if (error == null) {
            error = new ArrayList<>();
        }
        return this.error;
    }
    public ReaderDto() {}

    public ReaderDto(ReaderDto other) {
        this.id = other.id;
        this.name = other.name;

    }

    public ReaderDto withId(Integer id) {
        this.id = id;
        return this;
    }

    public ReaderDto withName(String name) {
        this.name = name;
        return this;
    }



}
