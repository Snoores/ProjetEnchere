package projetenchere.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetenchere.bll.ManagerCategorie;
import projetenchere.bll.ManagerSingleton;
import projetenchere.dal.DAOSingleton;
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
		DAOUtilisateur daoUtilisateur = DAOSingleton.getDAOUtilisateur();
		//***DAOCategorie***\\
//		DAOCategorie daoCategorie = DAOFactory.getDAOCategorie();
		
		//***Insert Utilisateur***\\
//		List<ArticleVendu> listeArticleVendu = new ArrayList<>();
//		List<Enchere> listeEnchere = new ArrayList<>();
//		daoUtilisateur.InsertUtilisateur(new Utilisateur("william-penna","pennaneach","william","w.test@test.fr","0606060606","rue du test","29500","Ergue-Gaberic","test",30,listeArticleVendu,listeEnchere,true));
		
		//***SelectAllUtilisateur***\\
		daoUtilisateur.SelectAllUtilisateur();
		
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
		
		//***UpdateCreditUtilisateur***\\
//		Utilisateur utilisateur = daoUtilisateur.SelectUserByNoUtilisateur(5);
//		int newcredit = 1000;
//		daoUtilisateur.UpdateCreditUtilisateur(utilisateur,newcredit);
		
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
//		Categorie categorie = new Categorie(3,"Musique");
//		System.out.println(daoCategorie.UpdateCategorie(categorie));
		
		//***ManagerUtilisateur***\\
//		ManagerUtilisateur managerUtilisateur = ManagerFactory.getManagerUtilisateur();
				
		//***ManagerCategorie***\\
		ManagerCategorie managerCategorie = ManagerSingleton.getManagerCategorie();
		
		//***CreateUtilisateur***\\
//		List<ArticleVendu> listeArticleVendu = new ArrayList<>();
//		List<Enchere> listeEnchere = new ArrayList<>();
//		managerUtilisateur.CreateUtilisateur(new Utilisateur("manager-test","manager","test","mana.test@test.fr","0606060606","rue du test","29500","Ergue-Gaberic","test",30,listeArticleVendu,listeEnchere,true));
		
		//***GetAllUtilisateur***\\
//		System.out.println(managerUtilisateur.GetAllUtilisateur().toString());
		
		//***GetUtilisateurByNoUtilisateur***\\
//		System.out.println(managerUtilisateur.GetUtilisateurByNoUtilisateur(8).toString());
		
		//***GetUtilisateurByPseudo***\\
//		System.out.println(managerUtilisateur.GetUtilisateurByPseudo("william-penna").toString());
		
		//***GetUtilisateurByEmail***\\
//		System.out.println(managerUtilisateur.GetUtilisateurByEmail("mana.test@test.fr").toString());
		
		//***DeleteUtilisateur***\\
//		Utilisateur utilisateur = managerUtilisateur.GetUtilisateurByNoUtilisateur(8);
//		managerUtilisateur.DeleteUtilisateur(utilisateur);
		
		//***UpdateUtilisateur***\\
//		List<ArticleVendu> listeArticleVendu = new ArrayList<>();
//		List<Enchere> listeEnchere = new ArrayList<>();
//		Utilisateur utilisateur = new Utilisateur(5,"william-penna","pennaneach","william","w.test@test.fr","0606060606","rue du test","29500","ERGUE-GABERIC","test",30,true);
//		managerUtilisateur.UpdateUtilisateur(utilisateur);
		
		//***UpdateCreditUtilisateur***\\
//		Utilisateur utilisateur = managerUtilisateur.GetUtilisateurByNoUtilisateur(5);
//		int newcredit = 3000;
//		managerUtilisateur.UpdateCreditUtilisateur(utilisateur,newcredit);
		
		//***CreateCategorie***\\
//		Categorie categorie = new Categorie("Voiture");
//		managerCategorie.CreateCategorie(categorie);
		
		//***GetAllCategorie***\\
//		System.out.println(managerCategorie.GetAllCategorie().toString());
		
		//***GetCategorieByNoCategorie***\\
//		System.out.println(managerCategorie.GetCategorieByNoCategorie(3).toString());
		
		//***GetCategorieByLibelle***\\
//		System.out.println(managerCategorie.GetCategorieByLibelle("Voiture").toString());
		
		//***DeleteCategorie***\\
//		Categorie categorie = managerCategorie.GetCategorieByNoCategorie(9);
//		managerCategorie.DeleteCategorie(categorie);
		
		//***UpdateCategorie***\\
//		Categorie categorie = new Categorie(3,"Voiture");
//		managerCategorie.UpdateCategorie(categorie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
