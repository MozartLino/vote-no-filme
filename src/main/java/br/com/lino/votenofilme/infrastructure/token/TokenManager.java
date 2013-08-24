package br.com.lino.votenofilme.infrastructure.token;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class TokenManager {

	private HttpServletRequest request;
	private String token;

	public TokenManager(HttpServletRequest request) {
		this.request = request;
	}

	public String retrieveActualToken() {
		if (thereIsNoTokenAvailable()) {
			createNewToken();
		}

		return token;
	}

	private void createNewToken() {
		token = UUID.randomUUID().toString();
	}

	private boolean thereIsNoTokenAvailable() {
		token = request.getParameter("token");

		return token == null;
	}
}
