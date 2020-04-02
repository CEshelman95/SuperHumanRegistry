package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.domains.Superhuman;
import com.revature.exceptions.SuperhumanInsertionException;
import com.revature.repositories.SuperhumanRepo;

@Service
public class SuperhumanServiceImpl implements SuperhumanService {
	
	private SuperhumanRepo superRepo;
	
	@Autowired
	public void setSuperhumanRepo(SuperhumanRepo superRepo) {
		this.superRepo = superRepo;
	}
	
	@Override
	public List<Superhuman> getAllSuperhumans() {
		return superRepo.getAllSuperhumans();
	}

	@Override
	public Superhuman getSuperhumanByName(String name) {
		return superRepo.getSuperhumanByName(name);
	}

	@Override
	public void addSuperhuman(Superhuman superhuman) throws SuperhumanInsertionException {
		superRepo.addSuperhuman(superhuman);
	}

	@Override
	public void updateSuperhuman(Superhuman superhuman) throws SuperhumanInsertionException {
		superRepo.updateSuperhuman(superhuman);
	}

	@Override
	public void deleteSuperhuman(Superhuman superhuman) {
		superRepo.deleteSuperhuman(superhuman);
	}

}
