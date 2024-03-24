package com.igroup.bandesal.core.repository.transactional.security;

import com.igroup.bandesal.core.entity.security.RolMenu;
import com.igroup.bandesal.core.entity.security.UserRol;
import com.igroup.bandesal.core.repository.security.UserRepository;
import com.igroup.bandesal.core.repository.security.UserRolRepository;
import jakarta.enterprise.context.Dependent;

import java.util.List;

@Dependent
public class UserTransacational {

    private final UserRolRepository userRolRepository;
    public UserTransacational(UserRolRepository userRolRepository){
       this.userRolRepository = userRolRepository;
    }

    public List<UserRol> getRolesByIdUsuario(Integer userId){
        return userRolRepository.getRolesByIdUsuario(userId);
    }

}
