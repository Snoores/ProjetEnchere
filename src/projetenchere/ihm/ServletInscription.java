package projetenchere.ihm;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetenchere.bll.ManagerSingleton;
import projetenchere.bll.ManagerUtilisateur;
import projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet(urlPatterns = {"/inscription"})
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerUtilisateur managerUtilisateur = ManagerSingleton.getManagerUtilisateur();
		String login = request.getParameter("login");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("code-postal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("mdp");
		String confirmationMotDePasse = request.getParameter("mdp-confirmation");
		if (motDePasse.equals(confirmationMotDePasse)) {
			System.out.println("les mdp correspondent");
			Utilisateur utilisateur = new Utilisateur(login,nom,prenom,email,telephone,rue,codePostal,ville,motDePasse,0,false);
			try {
				managerUtilisateur.CreateUtilisateur(utilisateur);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/inscription.jsp");
			rd.forward(request, response);
			System.out.println("Les mots de passe ne correspondent pas");
		}
	}

}
