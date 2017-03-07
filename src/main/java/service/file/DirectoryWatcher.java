package service.file;

import service.data.FailureEventBusinessLocal;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.*;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * Created by C06590861 on 07/02/2017.
 */

@Local
@Stateless
public class DirectoryWatcher implements DirectoryWatcherLocal {

    /* Set Directory path to listen to */
    private static WatchService dirWatcher; //JAVA Watcher API.
    private static Path targetDirectory;
    private static WatchKey watcherKey; //The WatchKey determines the types of events to listen for.
    private static String DIR_PATH = "/home/bobaikato/workspace/Group3Project/masters_group_project/csvfiledir/";

    @EJB
    private FailureEventBusinessLocal failureEventBean;

    public void listen() {

        System.out.println("LISTENING");

        try {
            dirWatcher = FileSystems.getDefault().newWatchService();
            targetDirectory = Paths.get(DIR_PATH);
            targetDirectory.register(dirWatcher, ENTRY_CREATE, ENTRY_DELETE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //POLL THE SYSTEM FOR CHANGES ON THE DIRECTORY
        //OR IS IT THIS
        //ONCE THE SYSTEM ADMIN UPLOADS A FILE ...................
        while (true) {
            try {
                watcherKey = dirWatcher.take();
            } catch (InterruptedException ex) {
                return;
            }
            for (WatchEvent<?> event : watcherKey.pollEvents()) {

                WatchEvent.Kind<?> eventKind = event.kind();

                @SuppressWarnings("unchecked")
                WatchEvent<Path> ev = (WatchEvent<Path>) event;

                if (eventKind == ENTRY_CREATE) {
                    //VALIDATE FILE TYPE .xls/.csv etc....

                    String file = DIR_PATH + "//" + ev.context();
                    System.out.println(file);
                    //ATM WE SEND THE BASE DATA WORKBOOK
                    failureEventBean.postCSV(file);
                }
            }
            boolean valid = watcherKey.reset();
            if (!valid) {
                break;
            }
        }
    }
}