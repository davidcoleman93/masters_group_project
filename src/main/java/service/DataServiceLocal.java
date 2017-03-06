package service;

import java.util.Collection;
import java.util.Date;

/**
 * Created by C06590861 on 23/02/2017.
 */
public interface DataServiceLocal {
	public void addData(Date date, String neVersion, Integer eventID, Integer failureClass, Integer ueType,
			Integer market, Integer operator, Integer cellID, Integer duration, Integer causeCode, long imsi);

	Collection<?> getCallFailures();
}
