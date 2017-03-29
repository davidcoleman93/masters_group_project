package dao;

import com.google.common.collect.Multimap;
import entities.MarketOperator;
import entities.MarketOperatorID;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */
@Local
public interface MarketOperatorDAOLocal {
    Multimap<Integer, Integer> getMarketOpMap();
    void addMarketOperator(MarketOperator marketOperator);
}
