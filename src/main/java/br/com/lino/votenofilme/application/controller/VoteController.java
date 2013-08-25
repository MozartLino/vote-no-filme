package br.com.lino.votenofilme.application.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.lino.votenofilme.domain.model.movie.MovieRepository;
import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.user.UserRepository;
import br.com.lino.votenofilme.domain.model.vote.Vote;
import br.com.lino.votenofilme.domain.model.vote.VoteRepository;
import br.com.lino.votenofilme.infrastructure.token.TokenManager;

@Resource
public class VoteController {

	private UserRepository users;
	private Result result;
	private String token;
	private MovieRepository movies;
	private VoteRepository votes;

	public VoteController(Result result, VoteRepository votes,
			MovieRepository movies, UserRepository users,
			TokenManager tokenManager) {
		this.result = result;
		this.votes = votes;
		this.movies = movies;
		this.users = users;
		this.token = tokenManager.retrieveActualToken();
	}

	@Get("/")
	public void index() {
		users.save(new User(token));

		result.include("movies", movies.list());
		result.include("token", token);
	}

	@Post("/vote")
	public void save(Vote vote) {
		votes.save(vote);
		result.nothing();
	}

	@Put("/users")
	public void update(User user) {
		users.update(user);

		result.include("userRanking", votes.getVotesBy(user));
		result.include("ranking", movies.ranking());
		result.include("userRanking", movies.rankingBy(user));
	}

}