package br.com.lino.votenofilme.domain.model.user;

import java.util.List;

import br.com.lino.votenofilme.domain.model.user.User;
import br.com.lino.votenofilme.domain.model.vote.Vote;

public class UserVotes {

	private User user;
	private List<Vote> votes;

	public void setUser(User user) {
		this.user = user;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public User getUser() {
		return user;
	}

	public List<Vote> getVotes() {
		return votes;
	}
}