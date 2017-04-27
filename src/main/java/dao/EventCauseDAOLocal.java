package dao;

import com.google.common.collect.Multimap;
import entities.EventCause;
import entities.EventCauseID;

import javax.ejb.Local;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface EventCauseDAOLocal {
    Multimap<Integer, Integer> getEventCauseMap();
    void addEventCause(EventCause eventCause);
    Collection<?> allEventCauses();
}
