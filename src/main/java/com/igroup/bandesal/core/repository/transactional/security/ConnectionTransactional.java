package com.igroup.bandesal.core.repository.transactional.security;

import com.igroup.bandesal.core.entity.security.Connection;
import com.igroup.bandesal.core.repository.security.ConnectionRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

@Dependent
public class ConnectionTransactional {

    private final ConnectionRepository connectionRepository;
    public ConnectionTransactional(ConnectionRepository connectionRepository){
        this.connectionRepository = connectionRepository;
    }


    @Transactional
    public Connection verificToken(String token){
        return connectionRepository.verifictToken(token);
    }


}
