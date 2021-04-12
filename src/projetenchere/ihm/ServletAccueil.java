package projetenchere.ihm;

import projetenchere.bo.Retrait;
import projetenchere.dal.DAOSingleton;
import projetenchere.dal.DAORetrait;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/DisIsNotARealPath"})
class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAORetrait daoRetrait = DAOSingleton.getDAORetrait();
		daoRetrait.InsertRetrait(new Retrait());

		System.out.println();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
