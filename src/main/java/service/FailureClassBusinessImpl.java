package service;

import dao.FailureClassDAOLocal;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Local
@Stateless
public class FailureClassBusinessImpl implements FailureClassBusinessLocal {

	@Inject
	private FailureClassDAOLocal daoBean;

	@Resource
	private SessionContext session;

	public Collection<?> getAllFailureClasses() {
		return daoBean.getAllFailureClasses();
	}

}
