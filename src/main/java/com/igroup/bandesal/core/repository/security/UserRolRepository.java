package com.igroup.bandesal.core.repository.security;

import com.igroup.bandesal.core.entity.security.UserRol;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class UserRolRepository implements PanacheRepository<UserRol> {

    public List<UserRol> getRolesByIdUsuario(Integer userId){
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        return find("userId = :userId",params).list();
    }
}
