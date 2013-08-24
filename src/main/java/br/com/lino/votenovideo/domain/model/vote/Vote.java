package br.com.lino.votenovideo.domain.model.vote;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.lino.votenovideo.domain.model.user.User;
import br.com.lino.votenovideo.domain.model.video.Video;

@Entity
@Table(name = "VOTE")
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VIDEO_ID", nullable = false)
	private Video video;

	public Vote(User user, Video video) {
		this.user = user;
		this.video = video;
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Video getVideo() {
		return video;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", user=" + user + ", video=" + video + "]";
	}

}
