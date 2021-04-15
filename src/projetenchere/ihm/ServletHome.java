package projetenchere.ihm;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetenchere.bll.Categorie.ManagerCategorie;
import projetenchere.bll.Enchere.ManagerEnchere;
import projetenchere.bll.ManagerSingleton;
import projetenchere.bo.Categorie;
import projetenchere.bo.Enchere;

/**
 * Servlet implementation class ServletHome
 */
@WebServlet(urlPatterns = {"/accueil"})
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ManagerEnchere managerEnchere = ManagerSingleton.getManagerEnchere();
		ManagerCategorie managerCategorie = ManagerSingleton.getManagerCategorie();

		List<Enchere> encheres = managerEnchere.GetAllEnchere();
		List<Categorie> categories = managerCategorie.GetAllCategorie();
		
		request.setAttribute("categories", categories);
		request.setAttribute("encheres", encheres);

		for (Enchere ench: encheres){
			System.out.println(ench.toString());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/home.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
