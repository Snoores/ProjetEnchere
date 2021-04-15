package projetenchere.ihm;

import projetenchere.bll.ManagerArticleVendu;
import projetenchere.bll.ManagerEnchere;
import projetenchere.bll.ManagerSingleton;
import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/enchere.jsp");
		rd.forward(request, response);
	}

}
