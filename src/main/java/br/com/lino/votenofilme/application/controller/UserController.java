package br.com.lino.votenofilme.application.controller;

import java.util.List;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.lino.votenofilme.application.service.VotesManager;
import br.com.lino.votenofilme.domain.model.movie.Movie;
import br.com.lino.votenofilme.domain.model.movie.MovieRepository;
import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.user.UserVotes;

@Resource
public class UserController {

	private Result result;
	private MovieRepository movies;
	private Validator validator;
	private VotesManager votesManager;

	public UserController(Result result, MovieRepository movies, Validator validator, VotesManager votesManager) {
		this.result = result;
		this.movies = movies;
		this.validator = validator;
		this.votesManager = votesManager;
	}

	@Get("/")
	public void index() {
	}

	@Get("/error")
	public void error() {
	}

	@Post("/users")
	@Consumes("application/json")
	public void update(UserVotes userVotes) {
		User user = userVotes.getUser();
		validator.validate(user);
		validator.onErrorSendBadRequest();
		
		votesManager.from(user).addAll(userVotes.getVotes());
		
		List<Movie> ranking = movies.ranking();
		
		List<Movie> rankingByUser = movies.rankingBy(user);

		result.use(Results.json()).withoutRoot().from(new Rankings(ranking, rankingByUser)).recursive().exclude("ranking.sinopse", "rankingByUser.sinopse").serialize();
	}
	
	@SuppressWarnings("unused")
	private class Rankings {
		List<Movie> ranking;
		List<Movie> rankingByUser;

		public Rankings(List<Movie> ranking, List<Movie> rankingByUser) {
			this.ranking = ranking;
			this.rankingByUser = rankingByUser;
		}
	}
}
