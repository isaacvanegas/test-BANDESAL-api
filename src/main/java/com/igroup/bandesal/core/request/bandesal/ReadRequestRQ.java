package com.igroup.bandesal.core.request.bandesal;

import com.igroup.bandesal.core.dto.request.bandesal.ReaderRequestDto;
import com.igroup.bandesal.core.entity.ContextData;
import com.igroup.bandesal.core.request.ObjectRQ;

public record ReadRequestRQ(ContextData context, ReaderRequestDto data) implements ObjectRQ<ReaderRequestDto> {
    public static ObjectRQ<ReaderRequestDto> of(ContextData context, ReaderRequestDto data) {
        return new ReadRequestRQ(context, data);
    }
}
