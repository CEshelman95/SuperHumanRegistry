package com.revature.services;

import java.util.List;

import com.revature.domains.Superhuman;
import com.revature.exceptions.SuperhumanInsertionException;

public interface SuperhumanService {
	
	public List<Superhuman> getAllSuperhumans();
	
	public Superhuman getSuperhumanByName(String name);
	
	public void addSuperhuman(Superhuman superhuman) throws SuperhumanInsertionException;
	
	public void updateSuperhuman(Superhuman superhuman) throws SuperhumanInsertionException;
	
	public void deleteSuperhuman(Superhuman superhuman);
	
}
