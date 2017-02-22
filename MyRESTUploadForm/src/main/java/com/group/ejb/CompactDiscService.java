package com.group.ejb;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.group.dao.CompactDiscDAOLocal;
import com.group.entities.CompactDisc;

@Stateless
@Local
public class CompactDiscService implements CompactDiscServiceLocal {
	
	@EJB
	private CompactDiscDAOLocal cdEjb;
	
	public List<CompactDisc> getAllDiscs() {
		return cdEjb.getAllDiscs();
	}

	public CompactDisc getDiscById(Integer id) {
		return cdEjb.getDiscById(id);
	}

	public void addDisc(CompactDisc disc) {
		cdEjb.addDisc(disc);
	}

	public void removeDisc(Integer id) {
		cdEjb.removeDisc(id);
		
	}

	public void updateDisc(CompactDisc disc) {
		cdEjb.updateDisc(disc);
		
	}

}
