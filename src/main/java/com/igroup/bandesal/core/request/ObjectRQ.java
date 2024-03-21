package com.igroup.bandesal.core.request;


import com.igroup.bandesal.core.entity.ContextData;

public interface ObjectRQ<T extends Request> {
    public ContextData context();
    public T data();
}
    
