package com.revature.repositories;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.domains.Superhuman;
import com.revature.exceptions.SuperhumanInsertionException;
import com.revature.util.SessionFactoryUtil;

public class SuperhumanRepoImpl implements SuperhumanRepo {
	
	private SessionFactory sf = SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory();
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Superhuman getSuperhumanByName(String name) {
		Session sess = sf.openSession();
		return sess.get(Superhuman.class, name);
	}

	@Override
	public List<Superhuman> getAllSuperhumans() {
		Session sess = sf.openSession();
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Superhuman> cq = cb.createQuery(Superhuman.class);
		Root<Superhuman> rootEntry = cq.from(Superhuman.class);
		CriteriaQuery<Superhuman> all = cq.multiselect(rootEntry);
		
		TypedQuery<Superhuman> allQuery = sess.createQuery(all);
		
		return allQuery.getResultList();
	}

	@Override
	public void addSuperhuman(Superhuman superhuman) throws SuperhumanInsertionException{
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(superhuman);
		tx.commit();
	}

	@Override
	public void updateSuperhuman(Superhuman superhuman) throws SuperhumanInsertionException {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(superhuman);
		tx.commit();
	}

	@Override
	public void deleteSuperhuman(Superhuman superhuman) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.delete(superhuman);
		tx.commit();
	}

}
