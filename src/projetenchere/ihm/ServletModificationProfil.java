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
import projetenchere.bll.Utilisateur.ManagerUtilisateur;
import projetenchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletModificationProfile
 */
@WebServlet("/modification_profile")
public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManagerUtilisateur managerUtilisateur = ManagerSingleton.getManagerUtilisateur();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/modification_profil.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		System.out.println(email);
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("code-postal");
		String ville = request.getParameter("ville");
		String ancienMotDePasse = request.getParameter("mdpActuel");
		String motDePasse = request.getParameter("nouveauMdp");
		String confirmationMotDePasse = request.getParameter("confirmationMdp");
		
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
			System.out.println(utilisateur.getEmail());
		  if(pseudo != ""){
		    utilisateur.setPseudo(pseudo);
		  }
		  if(nom != ""){
		    utilisateur.setNom(nom);
		  }
		  if(prenom != ""){
		    utilisateur.setPrenom(prenom);
		  }
		  if(email != null){
		    utilisateur.setEmail(email);
		  }
		  if(telephone!= ""){
		    utilisateur.setTelephone(telephone);
		  }
		  if(rue != ""){
		    utilisateur.setRue(rue);
		  }
		  if(codePostal != null){
		    utilisateur.setCodePostal(codePostal);
		  }
		  if(ville != ""){
		    utilisateur.setVille(ville);
		  }

		try {
			ancienMotDePasse = managerUtilisateur.ChiffrerMotDePasse(ancienMotDePasse);
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(motDePasse == null){
				System.out.println(utilisateur);
						managerUtilisateur.UpdateUtilisateurWithoutPassword(utilisateur);
			} else if (motDePasse != null) {
				if(ancienMotDePasse.equals(utilisateur.getMotDePasse())) {
					System.out.println(utilisateur);
					if (motDePasse.equals(confirmationMotDePasse)) {
						utilisateur.setMotDePasse(motDePasse);
						System.out.println(utilisateur);
						managerUtilisateur.UpdateUtilisateur(utilisateur);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/modification_profil.jsp");
		rd.forward(request, response);
	}

}
