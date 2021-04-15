package projetenchere.ihm;

import projetenchere.bll.ManagerArticleVendu;
import projetenchere.bll.ManagerEnchere;
import projetenchere.bll.ManagerSingleton;
import projetenchere.bll.ManagerUtilisateur;
import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Servlet implementation class ServletEnchere
 */
@WebServlet("/enchere")
public class ServletEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerArticleVendu managerArticleVendu = ManagerSingleton.getManagerArticleVendu();
	private ManagerEnchere managerEnchere = ManagerSingleton.getManagerEnchere();
	private ManagerUtilisateur managerUtilisateur = ManagerSingleton.getManagerUtilisateur();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArticleVendu article = managerArticleVendu.GetArticleVenduByNoArticle(Integer.parseInt(request.getParameter("id")));
		Enchere meilleureOffre = managerEnchere.GetMeilleureOffre(article);

		request.setAttribute("meilleure_offre", meilleureOffre);
		request.setAttribute("article", article);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/enchere.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noArticle = Integer.parseInt(request.getParameter("no_article"));
		ArticleVendu article = managerArticleVendu.GetArticleVenduByNoArticle(noArticle);
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
		System.out.println(utilisateur.toString());
		int proposition = Integer.parseInt(request.getParameter("proposition"));
		
//		Enchere enchere = new Enchere(utilisateur,article,LocalDate.now(),proposition);
		Enchere newEnchere = null;
		for(Enchere enchere : utilisateur.getListeEnchere()) {
			System.out.println("fortest");
			System.out.println(enchere.toString());
			if(enchere.getArticleVendu().getNoArticle() == noArticle) {
				System.out.println("iftest");
				System.out.println(enchere.toString());
				newEnchere = enchere;
				newEnchere.setMontantEnchere(proposition);
				System.out.println(newEnchere.toString());
				break;
			}
		}
		
		if(newEnchere == null) {
			managerEnchere.CreateEnchere(new Enchere(utilisateur,article,LocalDate.now(),proposition));
		} else {
			managerEnchere.UpdateEnchere(newEnchere);
		}
		
		
		response.sendRedirect(request.getContextPath() + "/enchere?id="+noArticle);
	}

}
