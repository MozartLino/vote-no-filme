package br.com.lino.votenofilme.domain.model.movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIDEO")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "VIDEO_NAME", nullable = false, length = 40)
	private String name;

	@Column(name = "VIDEO_GENERO", nullable = false, length = 40)
	private String genero;

	@Column(name = "VIDEO_SINOPSE", nullable = false, length = 40)
	private String sinopse;
	
	protected Movie(){};

	public Movie(String name, String genero, String sinopse) {
		this.name = name;
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

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genero=" + genero
				+ ", sinopse=" + sinopse + "]";
	}

}
