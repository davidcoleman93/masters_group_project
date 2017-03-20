package dao;

import entities.FailureClass;
import entities.FailureEventLog;

import java.util.List;

/**
 * Created by C06590861 on 15/03/2017.
 */
public interface FailureEventLogDAOLocal {
    void addLogRecord(FailureEventLog feLog);
    void addFailureLogList(List<FailureEventLog> fes);
}
