package br.com.lino.votenofilme.application.service;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.vote.Vote;

@Component
public class VotesManager {

	private Session session;

	public VotesManager(Session session) {
		this.session = session;
	}

	public Votes from(User user) {
		session.save(user);

		return new Votes(session, user);
	}

	public class Votes {

		private User user;
		private Session session;

		private Votes(Session session, User user) {
			this.session = session;
			this.user = user;
		}

		public void addAll(List<Vote> votes) {
			for (Vote vote : votes) {
				vote.setUser(user);
				session.save(vote);
			}
		}
	}

}
