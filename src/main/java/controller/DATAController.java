package controller;

import service.file.DirectoryWatcherLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;

/**
 * Created by C06590861 on 23/02/2017.
 */

@Path("/data")
public class DATAController {

    @EJB
    private DirectoryWatcherLocal directoryWatcher;

    @POST
    @Path("/dir_watcher")
    public void runDirectoryWatcher(){
        //DirectoryListener.getInstance().setDIR_PATH("Files");
        directoryWatcher.listen();
    }

}
