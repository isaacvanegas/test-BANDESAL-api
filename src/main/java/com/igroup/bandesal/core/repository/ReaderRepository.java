package com.igroup.bandesal.core.repository;

import com.igroup.bandesal.core.entity.bandesal.Reader;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.*;

@ApplicationScoped
public class ReaderRepository implements PanacheRepository<Reader>{

    public List<Reader> getReaderById(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return find("id = :id",params).stream().toList();
    }

}
