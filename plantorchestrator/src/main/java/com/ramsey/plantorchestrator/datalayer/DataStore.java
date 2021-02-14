package com.ramsey.plantorchestrator.datalayer;

import java.util.Collection;

public interface DataStore<T>{
    /*
    @param t puts one t in the db
    */
    public void put(T t) throws DataLayerException;
    public void put( Collection<T> t) throws DataLayerException;
    public Collection<T> getAll() throws DataLayerException;
}