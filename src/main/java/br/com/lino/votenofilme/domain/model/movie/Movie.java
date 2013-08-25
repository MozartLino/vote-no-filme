package br.com.lino.votenofilme.domain.model.movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "MOVIE")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MOVIE_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "MOVIE_NAME", nullable = false, length = 40)
	private String name;

	@Column(name = "MOVIE_GENERO", nullable = false, length = 20)
	private String genero;

	@Column(name = "MOVIE_SINOPSE", nullable = false, length = 500)
	private String sinopse;

	@Transient
	private int amountVotes;

	protected Movie() {};

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

	public int getAmountVotes() {
		return amountVotes;
	}

	public void setAmountVotes(int amountVotes) {
		this.amountVotes = amountVotes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genero=" + genero
				+ ", sinopse=" + sinopse + "]";
	}

}
