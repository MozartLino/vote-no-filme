package br.com.lino.votenofilme.infrastructure.persistence;

import br.com.caelum.vraptor.ioc.Component;
import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.user.UserRepository;

@Component
public class UserDAO implements UserRepository {

	@Override
	public void save(User user) {
		System.out.println(user);
	}

}
