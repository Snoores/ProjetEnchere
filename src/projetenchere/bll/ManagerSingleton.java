package projetenchere.bll;

import projetenchere.bll.*;
import projetenchere.dal.DAOCategorieImpl;

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
