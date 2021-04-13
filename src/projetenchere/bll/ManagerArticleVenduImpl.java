package projetenchere.bll;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;
import projetenchere.dal.DAOArticleVendu;
import projetenchere.dal.DAOSingleton;

import java.util.List;

public class ManagerArticleVenduImpl implements ManagerArticleVendu{
    DAOArticleVendu daoArticleVendu = DAOSingleton.getDAOArticleVendu();

    @Override
    public List<ArticleVendu> GetAllArticleVendu() {
        return daoArticleVendu.SelectAllArticleVendu();
    }

    @Override
    public void CreateArticleVendu(ArticleVendu article) {
        daoArticleVendu.InsertArticleVendu(article);
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
