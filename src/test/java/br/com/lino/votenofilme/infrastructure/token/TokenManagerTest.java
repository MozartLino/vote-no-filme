package br.com.lino.votenofilme.infrastructure.token;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

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
		Long token = manager.retrieveActualToken();

		assertFalse("Não gerou novo token", isNull(token));
	}

	@Test
	public void shouldntGenerateNewToken() {
		when(request.getParameter("token")).thenReturn("1");
		Long token = manager.retrieveActualToken();

		assertTrue("Não utilizou o mesmo token", 1 == token);
	}

	private boolean isNull(Long token) {
		return token == null;
	}

}