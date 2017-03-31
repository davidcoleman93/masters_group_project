package controller;

import service.file.DirectoryWatcherLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;

/**
 * Created by C06590861 on 23/02/2017.
 */

@Path("/file")
public class FILEController {

    @EJB
    private DirectoryWatcherLocal directoryWatcher;

    @POST
    @Path("/dir_watcher")
    public void runDirectoryWatcher(){
        System.out.println("HERE");
        directoryWatcher.listen();
    }

}
