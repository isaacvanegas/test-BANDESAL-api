package com.igroup.bandesal.core.repository.bandesal;

import com.igroup.bandesal.core.entity.bandesal.Reader;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.*;

@ApplicationScoped
public class ReaderRepository implements PanacheRepository<Reader>{

    public Reader getReaderById(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return find("id = :id",params).singleResult();
    }

    public List<Reader> getReadersById(String id) {
        List<Reader> l = new ArrayList<>();
        l.add(this.getReaderById(id));
        return l ;
    }

    public List<Reader> getReaderByName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name.toLowerCase()+"%");
        return list("lower(name) LIKE :name",params);
    }

}
