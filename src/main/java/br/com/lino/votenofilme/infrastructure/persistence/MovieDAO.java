package br.com.lino.votenofilme.infrastructure.persistence;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.lino.votenofilme.domain.model.movie.Movie;
import br.com.lino.votenofilme.domain.model.movie.MovieRepository;

@Component
public class MovieDAO implements MovieRepository {
	
	private Session session;

	public MovieDAO(Session session) {
		this.session = session;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Movie> list() {
		return session.createCriteria(Movie.class).list();
	}

}