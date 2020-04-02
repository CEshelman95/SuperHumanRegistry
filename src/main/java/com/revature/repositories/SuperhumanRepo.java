package com.revature.repositories;

import java.util.List;

import com.revature.domains.Superhuman;
import com.revature.exceptions.SuperhumanInsertionException;

public interface SuperhumanRepo {
	
	public Superhuman getSuperhumanByName(String name);
	
	public List<Superhuman> getAllSuperhumans();
	
	public void addSuperhuman(Superhuman superhuman) throws SuperhumanInsertionException;
	
	public void updateSuperhuman(Superhuman superhuman) throws SuperhumanInsertionException;
	
	public void deleteSuperhuman(Superhuman superhuman);
	
}
