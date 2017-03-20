package service.file;

import entities.EventCause;
import entities.MarketOperator;
import service.data.*;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import java.io.*;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

/**
 * Created by C06590861 on 07/02/2017.
 */

@Local
@Singleton
public class DirectoryWatcher implements DirectoryWatcherLocal {

    /* Set Directory path to listen to */
    private static WatchService dirWatcher; //JAVA Watcher API.
    private static Path targetDirectory;
    private static WatchKey watcherKey; //The WatchKey determines the types of events to listen for.
    private static String DIR_PATH = "C:\\Code\\TestProject\\Files";

    @EJB
    private FailureEventBusinessLocal failureEventBean;
    @EJB
    private FailureClassBusinessLocal failureClassBean;

    @PostConstruct
    public void listen() {

        try {
            dirWatcher = FileSystems.getDefault().newWatchService();
            targetDirectory = Paths.get(DIR_PATH);
            targetDirectory.register(dirWatcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
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
                    //ATM WE SEND THE BASE DATA WORKBOOK
                    String file = DIR_PATH + "\\" + ev.context();
                    if(file.contains("Base")){
                        synchronized (this){
                            failureEventBean.postCSV(file);
                        }
                    }else if(file.contains("Event")){

                    }else if(file.contains("Failure")){
                        //failureClassBean.updateFailureClasses(file);
                    }else if(file.contains("UE")){

                    }else if(file.contains("MCC")){

                    }
                }
            }
            boolean valid = watcherKey.reset();
            if (!valid) {
                break;
            }
        }
    }
}