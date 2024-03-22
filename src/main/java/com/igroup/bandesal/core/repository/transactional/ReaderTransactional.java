package com.igroup.bandesal.core.repository.transactional;

import com.igroup.bandesal.core.entity.bandesal.Reader;
import com.igroup.bandesal.core.repository.ReaderRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;

@Dependent
public class ReaderTransactional {

    private final ReaderRepository readerRepository;
    public ReaderTransactional(ReaderRepository readerRepository){
        this.readerRepository = readerRepository;
    }

    @Transactional
    public Reader save (Reader r){
        readerRepository.persist(r);
        return r;
    }
}
