package br.com.lino.votenofilme.infrastructure.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.lino.votenofilme.domain.model.user.User;
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

	@Override
	public List<Vote> getVotesBy(User user) {
		session.createCriteria(Vote.class).add(Restrictions.eq("user", user))
				.list();

		return null;
	}

}
