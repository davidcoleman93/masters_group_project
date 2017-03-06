package dao;

import entities.DataImportLog;
import entities.FailureEvent;

import java.util.Collection;

/**
 * Created by C06590861 on 23/02/2017.
 */
public interface DataDAOLocal {
	void addFailureEvent(FailureEvent fe);

	Collection<?> getCallFailures();

	void addDataImport(DataImportLog log);
}
