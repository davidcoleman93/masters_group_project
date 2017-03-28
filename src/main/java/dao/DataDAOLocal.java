package dao;

import entities.DataImportLog;

/**
 * Created by C06590861 on 23/02/2017.
 */
public interface DataDAOLocal {
    void addDataImport(DataImportLog log);
    void addDateTest(Test test);
}
