package projetenchere.bll.ArticleVendu;

import projetenchere.bll.Enchere.ManagerEnchere;
import projetenchere.bll.ManagerSingleton;
import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;
import projetenchere.dal.ArticleVendu.DAOArticleVendu;
import projetenchere.dal.DAOSingleton;

import java.time.LocalDate;
import java.util.List;

public class ManagerArticleVenduImpl implements ManagerArticleVendu{
    DAOArticleVendu daoArticleVendu = DAOSingleton.getDAOArticleVendu();
    ManagerEnchere managerEnchere = ManagerSingleton.getManagerEnchere();

    @Override
    public List<ArticleVendu> GetAllArticleVendu() {
        return daoArticleVendu.SelectAllArticleVendu();
    }

    @Override
    public ArticleVendu CreateArticleVendu(ArticleVendu article) {

        if((Integer) article.getPrixVente() == null){
            article.setPrixVente(article.getMiseAPrix());
        }
        article = daoArticleVendu.InsertArticleVendu(article);

        if (managerEnchere.GetEnchereByNoArticle(article.getNoArticle()).size() > 0){
            managerEnchere.CreateEnchere(new Enchere(article.getUtilisateur(), article, LocalDate.now() ,article.getMiseAPrix()));
        }

        return article;
    }

    @Override
    public void DeleteArticleVendu(ArticleVendu article) {
        daoArticleVendu.DeleteArticleVendu(article);
    }

    @Override
    public void UpdateArticleVendu(ArticleVendu article) {
        daoArticleVendu.UpdateArticleVendu(article);
    }

    @Override
    public ArticleVendu GetArticleVenduByNoArticle(int noArticle) {
        return daoArticleVendu.SelectArticleVenduByNoArticle(noArticle);
    }

    @Override
    public List<ArticleVendu> GetArticleVenduByCategorie(Categorie categorie) {
        return daoArticleVendu.SelectArticleVenduByCategorie(categorie);
    }

    @Override
    public List<ArticleVendu> GetArticleVenduByUtilisateurAndEtat(Utilisateur utilisateur, String etat) {
        return daoArticleVendu.SelectArticleVenduByUtilisateurAndEtat(utilisateur, etat);
    }

    @Override
    public List<ArticleVendu> GetArticleVenduByEtat(String etat) {
        return daoArticleVendu.SelectArticleVenduByEtat(etat);
    }

    @Override
    public List<ArticleVendu> GetArticleVenduByUtilisateur(Utilisateur utilisateur) {
        return daoArticleVendu.SelectArticleVenduByUtilisateur(utilisateur);
    }
    
}
