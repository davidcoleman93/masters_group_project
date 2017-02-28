package service;

import java.util.Collection;

/**
 * Created by C06590861 on 23/02/2017.
 */
public interface DataServiceLocal {
    void addData();
    Collection<?> getCallFailures();
}
