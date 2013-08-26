package br.com.lino.votenofilme.infrastructure.persistence;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.user.UserRepository;

@Component
public class UserDAO implements UserRepository {

	private Session session;

	public UserDAO(Session session) {
		this.session = session;
	}

	public void save(User user) {
		session.save(user);
	}

	public void update(User user) {
		session.update(user);
	}

}