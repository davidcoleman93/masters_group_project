package service;

import dao.FailureEventDAOLocal;
import entities.FailureEvent;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Created by C06590861 on 16/02/2017.
 */

@Local
@Stateless
public class FailureEventBusinessImpl implements FailureEventBusinessLocal {

	@Inject
	private FailureEventDAOLocal daoBean;

	@EJB
	private DataServiceLocal dataServiceEJB;

	@Resource
	private SessionContext session;

	public Collection<?> getAllFailureEvents() {

		return daoBean.getAllFailureEvents();

	}

	public void postCSV() {
		System.out.println("\n\n\nStart\n\n\n\n");
		String DIR_PATH = "/CSVTest/";

		String csvFile = DIR_PATH + "BaseData6.csv";

		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		System.out.println("Start");
		try {

			br = new BufferedReader(new FileReader(csvFile));
			// int count = 1;
			while ((line = br.readLine()) != null) {

				String[] fEvents = line.split(csvSplitBy);

				String startDateString = fEvents[0];

				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date dateTime = null;
				try {
					if (startDateString.contains("/")) {
						DateFormat srcDf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
						Date retrivedDate = srcDf.parse(startDateString);
						startDateString = df.format(retrivedDate);

					}

					dateTime = df.parse(startDateString);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Integer eventId = Integer.parseInt(fEvents[1]);
				Integer failureClass = Integer.parseInt(fEvents[2]);
				Integer ueType = Integer.parseInt(fEvents[3]);
				Integer market = Integer.parseInt(fEvents[4]);
				Integer operator = Integer.parseInt(fEvents[5]);
				Integer cellId = Integer.parseInt(fEvents[6]);
				Integer duration = Integer.parseInt(fEvents[7]);
				Integer causeCode = Integer.parseInt(fEvents[8]);
				String neVersion = fEvents[9];
				// BigInteger imsi = new BigInteger(fEvents[10]);
				long imsi = Long.parseLong(fEvents[10]);

				try {
					dataServiceEJB.addData(dateTime, neVersion, eventId, failureClass, ueType, market, operator, cellId,
							duration, causeCode, imsi);
				} catch (Exception e) {
					System.out.println("EXCEPTION FOUND: ");
				}
				// FailureEvent fEvent = new FailureEvent(dateTime, eventId,
				// failureClass, ueType, market, operator, cellId,
				// duration, causeCode, neVersion, imsi);

				// System.out.println("Added #" + count);
				// count++;

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("\n\n\nEnd\n\n\n\n");
	}

	public void addFailEvent(FailureEvent fEvent) {
		daoBean.addFailEvent(fEvent);

	}

}
