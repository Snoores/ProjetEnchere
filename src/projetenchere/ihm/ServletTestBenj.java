package projetenchere.ihm;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetenchere.bll.ManagerArticleVendu;
import projetenchere.bll.ManagerFactory;
import projetenchere.bll.ManagerRetrait;
import projetenchere.bo.*;
import projetenchere.dal.DAOArticleVendu;
import projetenchere.dal.DAOEnchere;
import projetenchere.dal.DAOFactory;
import projetenchere.dal.DAORetrait;

/**
 * Servlet implementation class ServletTestBenj
 */
@WebServlet("/ServletTestBenj")
public class ServletTestBenj extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Utilisateur utilisateur = new Utilisateur(1, "azer", "reg", "vrve", "tert@erigei.com", "0101010101", "azer", "32568", "zefaz", "aaaaaa", 2000, null, false);
        Categorie categorie = new Categorie(2, "Vetements");
        Retrait retrait = new Retrait(12, "Rue du ballec", "43210", "Paris");

        ArticleVendu articleVendu = new ArticleVendu(
                13,
                "Chaussure 3",
                "Qui a trois pied ?",
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 1, 3),
                6200,
                1000244,
                utilisateur,
                categorie,
                "EC",
                new Retrait(),
                new Enchere());

        Enchere enchere = new Enchere(
                utilisateur.getNoUtilisateur(),
                articleVendu.getNoArticle(),
                LocalDate.of(2021, 04, 9),
                12000);

        /*DAOArticleVendu daoArticleVendu = DAOFactory.getDAOArticleVendu();
		daoArticleVendu.SelectArticleVenduByNoArticle(1);
		daoArticleVendu.SelectArticleVenduByCategorie(categorie);
		daoArticleVendu.SelectArticleVenduByUtilisateur(utilisateur);
		daoArticleVendu.SelectArticleVenduByUtilisateurAndEtat(utilisateur, "EC");
		daoArticleVendu.SelectArticleVenduByEtat("EC");
		daoArticleVendu.SelectAllArticleVendu();*/


        /*DAOEnchere daoEnchere = DAOFactory.getDAOEnchere();
		System.out.println("Enchere by NoArticle");
		daoEnchere.SelectEnchereByNoArticle(2);
		System.out.println("Enchere All");
		daoEnchere.SelectAllEnchere();
		System.out.println("Enchere by Article");
		daoEnchere.SelectEnchereByArticle(articleVendu);
		System.out.println("Enchere by Utilisateur");
		daoEnchere.SelectEnchereByUtilisateur(utilisateur);
		daoEnchere.InsertEnchere(enchere);
		daoEnchere.UpdateEnchere(enchere);
        daoEnchere.DeleteEnchere(enchere);*/

        /*DAORetrait daoRetrait = DAOFactory.getDAORetrait();
        daoRetrait.SelectAllRetrait();
        daoRetrait.SelectByNoArticle(article);
        daoRetrait.InsertRetrait(retrait);
        daoRetrait.UpdateRetrait(retrait);
        daoRetrait.DeleteRetrait(retrait);*/

        /*ManagerRetrait managerRetrait = ManagerFactory.getManagerRetrait();
        managerRetrait.CreateRetrait(retrait);
        for (Retrait ret : managerRetrait.GetAllRetrait()) ret.toString();
        managerRetrait.GetRetraitByNoArticle(articleVendu.getNoArticle()).toString();
        managerRetrait.UpdateRetrait(retrait);
        managerRetrait.DeleteRetrait(retrait);*/

        /*ManagerArticleVendu managerArticleVendu = ManagerFactory.getManagerArticleVendu();
        managerArticleVendu.GetAllArticleVendu();
        managerArticleVendu.GetArticleVenduByNoArticle(1);
        managerArticleVendu.GetArticleVenduByEtat("EC");
        managerArticleVendu.GetArticleVenduByCategorie(categorie);
        managerArticleVendu.GetArticleVenduByUtilisateur(utilisateur);
        managerArticleVendu.GetArticleVenduByUtilisateurAndEtat(utilisateur, "EC");
        managerArticleVendu.CreateArticleVendu(articleVendu);
        managerArticleVendu.UpdateArticleVendu(articleVendu);
        managerArticleVendu.DeleteArticleVendu(articleVendu);*/

        //TODO: Test ManagerEnchere
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
