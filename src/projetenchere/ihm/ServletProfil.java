package projetenchere.ihm;

import projetenchere.bll.ManagerArticleVendu;
import projetenchere.bll.ManagerSingleton;
import projetenchere.bll.ManagerUtilisateur;
import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Utilisateur;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletProfil
 */
@WebServlet("/profil")
public class ServletProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ManagerUtilisateur managerUtilisateur = ManagerSingleton.getManagerUtilisateur();

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = null;
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/profile.jsp");

		if (request.getParameter("id") != null) {
			int no_utilisateur = Integer.parseInt(request.getParameter("id"));
			utilisateur = managerUtilisateur.GetUtilisateurByNoUtilisateur(no_utilisateur);
		} else if (request.getSession().getAttribute("user") != null) {
			utilisateur = (Utilisateur) request.getSession().getAttribute("user");
		}

		request.setAttribute("user_profile", utilisateur);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/profile.jsp");
		rd.forward(request, response);
	}

}