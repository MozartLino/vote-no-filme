package br.com.lino.votenofilme.application.controller;

import org.hibernate.Session;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.lino.votenofilme.domain.model.vote.Vote;
import br.com.lino.votenofilme.domain.model.vote.VoteRepository;

@Resource
public class VoteController {

	private Result result;
	private VoteRepository votes;

	public VoteController(Result result, VoteRepository votes, Session session) {
		this.result = result;
		this.votes = votes;
	}

	@Post("/votes")
	@Consumes("application/json")
	public void save(Vote vote) {
		votes.save(vote);
		result.nothing();
	}
}