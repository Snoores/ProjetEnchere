package projetenchere.bll;

import projetenchere.bll.ArticleVendu.ManagerArticleVendu;
import projetenchere.bll.ArticleVendu.ManagerArticleVenduImpl;
import projetenchere.bll.Categorie.ManagerCategorie;
import projetenchere.bll.Categorie.ManagerCategorieImpl;
import projetenchere.bll.Enchere.ManagerEnchere;
import projetenchere.bll.Enchere.ManagerEnchereImpl;
import projetenchere.bll.Retrait.ManagerRetrait;
import projetenchere.bll.Retrait.ManagerRetraitImpl;
import projetenchere.bll.Utilisateur.ManagerUtilisateur;
import projetenchere.bll.Utilisateur.ManagerUtilisateurImpl;

public class ManagerSingleton {
    static ManagerArticleVendu managerArticleVendu;
    static ManagerEnchere managerEnchere;
    static ManagerCategorie managerCategorie;
    static ManagerRetrait managerRetrait;
    static ManagerUtilisateur managerUtilisateur;

    public static ManagerArticleVendu getManagerArticleVendu() {
        if (managerArticleVendu == null){
            managerArticleVendu = new ManagerArticleVenduImpl();
        }
        return managerArticleVendu;
    }

    public static ManagerCategorie getManagerCategorie(){
        if (managerCategorie == null){
            managerCategorie = new ManagerCategorieImpl();
        }
        return managerCategorie;
    }

    public static ManagerEnchere getManagerEnchere(){
        if (managerEnchere == null){
            managerEnchere = new ManagerEnchereImpl();
        }
        return managerEnchere;
    }

    public static ManagerRetrait getManagerRetrait(){
        if (managerRetrait == null){
            managerRetrait = new ManagerRetraitImpl();
        }
        return managerRetrait;
    }

    public static ManagerUtilisateur getManagerUtilisateur(){
        if (managerUtilisateur == null){
            managerUtilisateur = new ManagerUtilisateurImpl();
        }
        return managerUtilisateur;
    }
}
