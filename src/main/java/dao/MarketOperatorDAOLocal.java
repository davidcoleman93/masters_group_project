package dao;

import entities.MarketOperator;
import entities.MarketOperatorID;

import javax.ejb.Local;
import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */
@Local
public interface MarketOperatorDAOLocal {
	Collection<?> getAllMarketOperators();

	MarketOperator getMarketOperator(MarketOperatorID marketOperatorID);

	boolean checkMarketOperator(MarketOperatorID marketOperatorID);
}
