package projetenchere.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;
import projetenchere.dal.DAOCategorie;
import projetenchere.dal.DAOFactory;
import projetenchere.dal.DAOUtilisateur;

/**
 * Servlet implementation class ServletWilliam
 */
@WebServlet("/ServletWilliam")
public class ServletWilliam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//***DAOUtilisateur***\\
//		DAOUtilisateur daoUtilisateur = DAOFactory.getDAOUtilisateur();
		//***DAOCategorie***\\
		DAOCategorie daoCategorie = DAOFactory.getDAOCategorie();
		
		//***Insert Utilisateur***\\
//		List<ArticleVendu> listeArticleVendu = new ArrayList<>();
//		List<Enchere> listeEnchere = new ArrayList<>();
//		daoUtilisateur.InsertUtilisateur(new Utilisateur("william-penna","pennaneach","william","w.test@test.fr","0606060606","rue du test","29500","Ergue-Gaberic","test",30,listeArticleVendu,listeEnchere,true));
		
		//***SelectAllUtilisateur***\\
//		System.out.println(daoUtilisateur.SelectAllUtilisateur().toString());
		
		//***SelectUtilisateurByNoUtilisateur***\\
//		System.out.println(daoUtilisateur.SelectUserByNoUtilisateur(1).toString());
		
		//***SelectUtilisateurByPseudo***\\
//		System.out.println(daoUtilisateur.SelectUserByPseudo("william-penna").toString());
		
		//***SelectUtilisateurByEmail***\\
//		System.out.println(daoUtilisateur.SelectUserByEmail("w.test@test.fr").toString());
		
		//***DeleteUtilisateur***\\
//		Utilisateur utilisateur = daoUtilisateur.SelectUserByNoUtilisateur(4);
//		daoUtilisateur.DeleteUtilisateur(utilisateur);
		
		//***UpdateUtilisateur***\\
//		List<ArticleVendu> listeArticleVendu = new ArrayList<>();
//		List<Enchere> listeEnchere = new ArrayList<>();
//		Utilisateur utilisateur = new Utilisateur(5,"william-penna","pennaneach","william","w.test@test.fr","0606060606","rue du test","35200","Rennes","test",30,true);
//		daoUtilisateur.UpdateUtilisateur(utilisateur);
		
		//***Insert Categorie***\\
//		Categorie categorie = new Categorie("Musique");
//		daoCategorie.InsertCategorie(categorie);
		
		//***SelectAllCategorie***\\
//		System.out.println(daoCategorie.SelectAllCategorie().toString());
		
		//***SelectCategorieByNocategorie***\\
//		System.out.println(daoCategorie.SelectCategorieByNoCategorie(3).toString());
		
		//***SelectCategorieByLibelle***\\
//		System.out.println(daoCategorie.SelectCategorieByLibelle("Musique").toString());
		
		//***DeleteCategorie***\\
//		Categorie categorie = daoCategorie.SelectCategorieByNoCategorie(8);
//		daoCategorie.DeleteCategorie(categorie);
		
		//***UpdateCategorie***\\
		Categorie categorie = new Categorie(3,"Musique");
		System.out.println(daoCategorie.UpdateCategorie(categorie));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}