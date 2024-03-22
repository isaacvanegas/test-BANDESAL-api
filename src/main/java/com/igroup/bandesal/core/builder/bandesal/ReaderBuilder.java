package com.igroup.bandesal.core.builder.bandesal;

import com.igroup.bandesal.core.dto.ReaderDto;
import com.igroup.bandesal.core.dto.response.bandesal.ReaderResponseDto;
import com.igroup.bandesal.core.entity.bandesal.Reader;
import jakarta.enterprise.context.Dependent;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Dependent
public class ReaderBuilder {

    public ReaderDto build(Reader reader) {
        if (reader==null) {
            return null;
        }
        return new ReaderDto()
                .withId(reader.getId())
                .withName(reader.getName());
    }

    public List<ReaderDto> buildList(List<Reader> listReader) {
        return listReader.stream()
                .map(this::build)
                .toList();
    }

}
