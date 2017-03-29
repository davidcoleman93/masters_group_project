package service.data;

import dao.UserEventTypeDAOLocal;
import entities.FailureClass;
import entities.UserEventType;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import java.io.File;
import java.util.HashSet;

/**
 * Created by david on 28/03/2017.
 */

@Local
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserEventValidationEJB implements UserEventValidationEJBLocal {

	@Inject
	private UserEventTypeDAOLocal userEventBean;

	public void updateUserEvent(String fileName) {
		File temp;
		LineIterator lineIterator = null;

		HashSet<Integer> userEventSet = null;
		int lineNum = 0;

		// Data types for User Event Types
		Integer tac;
		String marketingName;
		String manufacturer;
		String accessCapability;
		String model;
		String vendorName;
		String ueDevice;
		String operatingSystem;
		String inputMode;

		String[] fEvents;

		boolean error;

		try {
			temp = new File(fileName);
			lineIterator = FileUtils.lineIterator(temp, "UTF-8");
		} catch (Exception ioe) {
		}

		// Data structure to hold the primary keys
		try {
			userEventSet = userEventBean.getUserEventSet();
		} catch (Exception e) {
			System.out.println("ERROR IN PARSING FAILURE CLASS TO MULTIMAP");
		}

		try {
			System.out.println("STARTED");
			while (lineIterator.hasNext()) {
				fEvents = lineIterator.nextLine().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				if (lineNum == 0) {
					lineNum++;
				} else {
					tac = null;
					marketingName = null;
					manufacturer = null;
					accessCapability = null;
					model = null;
					vendorName = null;
					ueDevice = null;
					operatingSystem = null;
					inputMode = null;

					error = false;

					try {
						tac = Integer.parseInt(fEvents[0]);
					} catch (Exception e) {
						if (!error)
							error = true;
					}
					if (!userEventSet.contains(tac) && !error) {
						try {
							marketingName = fEvents[1];
						} catch (Exception e) {
							if (!error)
								error = true;
						}
						try {
							manufacturer = fEvents[2];
						} catch (Exception e) {
							if (!error)
								error = true;
						}
						try {
							accessCapability = fEvents[3];
							accessCapability = accessCapability.replaceAll("\"", "");
						} catch (Exception e) {
							if (!error)
								error = true;
						}
						try {
							model = fEvents[4];
						} catch (Exception e) {
							if (!error)
								error = true;
						}
						try {
							vendorName = fEvents[5];
						} catch (Exception e) {
							if (!error)
								error = true;
						}
						try {
							ueDevice = fEvents[6];
						} catch (Exception e) {
							if (!error)
								error = true;
						}
						try {
							operatingSystem = fEvents[7];
						} catch (Exception e) {
							if (!error)
								error = true;
						}
						try {
							inputMode = fEvents[8];
						} catch (Exception e) {
							if (!error)
								error = true;
						}

						if (!error) {
							userEventBean.addUserEventType(new UserEventType(tac, marketingName, manufacturer,
									accessCapability, model, vendorName, ueDevice, operatingSystem, inputMode));
						}
					}
				}
			}
		} finally {
			LineIterator.closeQuietly(lineIterator);
		}
		System.out.println("COMPLETED");
	}
}
