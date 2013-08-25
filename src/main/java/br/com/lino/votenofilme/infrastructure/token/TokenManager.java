package br.com.lino.votenofilme.infrastructure.token;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class TokenManager {

	private HttpServletRequest request;
	private Long token;

	public TokenManager(HttpServletRequest request) {
		this.request = request;
	}

	public Long retrieveActualToken() {
		if (thereIsNoTokenAvailable()) {
			createNewToken();
		}

		return token;
	}

	private void createNewToken() {
		token = Calendar.getInstance().getTimeInMillis();
	}

	private boolean thereIsNoTokenAvailable() {
		String parameter = request.getParameter("token");

		if (request.getParameter("token") != null) {
			token = Long.parseLong(parameter);

			return false;
		}

		return true;
	}
}
