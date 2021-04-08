package projetenchere.bll;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;
import projetenchere.bo.Utilisateur;

import java.util.List;

public class ManagerArticleVenduImpl implements ManagerArticleVendu{
    @Override
    public List<ArticleVendu> GetAllArticleVendu() {
        return null;
    }

    @Override
    public void CreateArticleVendu(ArticleVendu article) {

    }

    @Override
    public void DeleteArticleVendu(ArticleVendu article) {

    }

    @Override
    public void UpdateArticleVendu(ArticleVendu article) {

    }

    @Override
    public ArticleVendu GetArticleVenduByNoArticle(int noArticle) {
        return null;
    }

    @Override
    public List<ArticleVendu> GetArticleVenduByCategorie(Categorie categorie) {
        return null;
    }

    @Override
    public List<ArticleVendu> GetArticleVenduByUtilisateurAndEtat(Utilisateur utilisateur, String etat) {
        return null;
    }

    @Override
    public List<ArticleVendu> GetArticleVenduByEtat(String etat) {
        return null;
    }

    @Override
    public List<ArticleVendu> GetArticleVenduByUtilisateur(Utilisateur utilisateur) {
        return null;
    }
}
