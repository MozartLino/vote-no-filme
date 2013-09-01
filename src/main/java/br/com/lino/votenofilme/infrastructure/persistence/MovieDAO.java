package br.com.lino.votenofilme.infrastructure.persistence;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.lino.votenofilme.domain.model.movie.Movie;
import br.com.lino.votenofilme.domain.model.movie.MovieRepository;
import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.vote.Vote;

@Component
public class MovieDAO implements MovieRepository {

	private Session session;

	public MovieDAO(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> list() {
		session.clear();
		return session.createCriteria(Movie.class).list();
	}

	public List<Movie> rankingBy(User user) {
		return ranking(user);
	}

	public List<Movie> ranking() {
		return ranking(null);
	}

	private List<Movie> ranking(User user) {
		List<Movie> movies = list();

		for (Movie movie : movies) {
			movie.setAmountVotes(countVote(user, movie));
		}

		return sortByVotes(movies);
	}

	private int countVote(User user, Movie movie) {
		Criteria criteria = session.createCriteria(Vote.class);
		criteria.setProjection(Projections.rowCount());
		criteria.add(Restrictions.eq("movie", movie));

		if (user != null)
			criteria.add(Restrictions.eq("user", user));

		Number count = (Number) criteria.uniqueResult();
		return count.intValue();
	}

	private List<Movie> sortByVotes(List<Movie> movies) {
		Collections.sort(movies, new Comparator<Movie>() {

			public int compare(Movie movie1, Movie movie2) {
				return movie2.getAmountVotes() - movie1.getAmountVotes();
			}
		});

		return movies;
	}

}