package br.com.lino.votenofilme.infrastructure.token;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

import br.com.lino.votenofilme.infrastructure.token.TokenManager;

public class TokenManagerTest {

	private TokenManager manager;
	private HttpServletRequest request;

	@Before
	public void setUp() {
		request = mock(HttpServletRequest.class);
		manager = new TokenManager(request);
	}

	@Test
	public void shouldGenerateNewToken() {
		when(request.getParameter("token")).thenReturn(null);
		String token = manager.retrieveActualToken();

		assertFalse("Não gerou novo token", isNullOrEmpty(token));
	}

	@Test
	public void shouldntGenerateNewToken() {
		when(request.getParameter("token")).thenReturn("abcde-12345");
		String token = manager.retrieveActualToken();

		assertEquals("Não utilizou o mesmo token", "abcde-12345", token);
	}

	private boolean isNullOrEmpty(String token) {
		return token == null || token.isEmpty();
	}

}