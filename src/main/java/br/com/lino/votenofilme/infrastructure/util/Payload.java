package br.com.lino.votenofilme.infrastructure.util;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lino.votenofilme.domain.model.movie.Movie;

public class Payload {

	private Session session;

	@Test
	public void init() {
		session.save(new Movie("O Homem de Aço", "Ação, Aventura", "A história de Superman"));
		session.save(new Movie("Os Vingadores", "Ação, Aventura", "Em ‘Os Vingadores’, Homem de Ferro, Capitão América, Thor, Hulk, Gavião Arqueiro e Viúva Negra"));
		session.save(new Movie("Batman: O Cavaleiro das Trevas Ressurge", "Ação, Aventura", "Oito anos depois, um novo líder terrorista, Bane, o melhor assola Gotham, eo Cavaleiro das Trevas ressurge para proteger uma cidade que tem marcado um inimigo."));
		session.save(new Movie("Homem de Ferro 3", "Ação", "Desde o ataque dos chitauri a Nova York, Tony Stark teme não conseguir proteger sua namorada Pepper Potts dos vários inimigos que passou a ter após vestir a armadura do Homem de Ferro. Um deles, o Mandarim decide atacá-lo com força total, destruindo sua mansão e colocando a vida de Pepper em risco.."));
		session.save(new Movie("Se Beber Não Case Parte 3", "Comédia", "Desta vez, não há casamento. Nem despedida de solteiro. Então, nada poderia dar errado, certo? Mas quando o Bando de Lobos cai na estrada, tudo pode acontecer."));
	}

	@Before
	public void setUp() {
		session = HibernateUtil.currentSession();
		HibernateUtil.beginTransaction();
	}

	@After
	public void setDown() {
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}

}