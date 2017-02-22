package com.group.dao;

import java.util.List;

import javax.ejb.Local;

import com.group.entities.CompactDisc;

@Local
public interface CompactDiscDAOLocal {
	public List<CompactDisc> getAllDiscs();
	public CompactDisc getDiscById(Integer id);
	public void addDisc(CompactDisc disc);
	public void removeDisc(Integer id);
	public void updateDisc(CompactDisc disc);
}
