package projetenchere.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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

		List<Enchere> lesEncheres = managerEnchere.GetAllEnchere();
		List<Enchere> encheres = new ArrayList();
		List<Integer> numEncheres = new ArrayList();
		
		for(Enchere enchere : lesEncheres) {
			if(numEncheres.stream().filter(x -> x.intValue() == enchere.getArticleVendu().getNoArticle()).collect(Collectors.toList()).size() == 0) {
				Enchere meilleureEnchere = managerEnchere.GetMeilleureOffre(enchere.getArticleVendu());
				encheres.add(meilleureEnchere);
				numEncheres.add(enchere.getArticleVendu().getNoArticle());
			}
			
		}
		
		for(Enchere lenchere : encheres) {
			System.out.println(lenchere);
		}
		
		List<Categorie> categories = managerCategorie.GetAllCategorie();
		
		request.setAttribute("categories", categories);
		request.setAttribute("encheres", encheres);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/home.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
