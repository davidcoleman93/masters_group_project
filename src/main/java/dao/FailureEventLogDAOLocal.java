package dao;

import entities.FailureEventLog;

/**
 * Created by C06590861 on 15/03/2017.
 */
public interface FailureEventLogDAOLocal {
    void addLogRecord(FailureEventLog feLog);
}
