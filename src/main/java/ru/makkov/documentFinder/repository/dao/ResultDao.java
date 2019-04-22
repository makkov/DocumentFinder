package ru.makkov.documentFinder.repository.dao;

import ru.makkov.documentFinder.pojo.Result;

/**
 * ensuring persistence of object "result"
 */
public interface ResultDao {

    /**
     * @param result - returned by the service
     * @param number - the search-query param
     * @return true if successfully recorded in the database, false - otherwise
     */
    boolean addResult(Result result, Integer number);
}
