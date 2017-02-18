package file.handler;

/**
* @Author: Bobai Kato <bobaikato@gmail.com>
* @Github: BobaiKato
* @Project: ValidatingFiles
**/

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileListener {

	/* Set Directory path to listen to */

	public FileListener(String DIR_PATH) {

		/* Watch folder/Directory for new files */
		try {
			WatchService watcher = FileSystems.getDefault().newWatchService();
			Path directory = Paths.get(DIR_PATH);
			directory.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

			System.out.println("Watch Service for: " + directory.getFileName());

			while (true) {
				WatchKey key;
				try {
					key = watcher.take();
				} catch (InterruptedException ex) {
					return;
				}
				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent.Kind<?> actions = event.kind();

					@SuppressWarnings("unchecked")
					WatchEvent<Path> ev = (WatchEvent<Path>) event;
					Path fileName = ev.context();

					new FileConverter(DIR_PATH);
					System.out.println(actions.name() + ": " + fileName);

					// call a function here
				}

				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}