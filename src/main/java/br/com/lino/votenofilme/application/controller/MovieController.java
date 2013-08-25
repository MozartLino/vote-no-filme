package br.com.lino.votenofilme.application.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.lino.votenofilme.domain.model.movie.MovieRepository;

@Resource
public class MovieController {

	private Result result;
	private MovieRepository movies;

	public MovieController(Result result, MovieRepository movies) {
		this.result = result;
		this.movies = movies;
	}

	@Get("/movies")
	public void list() {
		result.use(Results.json()).withoutRoot().from(movies.list()).serialize();
	}

	@Get("/ranking")
	public void ranking() {
		result.use(Results.json()).withoutRoot().from(movies.ranking()).serialize();
	}

}
