package projetenchere.dal;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;
import projetenchere.bo.Utilisateur;

import java.util.List;

public class DAOArticleVenduImpl implements DAOArticleVendu {
    @Override
    public List<ArticleVendu> SelectArticleVenduByUtilisateur(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public ArticleVendu SelectArticleVenduByNoArticle(int noArticle) {
        return null;
    }

    @Override
    public List<ArticleVendu> SelectArticleVenduByCategorie(Categorie categorie) {
        return null;
    }

    @Override
    public List<ArticleVendu> SelectArticleVenduByUtilisateurAndEtat(Utilisateur utilisateur, String etat) {
        return null;
    }

    @Override
    public List<ArticleVendu> SelectArticleVenduByEtat(String etat) {
        return null;
    }

    @Override
    public List<ArticleVendu> SelectAllArticleVendu() {
        return null;
    }

    @Override
    public void InsertArticleVendu(ArticleVendu categorie) {

    }

    @Override
    public ArticleVendu UpdateArticleVendu(ArticleVendu categorie) {
        return null;
    }

    @Override
    public void DeleteArticleVendu(ArticleVendu categorie) {

    }
}
