package com.igroup.bandesal.core.operation.bandesal;


import com.igroup.bandesal.core.builder.bandesal.ReaderBuilder;
import com.igroup.bandesal.core.dto.ReaderDto;
import com.igroup.bandesal.core.dto.request.bandesal.ReaderRequestDto;
import com.igroup.bandesal.core.entity.ContextData;
import com.igroup.bandesal.core.entity.bandesal.Reader;
import com.igroup.bandesal.core.operation.BaseOperation;
import com.igroup.bandesal.core.repository.ReaderRepository;
import com.igroup.bandesal.core.request.ObjectRQ;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Dependent
public class ReaderOperation {
    private static final Logger LOG = LoggerFactory.getLogger(ReaderOperation.class);

    private final BaseOperation<ReaderRequestDto, ReaderDto> baseOperation;
    private final ReaderRepository readerRepository;

    private final ReaderBuilder readerBuilder;
    @Inject
    public ReaderOperation(BaseOperation<ReaderRequestDto, ReaderDto> baseOperation,
                           ReaderRepository readerRepository,
                           ReaderBuilder readerBuilder) {
        this.baseOperation = baseOperation;
        this.readerRepository = readerRepository;
        this.readerBuilder = readerBuilder;
    }


    public ReaderDto execute(ObjectRQ<ReaderRequestDto> rq) {
        return baseOperation.execute(rq, this::doExecute, ReaderDto::new);
    }

    private ReaderDto doExecute(ObjectRQ<ReaderRequestDto> rq) {
        LOG.debug("get reader");


        ReaderRequestDto request = rq.data();
        ContextData context = rq.context();

        return readerBuilder.build( readerRepository.getReaderById(request.getReaderId()).orElse(  null));
    }


}
