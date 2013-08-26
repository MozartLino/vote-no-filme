package br.com.lino.votenofilme.infrastructure.persistence;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lino.votenofilme.domain.model.movie.Movie;
import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.vote.Vote;
import br.com.lino.votenofilme.infrastructure.util.HibernateUtil;

public class MovieDAOTest {

	private Session session;
	private User user;
	private Movie matrix;
	private Movie theAvengers;
	private Movie ironMan;
	private MovieDAO movieDAO;
	private User anotherUser;

	@Test
	public void shouldOrderMoviesByVotes() {
		session.save(createMovie(user, ironMan)); // matrix x ironMan
		session.save(createMovie(user, theAvengers)); // matrix x theAvengers
		session.save(createMovie(user, theAvengers)); // theAvengers x ironMan
		List<Movie> movies = movieDAO.ranking();

		assertEquals("Filme The Avengers deveria ser o primeiro da lista", theAvengers, movies.get(0));
		assertEquals("Filme Matrix deveria ser o último da lista", 2, movies.lastIndexOf(matrix));
	}

	@Test
	public void shouldOrderMoviesByVotesWithUser() {
		session.save(createMovie(anotherUser, matrix)); // matrix x ironMan
		session.save(createMovie(anotherUser, matrix)); // matrix x theAvengers
		session.save(createMovie(anotherUser, ironMan)); // theAvengers x
															// ironMan
		List<Movie> movies = movieDAO.rankingBy(anotherUser);

		assertEquals("Filme Matrix deveria ser o primeiro da lista", matrix, movies.get(0));
		assertEquals("Filme The Avengers deveria ser o último da lista", 2, movies.lastIndexOf(theAvengers));
	}

	private Vote createMovie(User user, Movie movie) {
		return new Vote(user, movie);
	}

	@Before
	public void setUp() {
		session = HibernateUtil.currentSession();
		HibernateUtil.beginTransaction();

		movieDAO = new MovieDAO(session);

		user = new User(1L);
		anotherUser = new User(2L);
		matrix = new Movie("matrix", "genero1", "sinopse1");
		theAvengers = new Movie("The Avengers", "genero2", "sinopse2");
		ironMan = new Movie("Iron Man", "genero2", "sinopse2");

		session.save(user);
		session.save(anotherUser);
		session.save(matrix);
		session.save(ironMan);
		session.save(theAvengers);
	}

	@After
	public void setDown() {
		HibernateUtil.rollbackTransaction();
		HibernateUtil.closeSession();
	}

}
