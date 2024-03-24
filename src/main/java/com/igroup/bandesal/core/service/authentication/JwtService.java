package com.igroup.bandesal.core.service.authentication;

import com.igroup.bandesal.core.dto.request.bandesal.ReaderRequestDto;
import com.igroup.bandesal.core.dto.request.security.AuthenticationRequestDto;
import com.igroup.bandesal.core.entity.security.Connection;
import com.igroup.bandesal.core.entity.security.UserRol;
import com.igroup.bandesal.core.operation.bandesal.ReaderOperation;
import com.igroup.bandesal.core.repository.transactional.security.ConnectionTransactional;
import com.igroup.bandesal.core.repository.transactional.security.UserTransacational;
import com.igroup.bandesal.core.request.ObjectRQ;
import com.igroup.bandesal.core.response.ErrorType;
import com.igroup.bandesal.core.response.authentication.AuthenticationResponse;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
@Dependent
public class JwtService {
    private static final Logger LOG = LoggerFactory.getLogger(JwtService.class);

    private final ConnectionTransactional connectionTransactional;
    private final UserTransacational userTransacational;

    @Inject
    public JwtService(ConnectionTransactional connectionTransactional,
                      UserTransacational userTransacational) {
        this.connectionTransactional = connectionTransactional;
        this.userTransacational = userTransacational;
    }

    public AuthenticationResponse generateJwt(ObjectRQ<AuthenticationRequestDto> rq) {
        LOG.info("generate jwt: " + rq.context().getToken());

        AuthenticationResponse r = new AuthenticationResponse();

        Connection c = connectionTransactional.verificToken(rq.context().getToken());

        if (c != null) {
            List<UserRol> userRols = userTransacational.getRolesByIdUsuario(c.getUserId().getId());
            r.setGenerateJwt(true);
            r.setJwt(Jwt.issuer("igroup")
                    .subject(c.getUserId().getUserName())
                    .groups(new HashSet<>(userRols.stream()
                            .map(ur -> ur.getRolId().getName())
                            .collect(Collectors.toList())))
                    .expiresAt(System.currentTimeMillis() + 3600).sign());

        } else {
            LOG.warn("generate jwt denied token: " +rq.context().getToken());
            r.setGenerateJwt(false);
            r.setError((List<ErrorType>) ErrorType.unauthorizedGenerateJWT("Sin autorización para generar token"));
        }
        return r;
    }
}