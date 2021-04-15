package projetenchere.dal;

import projetenchere.dal.ArticleVendu.DAOArticleVendu;
import projetenchere.dal.ArticleVendu.DAOArticleVenduImpl;
import projetenchere.dal.Categorie.DAOCategorie;
import projetenchere.dal.Categorie.DAOCategorieImpl;
import projetenchere.dal.Enchere.DAOEnchere;
import projetenchere.dal.Enchere.DAOEnchereImpl;
import projetenchere.dal.Retrait.DAORetrait;
import projetenchere.dal.Retrait.DAORetraitImpl;
import projetenchere.dal.Utilisateur.DAOUtilisateur;
import projetenchere.dal.Utilisateur.DAOUtilisateurImpl;

public class DAOSingleton {

    static DAORetrait daoRetrait;
    static DAOEnchere daoEnchere;
    static DAOArticleVendu daoArticleVendu;
    static DAOCategorie daoCategorie;
    static DAOUtilisateur daoUtilisateur;

    public static DAORetrait getDAORetrait() {
        if (daoRetrait == null){
            daoRetrait = new DAORetraitImpl();
        }
        return daoRetrait;
    }

    public static DAOArticleVendu getDAOArticleVendu(){
        System.out.println("DAOArticleVendu");
        if (daoArticleVendu == null){
            daoArticleVendu = new DAOArticleVenduImpl();
        }
        return daoArticleVendu;
    }

    public static DAOCategorie getDAOCategorie(){
            if (daoCategorie == null){
                daoCategorie = new DAOCategorieImpl();
            }
            return daoCategorie;
    }

    public static DAOEnchere getDAOEnchere(){
        System.out.println("DAOEnchere");
        if (daoEnchere == null){
            daoEnchere = new DAOEnchereImpl();
        }
        return daoEnchere;
    }

    public static DAOUtilisateur getDAOUtilisateur(){
        if (daoUtilisateur == null){
            daoUtilisateur = new DAOUtilisateurImpl();
        }
        return daoUtilisateur;
    }
}
