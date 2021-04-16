package projetenchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetenchere.bll.ManagerSingleton;
import projetenchere.bll.Utilisateur.ManagerUtilisateur;
import projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletSuppressionCompte
 */
@WebServlet("/suppression_compte")
public class ServletSuppressionCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerUtilisateur managerUtilisateur = ManagerSingleton.getManagerUtilisateur();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
		managerUtilisateur.DeleteUtilisateur(utilisateur);
		response.sendRedirect(request.getContextPath() + "/deconnexion");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
