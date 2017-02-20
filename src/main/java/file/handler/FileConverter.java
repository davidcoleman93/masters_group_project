/**
* @Author: Bobai Kato <bobaikato@gmail.com>
* @Github: BobaiKato
* @Project: ValidatingFiles
**/

package com.filelistener.main;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DateUtil;


public class FileConverter {

	/* List of Exentions */
	private static ArrayList<String> EXTENSIONS = new ArrayList<String>(Arrays.asList("xls", "xla", "xlam", "xlsb",
			"xlsm", "xlsx", "xlt", "xltm", "xltx", "xlw", "xlw", "xml", "xps"));

	/* Directory path to read from */
	FileConverter(String FILE_PATH) {

		InputStream FILE_INPUT = null;

				/* split filename from it's extension */
		String[] filename = FILE_PATH.split("\\.(?=[^\\.]+$)");

				/* matching defined filename (VALIDATE) */
		if (EXTENSIONS.contains(filename[1])) {

			try {
						/* Set Path */
				FILE_INPUT = new FileInputStream(filename[0] + "." + filename[1]);
				Workbook workbook = WorkbookFactory.create(FILE_INPUT);

						/* Calling the CSV handler */
				writeToFile(workbook.getSheetAt(0), filename[0] + ".csv");

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
			System.out.println("INVALID: " + filename[0] + "." + filename[1]);
		}
				/* do something here if its a csv file */
		if (filename[1].equals("csv")) {
			System.out.println("CSV FOUND: . . ." + filename[0] + "." + filename[1]);
		}
	}

	public static void writeToFile(Sheet sheet, String FILE_PATH) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(FILE_PATH));
		StringBuffer buffer = new StringBuffer();

		for(Row r : sheet){
			for(Cell c : r){

				switch(c.getCellType()){
					case Cell.CELL_TYPE_NUMERIC:
						if(DateUtil.isCellDateFormatted(c)){
							SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
							buffer.append(dt.format(c.getDateCellValue()) + ",");
							break;
						}
						buffer.append((long)c.getNumericCellValue() + ",");
						break;
					case Cell.CELL_TYPE_STRING:
						buffer.append(c.getStringCellValue() + ",");
						break;
				}

			}
			buffer.append("\n");
		}

		fos.write(buffer.toString().getBytes());
		fos.close();
	}
}
