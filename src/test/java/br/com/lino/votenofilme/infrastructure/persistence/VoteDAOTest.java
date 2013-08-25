package br.com.lino.votenofilme.infrastructure.persistence;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lino.votenofilme.domain.model.movie.Movie;
import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.vote.Vote;
import br.com.lino.votenofilme.infrastructure.util.HibernateUtil;

public class VoteDAOTest {

	private Session session;
	private User ricardo;
	private User blueSoft;
	private VoteDAO voteDAO;

	@Test
	public void shouldListVotesByUser() {
		voteDAO.getVotesBy(ricardo);
	}

	@Before
	public void setUp() {
		session = HibernateUtil.currentSession();
		HibernateUtil.beginTransaction();

		voteDAO = new VoteDAO(session);

		ricardo = new User("abcde-12345", "ricardo", "ricardo.mozart@gmail.com");
		blueSoft = new User("fghij-67890", "blueSoft", "blueSoft@gmail.com");
		Movie theAvengers = new Movie("The Avengers", "genero1", "sinopse1");

		Vote ricardoVote = new Vote(ricardo, theAvengers);
		Vote blueSoftVote = new Vote(blueSoft, theAvengers);

		session.save(ricardo);
		session.save(blueSoft);
		session.save(theAvengers);
		session.save(ricardoVote);
		session.save(blueSoftVote);
	}

	@After
	public void setDown() {
		HibernateUtil.rollbackTransaction();
		HibernateUtil.closeSession();
	}

}
