package service.file;

import javax.ejb.Local;

/**
 * Created by C06590861 on 01/03/2017.
 */

@Local
public interface DirectoryWatcherLocal {
    void listen();
}
