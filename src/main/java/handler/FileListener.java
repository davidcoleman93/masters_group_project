package handler;

import java.io.*;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

/**
 * Created by C06590861 on 07/02/2017.
 */
public class FileListener {

	protected WatchService watcher; // JAVA Watcher API.
	protected Path targetDirectory;
	protected WatchKey key; // The WatchKey determines the types of events to
							// listen for.

	public FileListener() {

		try {

			watcher = FileSystems.getDefault().newWatchService();

		} catch (IOException e) {

			e.printStackTrace();

		}

		// POLL THE SYSTEM FOR CHANGES ON THE DIRECTORY
		// OR IS IT THIS
		// ONCE THE SYSTEM ADMIN UPLOADS A FILE ...................
		while (true) {

			targetDirectory = Paths.get("/Users/bobaikato/Documents/project/"); // DIRECTORY WHICH WILL STORE
													// THE FILES

			try {

				// Files will be received and the following happens:
				// (ENTRY_CREATE)
				// 1. The file is checked for a valid file type -> xls, xlsx,
				// csv
				// 2. Three paths are followed here:
				// (a) VALID: Check if csv? [No -> Convert the file to csv]
				// Send the data to the database
				// (b) INVALID: Ignore the file and send to be deleted.
				// 3. The file is then deleted. (ENTRY_DELETE)
				key = targetDirectory.register(watcher, ENTRY_CREATE, ENTRY_DELETE);

			} catch (IOException e) {

				e.printStackTrace();

			}

			//
			for (WatchEvent<?> event : key.pollEvents()) {

				// The type of event
				WatchEvent.Kind<?> kind = event.kind();

				// The file name
				WatchEvent<Path> ev = (WatchEvent<Path>) event;

				if (kind == ENTRY_CREATE) {

					// VALIDATE FILE TYPE .xls/.csv etc....
					// SEND FILE NAME TO BOBAI's VALIDATOR
					/* ev.context() to get file name */

				}
			}
		}
	}
}
