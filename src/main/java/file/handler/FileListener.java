package com.filelistener.main;

import java.io.*;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * Created by C06590861 on 07/02/2017.
 */

public class FileListener {

	/* Set Directory path to listen to */
	private WatchService watcher; //JAVA Watcher API.
    private Path targetDirectory;
    private WatchKey key; //The WatchKey determines the types of events to listen for.
    private String DIR_PATH;

    public FileListener(String DIR_PATH){
    	this.DIR_PATH = DIR_PATH;
    }


	public void listen() {

		try {
            watcher = FileSystems.getDefault().newWatchService();
        } catch (IOException e) {
            e.printStackTrace();
        }

		//POLL THE SYSTEM FOR CHANGES ON THE DIRECTORY
        //OR IS IT THIS
        //ONCE THE SYSTEM ADMIN UPLOADS A FILE ...................
		try {

			targetDirectory = Paths.get(DIR_PATH);
			targetDirectory.register(watcher, ENTRY_CREATE, ENTRY_DELETE);

			while (true) {

				//Files will be received and the following happens: (ENTRY_CREATE)
                //1. The file is checked for a valid file type -> xls, xlsx, csv
                //2. Three paths are followed here:
                //      (a) VALID: Check if csv? [No  ->  Convert the file to csv]
                //                 Send the data to the database
                //      (b) INVALID: Ignore the file and send to be deleted.
                //3. The file is then deleted. (ENTRY_DELETE)
				try {

					key = watcher.take();

				} catch (InterruptedException ex) {
					return;
				}

				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent.Kind<?> eventKind = event.kind();

					@SuppressWarnings("unchecked")
					WatchEvent<Path> ev = (WatchEvent<Path>) event;

					if (eventKind == ENTRY_CREATE) {

	                    //VALIDATE FILE TYPE .xls/.csv etc....
	                    //SEND FILE NAME TO BOBAI's VALIDATOR
						new FileConverter(DIR_PATH + "/" + ev.context());

                	}					

				}

				if (!key.reset()) {
					break;
				}

			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}