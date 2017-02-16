package business;

import entities.test_entities.TableUn;

import java.util.List;

/**
 * Created by C06590861 on 15/02/2017.
 */
public interface TestBusinessLocal {
    void addRecord();
    List<TableUn> getAll();
}
