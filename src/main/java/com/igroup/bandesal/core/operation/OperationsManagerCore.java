package com.igroup.bandesal.core.operation;

import com.igroup.bandesal.core.operation.bandesal.ReaderOperation;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class OperationsManagerCore implements OperationsManager {


    private final ReaderOperation readerOperation;


    @Inject
    public OperationsManagerCore(ReaderOperation readerOperation) {
        this.readerOperation = readerOperation;
    }


    @Override
    public ReaderOperation getReaderOperation() {
        return readerOperation;
    }
}
