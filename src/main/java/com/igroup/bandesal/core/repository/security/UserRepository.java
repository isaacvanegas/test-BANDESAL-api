package com.igroup.bandesal.core.repository.security;

import com.igroup.bandesal.core.entity.security.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
