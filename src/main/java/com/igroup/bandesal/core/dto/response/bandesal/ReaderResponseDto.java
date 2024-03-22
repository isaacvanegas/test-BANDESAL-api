package com.igroup.bandesal.core.dto.response.bandesal;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.igroup.bandesal.core.dto.ReaderDto;
import com.igroup.bandesal.core.response.ErrorType;
import com.igroup.bandesal.core.response.ResponseErrors;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Response de lectores.")
public class ReaderResponseDto implements ResponseErrors, Serializable {

    @Schema(description = "Lista de Reader.")
    private List<ReaderDto> listReader;
    @Schema(description = "List of errors.")
    private List<ErrorType> error;

    public ReaderResponseDto(){}

    public ReaderResponseDto(ReaderResponseDto other) {
        if (other.listReader != null) {
            this.listReader = other.listReader
                    .stream()
                    .map(ReaderDto::new)
                    .collect(Collectors.toList());
        }
    }

    public List<ReaderDto> getReaders() {
        if (listReader == null) {
            listReader = new ArrayList<>();
        }
        return listReader;
    }

    public void setReaders(List<ReaderDto> listReader) {
        this.listReader = listReader;
    }

    public ReaderResponseDto withReader(List<ReaderDto> listReader) {
        this.listReader = listReader;
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
