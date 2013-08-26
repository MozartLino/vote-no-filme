package br.com.lino.votenofilme.infrastructure.util;

import org.hibernate.Session;

import br.com.lino.votenofilme.domain.model.movie.Movie;

public class Payload {


	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		HibernateUtil.beginTransaction();
		
		session.save(new Movie("300", "Ação", "Sinopse: Grécia, 480 AC. Na Batalha de Termópilas, o rei Leônidas (Gerard Butler) e seus 300 guerreiros de Esparta lutam bravamente contra o numeroso exército do rei Xerxes (Rodrigo Santoro). Após três dias de muita luta, todos os espartanos são mortos. O sacrifício e a dedicação destes homens uniu a Grécia no combate contra o inimigo persa."));
		session.save(new Movie("As Aventuras de Pi", "Aventura", "Sinopse: Em 'As Aventuras de Pi' um menino perde a família em um naufrágio e passa 227 dias à deriva em um bote salva-vidas na companhia de ninguém mais além de um tigre-de-bengala. O garoto sobrevive e hoje é casado e pai de família. Difícil de acreditar, não é? Mas Piscine Patel, o Pi, personagem principal da ficção 'As aventuras de Pi', passou por isso."));
		session.save(new Movie("E.T - O Extraterrestre", "Aventura", "Sinopse: Um garoto faz amizade com um ser de outro planeta, que ficou sozinho na Terra, protegendo-o de todas as formas para evitar que ele seja capturado e transformado em cobaia. Gradativamente, surge entre os dois uma forte amizade."));
		session.save(new Movie("Homem de Ferro 3", "Ação", "Desde o ataque dos chitauri a Nova York, Tony Stark teme não conseguir proteger sua namorada Pepper Potts dos vários inimigos que passou a ter após vestir a armadura do Homem de Ferro. Um deles, o Mandarim decide atacá-lo com força total, destruindo sua mansão e colocando a vida de Pepper em risco."));
		session.save(new Movie("Os Vingadores", "Comédia", "Loki retorna à Terra enviado pelos chitauri, uma raça alienígena que pretende dominar os humanos. No intuito de contê-lo, Nick Fury convoca um grupo de pessoas com grandes habilidades, mas que jamais haviam trabalhado juntas: Homem de Ferro, Capitão América, Thor, Bruce Hulk e Viúva Negra. Só que, apesar do grande perigo que a Terra corre, não é tão simples assim conter o ego e os interesses de cada um deles para que possam agir em grupo."));
		
		HibernateUtil.commitTransaction();
		HibernateUtil.closeSession();
	}
}