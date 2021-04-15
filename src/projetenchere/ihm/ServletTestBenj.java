package projetenchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTestBenj
 */
@WebServlet("/ServletTestBenj")
public class ServletTestBenj extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/modification_profil.jsp");
		rd.forward(request, response);
//        Utilisateur utilisateur = new Utilisateur(1, "azer", "reg", "vrve", "tert@erigei.com", "0101010101", "azer", "32568", "zefaz", "aaaaaa", 2000, null, false);
//        Categorie categorie = new Categorie(2, "Vetements");
//
//        ArticleVendu articleVendu = new ArticleVendu(
//                12,
//                "Chaussure 3",
//                "Qui a trois pied ?",
//                LocalDate.of(2021, 1, 1),
//                LocalDate.of(2021, 1, 3),
//                6200,
//                1000244,
//                utilisateur,
//                categorie,
//                "EC",
//                new ArrayList<Enchere>(),
//                new Retrait());
//
//        Enchere enchere = new Enchere(
//                utilisateur,
//                articleVendu,
//                LocalDate.of(2021, 04, 9),
//                25000);
//        
//        Retrait retrait = new Retrait(articleVendu, "Rue du ballec", "43210", "Paris");


//        DAOArticleVendu daoArticleVendu = DAOSingleton.getDAOArticleVendu();
//		daoArticleVendu.SelectArticleVenduByNoArticle(1);
//		for (ArticleVendu article : daoArticleVendu.SelectArticleVenduByCategorie(categorie)){
//            System.out.println(article.toString());
//        }
//		for (ArticleVendu article : daoArticleVendu.SelectArticleVenduByUtilisateur(utilisateur)){
//            System.out.println(article.toString());
//        }
//		for (ArticleVendu article : daoArticleVendu.SelectArticleVenduByUtilisateurAndEtat(utilisateur, "EC")){
//            System.out.println(article.toString());
//        }
//		for (ArticleVendu article : daoArticleVendu.SelectArticleVenduByEtat("EC")){
//            System.out.println(article.toString());
//        }
//		for (ArticleVendu article : daoArticleVendu.SelectAllArticleVendu()){
//            System.out.println(article.toString());
//        }

//		ManagerUtilisateur managerUtilisateur = ManagerSingleton.getManagerUtilisateur();
//        try {
//            managerUtilisateur.CreateUtilisateur(new Utilisateur ("cyper-password", "cyper", "prenom", "email", "telephone", "rue", "codePostal", "ville", "motDePasse", 0, false));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.println(managerUtilisateur.CheckLoginEmail("cyper-password", "motDePasse").toString());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }

//        DAOEnchere daoEnchere = DAOSingleton.getDAOEnchere();
//		System.out.println("Enchere by NoArticle");
//        System.out.println(daoEnchere.SelectEnchereByNoArticle(2).toString());
//		System.out.println("Enchere All");
//        System.out.println(daoEnchere.SelectAllEnchere().toString());
//		System.out.println("Enchere by Article");
//        System.out.println(daoEnchere.SelectEnchereByArticle(articleVendu).toString());
//		System.out.println("Enchere by Utilisateur");
//        System.out.println(daoEnchere.SelectEnchereByUtilisateur(utilisateur).toString());
//		daoEnchere.InsertEnchere(enchere);
//		daoEnchere.UpdateEnchere(enchere);
//        daoEnchere.DeleteEnchere(enchere);

//        DAORetrait daoRetrait = DAOSingleton.getDAORetrait();
//        daoRetrait.SelectAllRetrait();
//        daoRetrait.SelectRetraitByNoArticle(articleVendu.getNoArticle());
//        daoRetrait.InsertRetrait(retrait);
//        daoRetrait.UpdateRetrait(retrait);
//        daoRetrait.DeleteRetrait(retrait);

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

        /*ManagerEnchere managerEnchere = ManagerFactory.getManagerEnchere();
        managerEnchere.CreateEnchere(enchere);
        managerEnchere.GetAllEnchere();
        managerEnchere.GetGagnantEnchere(enchere);
        managerEnchere.GetEnchereByArticle(articleVendu);
        managerEnchere.GetEnchereByNoArticle(1);
        managerEnchere.GetEnchereByUtilisateur(utilisateur);
        managerEnchere.UpdateEnchere(enchere);
        managerEnchere.DeleteEnchere(enchere);*/
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
