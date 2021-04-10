package projetenchere.bll;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;
import projetenchere.dal.DAOArticleVendu;
import projetenchere.dal.DAOEnchere;
import projetenchere.dal.DAOFactory;
import projetenchere.dal.DAOUtilisateur;

import java.time.LocalDate;
import java.util.List;

public class ManagerEnchereImpl implements ManagerEnchere{
    DAOEnchere daoEnchere = DAOFactory.getDAOEnchere();
    DAOArticleVendu daoArticleVendu = DAOFactory.getDAOArticleVendu();
    DAOUtilisateur daoUtilisateur = DAOFactory.getDAOUtilisateur();

    @Override
    public Utilisateur GetGagnantEnchere(Enchere enchere) {
        ArticleVendu article = daoArticleVendu.SelectArticleVenduByNoArticle(enchere.getNoArticle());
        if (LocalDate.now().isAfter(article.getDateFinEncheres())){
            Utilisateur utilisateur = daoUtilisateur.SelectUserByNoUtilisateur(enchere.getNoUtilisateur()); //TODO: Debug - To Delete
            System.out.println("Debug in ManagerEnchereImpl l.24 \n" + utilisateur.toString()); //TODO: Debug - To Delete
            return daoUtilisateur.SelectUserByNoUtilisateur(enchere.getNoUtilisateur());
        }
        System.out.println("Les encheres ne sont pas terminées. Date de fin :" + article.getDateFinEncheres());
        return null;
    }

    @Override
    public Enchere CheckMeilleureOffre(Enchere oldEnchere, Enchere newEnchere) {
        Enchere bestOffer = oldEnchere;
        if (oldEnchere.getMontantEnchere() < newEnchere.getMontantEnchere()){
            UpdateEnchere(newEnchere);
        }
        System.out.println("Debug in ManagerEnchereImpl l.37 \n" + bestOffer.toString()); //TODO: Debug - To Delete
        return bestOffer;
    }

    @Override
    public List<Enchere> GetEnchereByUtilisateur(Utilisateur utilisateur) {
        List<Enchere> listeEnchereParUtilisateur = daoEnchere.SelectEnchereByUtilisateur(utilisateur); //TODO: Debug - To Delete
        for (Enchere enchere : listeEnchereParUtilisateur){ //TODO: Debug - To Delete
            System.out.println("Debug in ManagerEnchereImpl l.45 \n" + enchere.toString()); //TODO: Debug - To Delete
        }

        return daoEnchere.SelectEnchereByUtilisateur(utilisateur);
    }

    @Override
    public Enchere GetEnchereByArticle(ArticleVendu article) {
        Enchere enchere = daoEnchere.SelectEnchereByArticle(article); //TODO: Debug - To Delete
        System.out.println("Debug in ManagerEnchereImpl l.54 \n" + enchere.toString()); //TODO: Debug - To Delete
        return daoEnchere.SelectEnchereByArticle(article);
    }

    @Override
    public Enchere GetEnchereByNoArticle(int noArticle) {
        Enchere enchere = daoEnchere.SelectEnchereByNoArticle(noArticle); //TODO: Debug - To Delete
        System.out.println("Debug in ManagerEnchereImpl l.61 \n" + enchere.toString()); //TODO: Debug - To Delete
        return daoEnchere.SelectEnchereByNoArticle(noArticle);
    }

    @Override
    public List<Enchere> GetAllEnchere() {
        List<Enchere> listeEnchere = daoEnchere.SelectAllEnchere();//TODO: Debug - To Delete
        for (Enchere enchere : listeEnchere){//TODO: Debug - To Delete
            System.out.println("Debug in ManagerEnchereImpl l.69 \n" + enchere.toString());//TODO: Debug - To Delete
        }
        return daoEnchere.SelectAllEnchere();
    }

    @Override
    public void CreateEnchere(Enchere enchere) { //TODO: Vérifier que l'ArticleVendu existe AVANT de faire une enchere
        daoEnchere.InsertEnchere(enchere);
    }

    @Override
    public void DeleteEnchere(Enchere enchere) {
        daoEnchere.DeleteEnchere(enchere);
    }

    @Override
    public void UpdateEnchere(Enchere enchere) { //TODO: Vérifier que l'ArticleVendu existe AVANT de faire une enchere
        daoEnchere.UpdateEnchere(enchere);
    }
}
