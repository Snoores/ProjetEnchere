package projetenchere.ihm;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetenchere.bo.*;
import projetenchere.dal.DAOArticleVendu;
import projetenchere.dal.DAOEnchere;
import projetenchere.dal.DAOFactory;

/**
 * Servlet implementation class ServletTestBenj
 */
@WebServlet("/ServletTestBenj")
public class ServletTestBenj extends HttpServlet {
	private static final long serialVersionUID = 1L;


	// TODO Auto-generated method stub
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur (1,"azer","reg","vrve","tert@erigei.com","0101010101","azer","32568","zefaz","aaaaaa",2000, null, null, false);
		Categorie categorie = new Categorie (2, "Vetements");

		ArticleVendu articleVendu = new ArticleVendu(
		12,
		"Chaussure 2",
		"UPDATED La deuxieme chaussure du padre",
		LocalDate.of(2020, 11, 1),
		LocalDate.of(2020, 12, 1),
		600,
		900,
		utilisateur,
		categorie,
		"EC",
		new Retrait(),
		new Enchere());

		Enchere enchere = new Enchere(utilisateur.getNoUtilisateur(), articleVendu.getNoArticle(), LocalDate.of(2021, 04, 9), 9000);

		DAOArticleVendu daoArticleVendu = DAOFactory.getDAOArticleVendu();
/*		System.out.println("ArticleVendu By No Article");
		daoArticleVendu.SelectArticleVenduByNoArticle(1);
		System.out.println("ArticleVendu By categorie");
		daoArticleVendu.SelectArticleVenduByCategorie(categorie);*/
		System.out.println("ArticleVendu By User");
		daoArticleVendu.SelectArticleVenduByUtilisateur(utilisateur);
/*
		System.out.println("ArticleVendu By User and State");
		daoArticleVendu.SelectArticleVenduByUtilisateurAndEtat(utilisateur, "EC");
		System.out.println("ArticleVendu By State");
		daoArticleVendu.SelectArticleVenduByEtat("EC");
		System.out.println("ArticleVendu All");
		daoArticleVendu.SelectAllArticleVendu();
*/

/*
		DAOEnchere daoEnchere = DAOFactory.getDAOEnchere();
		System.out.println("Enchere by NoArticle");
		daoEnchere.SelectEnchereByNoArticle(1);
		System.out.println("Enchere All");
		daoEnchere.SelectAllEnchere();
		System.out.println("Enchere by Article");
		daoEnchere.SelectEnchereByArticle(articleVendu);
		System.out.println("Enchere by Utilisateur");
		daoEnchere.SelectEnchereByUtilisateur(utilisateur);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
