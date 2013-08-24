package br.com.lino.votenovideo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false)
	private String id;

	@Column(name = "USER_NAME", length = 50)
	private String name;

	@Column(name = "USER_EMAIL", unique = true, length = 40)
	private String email;

	public User(String id) {
		this.id = id;
	}

	public User(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
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