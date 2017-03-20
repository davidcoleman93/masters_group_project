package dao;

import javax.ejb.Local;
import java.util.HashSet;

/**
 * Created by david on 19/02/2017.
 */

@Local
public interface UserEventTypeDAOLocal {
    HashSet<Integer> getUserEventSet();
}
