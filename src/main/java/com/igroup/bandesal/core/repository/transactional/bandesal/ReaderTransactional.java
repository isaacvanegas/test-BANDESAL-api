package com.igroup.bandesal.core.repository.transactional.bandesal;

import com.igroup.bandesal.core.entity.bandesal.Reader;
import com.igroup.bandesal.core.repository.bandesal.ReaderRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

import java.util.*;

@Dependent
public class ReaderTransactional {

    private final ReaderRepository readerRepository;
    public ReaderTransactional(ReaderRepository readerRepository){
        this.readerRepository = readerRepository;
    }

    @Transactional
    public Reader save (Reader r){
        List<Reader> l = this.findByName(r.getName());
        if(l == null){
            readerRepository.persist(r);
        }else{
            r = l.stream().findFirst().get();
        }

        return r;
    }

    @Transactional
    public List<Reader> findById(String id){

        return  id.equals("0") ?
                readerRepository.listAll() :
                readerRepository.getReadersById(id);

    }

    @Transactional
    public List<Reader> findByName(String name){
        return readerRepository.getReaderByName(name);
    }
}
