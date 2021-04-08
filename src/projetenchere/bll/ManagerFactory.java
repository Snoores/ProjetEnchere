package projetenchere.bll;

import projetenchere.bll.*;

public class ManagerFactory {
    public static ManagerArticleVendu getManagerArticleVendu() {
        return new ManagerArticleVenduImpl();
    }

    public static ManagerCategorie getManagerCategorie(){
        return new ManagerCategorieImpl();
    }

    public static ManagerEnchere getManagerEnchere(){
        return new ManagerEnchereImpl();
    }

    public static ManagerRetrait getManagerRetrait(){
        return new ManagerRetraitImpl();
    }

    public static ManagerUtilisateur getManagerUtilisateur(){
        return new ManagerUtilisateurImpl();
    }
}
