package com.igroup.bandesal.core.request.secutiry;

import com.igroup.bandesal.core.dto.request.bandesal.ReaderRequestDto;
import com.igroup.bandesal.core.dto.request.security.AuthenticationRequestDto;
import com.igroup.bandesal.core.entity.ContextData;
import com.igroup.bandesal.core.request.ObjectRQ;
import com.igroup.bandesal.core.request.bandesal.ReadRequestRQ;

public record AuthenticationRequestRQ(ContextData context, AuthenticationRequestDto data)  implements ObjectRQ<AuthenticationRequestDto> {
    public static ObjectRQ<AuthenticationRequestDto> of(ContextData context, AuthenticationRequestDto data) {
        return new AuthenticationRequestRQ(context, data);
    }
}
