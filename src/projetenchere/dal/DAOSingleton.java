package projetenchere.dal;

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
