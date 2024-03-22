package com.igroup.bandesal.core.operation.bandesal;


import com.igroup.bandesal.core.builder.bandesal.ReaderBuilder;
import com.igroup.bandesal.core.builder.bandesal.ReaderResponseBuilder;
import com.igroup.bandesal.core.dto.ReaderDto;
import com.igroup.bandesal.core.dto.request.bandesal.ReaderRequestDto;
import com.igroup.bandesal.core.dto.response.bandesal.ReaderResponseDto;
import com.igroup.bandesal.core.entity.ContextData;
import com.igroup.bandesal.core.entity.bandesal.Reader;
import com.igroup.bandesal.core.operation.BaseOperation;
import com.igroup.bandesal.core.repository.ReaderRepository;
import com.igroup.bandesal.core.repository.transactional.ReaderTransactional;
import com.igroup.bandesal.core.request.ObjectRQ;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Dependent
public class ReaderOperation {
    private static final Logger LOG = LoggerFactory.getLogger(ReaderOperation.class);

    private final BaseOperation<ReaderRequestDto, ReaderResponseDto> baseOperation;
    private final ReaderRepository readerRepository;
    private final ReaderResponseBuilder readerResponseBuilder;
    private final ReaderTransactional readerTransactional;


    @Inject
    public ReaderOperation(BaseOperation<ReaderRequestDto, ReaderResponseDto> baseOperation,
                           ReaderRepository readerRepository,
                           ReaderResponseBuilder readerResponseBuilder,
                           ReaderTransactional readerTransactional) {
        this.baseOperation = baseOperation;
        this.readerRepository = readerRepository;
        this.readerResponseBuilder = readerResponseBuilder;
        this.readerTransactional = readerTransactional;
    }


    public ReaderResponseDto execute(ObjectRQ<ReaderRequestDto> rq) {
        return baseOperation.execute(rq, this::doExecute, ReaderResponseDto::new);
    }

    private ReaderResponseDto doExecute(ObjectRQ<ReaderRequestDto> rq) {
        LOG.debug("get reader");


        ReaderRequestDto request = rq.data();
        ContextData context = rq.context();

        return readerResponseBuilder.build(operation(request));
    }

    private List<Reader> operation(ReaderRequestDto request){
        List<Reader> lr = new ArrayList<>();
        Reader r = new Reader();

        if(request.getSave()){
            r.setName(request.getName());
            lr.add(readerTransactional.save(r));
        }else{
            lr =  request.getReaderId().equals("0") ?
                    readerRepository.listAll() :
                    readerRepository.getReaderById(request.getReaderId());
        }

        return lr;
    }



}
