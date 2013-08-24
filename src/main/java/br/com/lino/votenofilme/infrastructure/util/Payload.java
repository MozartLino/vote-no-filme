package br.com.lino.votenofilme.infrastructure.util;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lino.votenofilme.domain.model.movie.Movie;

public class Payload {

	private Session session;

	@Test
	public void init() {
		session.save(new Movie("Filme1", "Genero1", "Sinopse1"));
		session.save(new Movie("Filme2", "Genero2", "Sinopse2"));
		session.save(new Movie("Filme3", "Genero3", "Sinopse3"));
		session.save(new Movie("Filme4", "Genero4", "Sinopse4"));
		session.save(new Movie("Filme5", "Genero5", "Sinopse5"));
	}

	@Before
	public void setUp() {
		session = HibernateUtil.currentSession();
		HibernateUtil.beginTransaction();
	}

	@After
	public void setDown() {
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}

}