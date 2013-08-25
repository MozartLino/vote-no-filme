package br.com.lino.votenofilme.domain.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long id;

	@Length(max = 50, min = 10, message = "{user.name.length}")
	private String name;

	@Email(message = "{user.email}")
	private String email;

	public User(Long id) {
		this.id = id;
	}

	public User(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}