package projetenchere.ihm;

import projetenchere.bll.ArticleVendu.ManagerArticleVendu;
import projetenchere.bll.Enchere.ManagerEnchere;
import projetenchere.bll.ManagerSingleton;
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
		int proposition = Integer.parseInt(request.getParameter("proposition"));
		
		Enchere enchere = new Enchere(utilisateur,article,LocalDate.now(),proposition);

		managerEnchere.CreateEnchere(enchere);

		response.sendRedirect(request.getContextPath() + "/enchere?id="+noArticle);
	}

}
