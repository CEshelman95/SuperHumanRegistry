package com.revature.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.revature.domains.Superhuman;
import com.revature.exceptions.SuperhumanInsertionException;
import com.revature.repositories.SuperhumanRepoImpl;

@RunWith(MockitoJUnitRunner.class)
public class SuperhumanRepoTest {
	
	@Mock
	SessionFactory sf;
	
	@Mock
	Session sess;
	
	@Mock
	Transaction tx;
	
	private SuperhumanRepoImpl superRepo = new SuperhumanRepoImpl();
	
	private Superhuman superhuman;
	
	private List<Superhuman> superList = new ArrayList<Superhuman>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		superhuman = new Superhuman("Spiderman", 1);
		superList.add(superhuman);
		superList.add(new Superhuman("Captain America", 1));
		superList.add(new Superhuman("Iron Man", 1));
		superList.add(new Superhuman("Thanos", 3));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getSuperhumanByNameTest() {
		when(sf.openSession()).thenReturn(sess);
		when(sess.get(Superhuman.class, "Spiderman")).thenReturn(superhuman);
		superRepo.setSf(sf);
		assertEquals("should return expected super", superhuman, superRepo.getSuperhumanByName("Spiderman"));
	}
	
	@Test
	@Ignore
	public void getAllSuperhumansTest() {
		when(sf.openSession()).thenReturn(sess);
		superRepo.setSf(sf);
		assertEquals("should return expected list of supers", superList, superRepo.getAllSuperhumans());
	}
	
	@Test
	public void updateSuperhumanTest() throws SuperhumanInsertionException {
		when(sess.beginTransaction()).thenReturn(tx);
		when(sf.openSession()).thenReturn(sess);
		superRepo.setSf(sf);
		superRepo.updateSuperhuman(superhuman);
		verify(sess).saveOrUpdate(superhuman);
	}
	
	@Test
	public void addSuperhumanTest() throws SuperhumanInsertionException {
		when(sess.beginTransaction()).thenReturn(tx);
		when(sf.openSession()).thenReturn(sess);
		superRepo.setSf(sf);
		superRepo.addSuperhuman(superhuman);
		verify(sess).save(superhuman);
	}
	
	@Test
	public void deleteSuperhuman() {
		when(sess.beginTransaction()).thenReturn(tx);
		when(sf.openSession()).thenReturn(sess);
		superRepo.setSf(sf);
		superRepo.deleteSuperhuman(superhuman);
		verify(sess).delete(superhuman);
	}

}
