package projetenchere.bll.Enchere;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;
import projetenchere.dal.ArticleVendu.DAOArticleVendu;
import projetenchere.dal.Enchere.DAOEnchere;
import projetenchere.dal.DAOSingleton;
import projetenchere.dal.Utilisateur.DAOUtilisateur;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class ManagerEnchereImpl implements ManagerEnchere{
    DAOEnchere daoEnchere = DAOSingleton.getDAOEnchere();
    DAOArticleVendu daoArticleVendu = DAOSingleton.getDAOArticleVendu();
    DAOUtilisateur daoUtilisateur = DAOSingleton.getDAOUtilisateur();

    @Override
    public Utilisateur GetGagnantEnchere(Enchere enchere) {
        ArticleVendu article = daoArticleVendu.SelectArticleVenduByNoArticle(enchere.getArticleVendu().getNoArticle());
        if (LocalDate.now().isAfter(article.getDateFinEncheres())){
            Utilisateur utilisateur = daoUtilisateur.SelectUserByNoUtilisateur(enchere.getUtilisateur().getNoUtilisateur()); //TODO: Debug - To Delete
            return daoUtilisateur.SelectUserByNoUtilisateur(enchere.getUtilisateur().getNoUtilisateur());
        }
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
    public List<Enchere> GetEnchereByNoArticle(int noArticle) {
        return daoEnchere.SelectEnchereByNoArticle(noArticle);
    }

    @Override
    public List<Enchere> GetEnchereByNoUtilisateur(int noUtilisateur) {


        return daoEnchere.SelectEnchereByNoUtilisateur(noUtilisateur);
    }

    @Override
    public Enchere GetMeilleureOffre(ArticleVendu articleVendu) {
        Enchere meilleureOffre = new Enchere();
        List<Enchere> listeEnchere = GetEnchereByNoArticle(articleVendu.getNoArticle());

        if(listeEnchere.size() > 0) {
            meilleureOffre = listeEnchere.stream().max(Comparator.comparing(Enchere::getMontantEnchere)).get();
        }
        
        return meilleureOffre;
    }

    @Override
    public List<Enchere> GetAllEnchere() {
        return daoEnchere.SelectAllEnchere();
    }

    @Override
    public void CreateEnchere(Enchere enchere) {
        Boolean createdEnchere = false;
        List<Enchere> listeEnchere = daoEnchere.SelectEnchereByNoArticle(enchere.getArticleVendu().getNoArticle());

        if (listeEnchere.size() > 0) {
            for (Enchere ench : listeEnchere) {
                if (ench.getUtilisateur().getNoUtilisateur() == enchere.getUtilisateur().getNoUtilisateur()) {
                    daoEnchere.UpdateEnchere(enchere);
                    createdEnchere = true;
                    break;
                }
            }
        }
        if (createdEnchere == false){
            daoEnchere.InsertEnchere(enchere);
        }
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
