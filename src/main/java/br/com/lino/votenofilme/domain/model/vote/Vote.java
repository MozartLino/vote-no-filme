package br.com.lino.votenofilme.domain.model.vote;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.lino.votenofilme.domain.model.movie.Movie;
import br.com.lino.votenofilme.domain.model.user.User;

@Entity
@Table(name = "VOTE")
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOTE_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MOVIE_ID", nullable = false)
	private Movie movie;

	public Vote(User user, Movie video) {
		this.user = user;
		this.movie = video;
	}
	
	protected Vote(){};

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Movie getVideo() {
		return movie;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", user=" + user + ", video=" + movie + "]";
	}

}
