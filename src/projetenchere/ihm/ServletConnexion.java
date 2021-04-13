package projetenchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import projetenchere.bll.ManagerSingleton;
import projetenchere.bll.ManagerUtilisateur;
import projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletHome
 */
@WebServlet(urlPatterns = {"/connexion"})
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("login");
		String password = request.getParameter("password");		
		ManagerUtilisateur managerUtilisateur = ManagerSingleton.getManagerUtilisateur();
//		Utilisateur utilisateur = managerUtilisateur.login(login, mdp);
		
//		if(utilisateur!= null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("session", "on");
//			session.setAttribute("user", utilisateur);
//			response.sendRedirect(request.getContextPath() + "/accueil");
//		}
	}

}
