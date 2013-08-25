package br.com.lino.votenofilme.domain.model.vote;

import java.util.List;

import br.com.lino.votenofilme.domain.model.user.User;

public interface VoteRepository {

	public void save(Vote vote);

	public List<Vote> getVotesBy(User user);

}
