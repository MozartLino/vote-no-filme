package br.com.lino.votenofilme.domain.model.video;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIDEO")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "VIDEO_GENERO", nullable = false, length = 40)
	private String genero;

	@Column(name = "VIDEO_SINOPSE", nullable = false, length = 40)
	private String sinopse;

	public Video(String genero, String sinopse) {
		this.genero = genero;
		this.sinopse = sinopse;
	}

	public Long getId() {
		return id;
	}

	public String getGenero() {
		return genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", genero=" + genero + ", sinopse="
				+ sinopse + "]";
	}

}
