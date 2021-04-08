package projetenchere.dal;

public class DAOFactory {
    public static DAORetrait getDAORetrait() {
        return new DAORetraitImpl();
    }

    public static DAOArticleVendu getDAOArticleVendu(){
        return new DAOArticleVenduImpl();
    }

    public static DAOCategorie getDAOCategorie(){
        return new DAOCategorieImpl();
    }

    public static DAOEnchere getDAOEnchere(){
        return new DAOEnchereImpl();
    }

    public static DAOUtilisateur getDAOUtilisateur(){
        return new DAOUtilisateurImpl();
    }
}
