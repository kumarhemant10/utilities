package com.hk.prj.jsontocsv.datamapper;

/**
 * implement this class for data mapping from json to required format
 * @param <T>
 */
public interface DataMapper<T> {
    T map(Object o);
}
