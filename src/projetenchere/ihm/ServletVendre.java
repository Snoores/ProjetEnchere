package projetenchere.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetenchere.bll.ManagerSingleton;
import projetenchere.bll.ArticleVendu.ManagerArticleVendu;
import projetenchere.bll.Categorie.ManagerCategorie;
import projetenchere.bll.Enchere.ManagerEnchere;
import projetenchere.bll.Retrait.ManagerRetrait;
import projetenchere.bll.Utilisateur.ManagerUtilisateur;
import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;
import projetenchere.bo.Retrait;
import projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletVendre
 */
@WebServlet("/vendre_article")
public class ServletVendre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerArticleVendu managerArticleVendu = ManagerSingleton.getManagerArticleVendu();
	private ManagerEnchere managerEnchere = ManagerSingleton.getManagerEnchere();
	private ManagerCategorie managerCategorie = ManagerSingleton.getManagerCategorie();
	private ManagerRetrait managerRetrait = ManagerSingleton.getManagerRetrait();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categorie> categories = managerCategorie.GetAllCategorie();
		
		request.setAttribute("categories", categories);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/vendreArticle.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomArticle = request.getParameter("article");
		String description = request.getParameter("description");
		String libelleCategorie = request.getParameter("categorie");
		int miseAPrix = Integer.parseInt(request.getParameter("miseAPrix"));
		LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
		//Retrait
		String rue = request.getParameter("rue");
		String cp = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
		Categorie categorie = managerCategorie.GetCategorieByLibelle(libelleCategorie);
		
		
		ArticleVendu articleVendu = new ArticleVendu(nomArticle,description,dateDebut,dateFin,miseAPrix,utilisateur,categorie,"CR");
		System.out.println(articleVendu);
		articleVendu = managerArticleVendu.CreateArticleVendu(articleVendu);
		
		Retrait retrait = new Retrait(articleVendu,rue,cp,ville);
		managerRetrait.CreateRetrait(retrait);
		
		
		response.sendRedirect(request.getContextPath() + "/enchere?id="+articleVendu.getNoArticle());
				
	}

}
