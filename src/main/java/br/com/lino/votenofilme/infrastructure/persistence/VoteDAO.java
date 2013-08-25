package br.com.lino.votenofilme.infrastructure.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.lino.votenofilme.domain.model.vote.Vote;
import br.com.lino.votenofilme.domain.model.vote.VoteRepository;

@Component
public class VoteDAO implements VoteRepository {

	private Session session;

	public VoteDAO(Session session) {
		this.session = session;
	}

	@Override
	public void save(Vote vote) {
		session.save(vote);
	}
}
