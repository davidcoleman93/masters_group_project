package com.group.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group.entities.CompactDisc;


@Stateless
@Local
public class CompactDiscDAO implements CompactDiscDAOLocal{
	
	@PersistenceContext
	private EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<CompactDisc> getAllDiscs() {
		
		Query query = em.createQuery("from CompactDisc");
		List<CompactDisc> discs = query.getResultList();
		return discs;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public CompactDisc getDiscById(Integer id) {
		Query query = em.createQuery("from CompactDisc cd where cd.id = :id");
		query.setParameter("id", id);
		CompactDisc disc = (CompactDisc) query.getSingleResult();
		return disc;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addDisc(CompactDisc disc) {
//		Query query = em.createQuery("from CompactDisc");
//		List<CompactDisc> discs = query.getResultList(); 
//		if (!discs.contains(disc))
		em.persist(disc);
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeDisc(Integer id) {
		Query query = em.createQuery("from CompactDisc cd where cd.id = :id");
		query.setParameter("id", id);
		CompactDisc disc = (CompactDisc) query.getSingleResult();
		em.remove(disc);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateDisc(CompactDisc disc) {
		em.merge(disc);
		
	}
	
	

}
