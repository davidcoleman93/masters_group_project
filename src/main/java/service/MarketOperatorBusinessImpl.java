package service;

import dao.MarketOperatorDAOLocal;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by david on 19/02/2017.
 */

@Local
@Stateless
public class MarketOperatorBusinessImpl implements MarketOperatorBusinessLocal {

	@Inject
	private MarketOperatorDAOLocal daoBean;

	@Resource
	private SessionContext session;

	public Collection<?> getAllMarketOperators() {

		return daoBean.getAllMarketOperators();

	}

}
