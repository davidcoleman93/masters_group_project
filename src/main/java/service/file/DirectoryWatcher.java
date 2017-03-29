package service.file;

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
//@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class DirectoryWatcher implements DirectoryWatcherLocal {

    /* Set Directory path to listen to */
    private static WatchService dirWatcher; //JAVA Watcher API.
    private static Path targetDirectory;
    private static WatchKey watcherKey; //The WatchKey determines the types of events to listen for.
    private static String DIR_PATH = "C:\\Code\\JEEProject\\masters_group_project\\Files";

    /*@EJB
    private CSVMediatorLocal csvEJB;
    @EJB
    private UserEventValidationEJBLocal userEventTypeEJB;
    @EJB
    private MarketOperatorValidationEJBLocal marketOperatorEJB;
    @EJB
    private FailureClassBusinessLocal failureClassEJB;
    @EJB
    private EventCauseValidationEJBLocal eventCauseEJB;*/
    @EJB
    private FailureEventBusinessLocal failureEventEJB;

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
                    String fileName = DIR_PATH + "\\" + ev.context();
                    //csvEJB.scanFirstLineCSV(file);
                    //WE WILL FIX THIS FOR SPRINT 2 -> MAYBE USE A MEDIATOR THAT SCANS THE FIRST LINE OF THE CSV???
                    /*if(fileName.contains("Event")){
                        synchronized (this){
                            eventCauseEJB.updateEventCause(fileName);
                        }
                    }
                    if(fileName.contains("Failure")){
                        synchronized (this){
                            failureClassEJB.updateFailureClasses(fileName);
                        }
                    }
                    if(fileName.contains("UE")){
                        synchronized (this){
                            userEventTypeEJB.updateUserEvent(fileName);
                        }
                    }
                    if(fileName.contains("MCC")){
                        synchronized (this){
                            marketOperatorEJB.updateMarketOperator(fileName);
                        }
                    }*/
                    if(fileName.contains("Base")){
                        synchronized (this){
                            failureEventEJB.postCSV(fileName);
                        }
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