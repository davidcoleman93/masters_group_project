/**
* @Author: Bobai Kato <bobaikato@gmail.com>
* @Github: BobaiKato
* @Project: ValidatingFiles
**/

package file.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileConverter {
	/// Users/bobaikato/Documents/project/
	/* List of Exentions */
	private static ArrayList<String> EXTENSIONS = new ArrayList<String>(Arrays.asList("xls", "xla", "xlam", "xlsb", "xlsm",
			"xlsx", "xlt", "xltm", "xltx", "xlw", "xlw", "xml", "xps"));

	/* Directory path to read from */

	FileConverter(String DIR_PATH) {

		File folder = new File(DIR_PATH);
		File[] listOfFiles = folder.listFiles();
		InputStream FILE_INPUT = null;
		for (File file : listOfFiles) {
			if (file.isFile()) {
				/* split filename from it's extension */
				String[] filename = file.getName().split("\\.(?=[^\\.]+$)");

				/* matching defined filename (VALIDATE) */
				if (EXTENSIONS.contains(filename[1])) {

					/* Output the paths */
					System.out.println("\n" + DIR_PATH + filename[0] + "." + EXTENSIONS.get(0));
					try {
						/* Set Path */
						FILE_INPUT = new FileInputStream(DIR_PATH + filename[0] + "." + filename[1]);
						Workbook workbook = WorkbookFactory.create(FILE_INPUT);

						for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
							// System.out.println(workbook.getSheetAt(i).getSheetName());

							/* Calling the CSV handler */
							writeToFile(workbook.getSheetAt(i), DIR_PATH + filename[0] + ".csv");
						}
					} catch (InvalidFormatException ex) {
						Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
					} catch (FileNotFoundException ex) {
						Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
					} catch (IOException ex) {
						Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
					} finally {
						try {
							FILE_INPUT.close();
						} catch (IOException ex) {
							Logger.getLogger(FileConverter.class.getName()).log(Level.SEVERE, null, ex);
						}
					}
				}
				/* Catching the invalid files */
				else if (!EXTENSIONS.contains(filename[1]) && !filename[1].equals("csv")) {
					System.out.println("INVALID: " + DIR_PATH + filename[0] + "." + filename[1]);
				}
				/* do something here if its a csv file */
				if (filename[1].equals("csv")) {
					System.out.println("CSV FOUND: . . ." + DIR_PATH + filename[0] + "." + filename[1]);
				}
			}
		}
	}

	public static void writeToFile(Sheet sheet, String FULL_DIR_PATH) throws IOException {
		Row row = null;
		File folder = new File(FULL_DIR_PATH);
		// creates the file
		folder.createNewFile();
		// creates a FileWriter Object
		FileWriter writer = new FileWriter(folder);

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Writes the content to the file
				writer.write(row.getCell(j) + ",");
				System.out.print(row.getCell(j) + ",");
			}
			writer.write("\n");
			System.out.println();
		}
		writer.flush();
		writer.close();
	}

	// "99.0";"Jane";"Mcdonald";"Female";"Female";
	/*public static void main(String[] args) throws IOException {

		new FileConverter("/Users/bobaikato/Documents/project/");
	}*/
}
