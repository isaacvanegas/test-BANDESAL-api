package com.igroup.bandesal.core.operation.bandesal;


import com.igroup.bandesal.core.dto.ReaderDto;
import com.igroup.bandesal.core.dto.request.bandesal.ReaderRequestDto;
import com.igroup.bandesal.core.entity.ContextData;
import com.igroup.bandesal.core.operation.BaseOperation;
import com.igroup.bandesal.core.request.ObjectRQ;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Dependent
public class ReaderOperation {
    private static final Logger LOG = LoggerFactory.getLogger(ReaderOperation.class);

    private final BaseOperation<ReaderRequestDto, ReaderDto> baseOperation;

    @Inject
    public ReaderOperation(BaseOperation<ReaderRequestDto, ReaderDto> baseOperation
                                  ) {
        this.baseOperation = baseOperation;
    }


    public ReaderDto execute(ObjectRQ<ReaderRequestDto> rq) {
        return baseOperation.execute(rq, this::doExecute, ReaderDto::new);
    }

    private ReaderDto doExecute(ObjectRQ<ReaderRequestDto> rq) {
        LOG.debug("App Version Verific");
        LOG.info("rq",rq);

        ReaderRequestDto request = rq.data();
        ContextData context = rq.context();

        return new ReaderDto();
    }


}
