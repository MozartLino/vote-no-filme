package br.com.lino.votenofilme.domain.model.movie;

import java.util.List;

import br.com.lino.votenofilme.domain.model.user.User;

public interface MovieRepository {

	public List<Movie> list();

	public List<Movie> ranking();

	public List<Movie> rankingBy(User user);
}
