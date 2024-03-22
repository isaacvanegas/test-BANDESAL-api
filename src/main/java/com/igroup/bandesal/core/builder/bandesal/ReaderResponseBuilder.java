package com.igroup.bandesal.core.builder.bandesal;

import com.igroup.bandesal.core.dto.ReaderDto;
import com.igroup.bandesal.core.dto.response.bandesal.ReaderResponseDto;
import com.igroup.bandesal.core.entity.bandesal.Reader;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

import java.util.List;

@Dependent
public class ReaderResponseBuilder {
    private final ReaderBuilder readerBuilder;
    @Inject
    ReaderResponseBuilder(ReaderBuilder readerBuilder){
        this.readerBuilder = readerBuilder;
    }

    public ReaderResponseDto build(List<Reader> readers) {
        if (readers==null) {
            return null;
        }
        return new ReaderResponseDto()
                .withReader(readerBuilder.buildList(readers));
    }
}