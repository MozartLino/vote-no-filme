package br.com.lino.votenofilme.application.controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.lino.votenofilme.domain.model.movie.MovieRepository;
import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.user.UserRepository;
import br.com.lino.votenofilme.infrastructure.token.TokenManager;

@Resource
public class UserController {

	private Result result;
	private UserRepository users;
	private MovieRepository movies;
	private Long token;
	private Validator validator;

	public UserController(Result result, UserRepository users, MovieRepository movies, TokenManager tokenManager, Validator validator) {
		this.result = result;
		this.users = users;
		this.movies = movies;
		this.validator = validator;
		this.token = tokenManager.retrieveActualToken();
	}

	@Get("/")
	public void index() {
	}

	@Get("/users/token")
	public void save() {
		users.save(new User(token));

		result.use(Results.json()).withoutRoot().from(token).serialize();
	}

	@Put("/users")
	@Consumes("application/json")
	public void update(User user) {
		validator.validate(user);
		validator.onErrorSendBadRequest();
		
		users.update(user);
		result.use(Results.json()).withoutRoot().from(movies.rankingBy(user)).serialize();
	}

}
