package projetenchere.dal;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAOArticleVendu {

    List<ArticleVendu> SelectArticleVenduByUtilisateur(Utilisateur utilisateur);
    ArticleVendu SelectArticleVenduByNoArticle(int noArticle);
    List<ArticleVendu> SelectArticleVenduByCategorie(Categorie categorie);
    List<ArticleVendu> SelectArticleVenduByUtilisateurAndEtat(Utilisateur utilisateur, String etat);
    List<ArticleVendu> SelectArticleVenduByEtat(String etat);

    List<ArticleVendu> SelectAllArticleVendu();
    void InsertArticleVendu(ArticleVendu articleVendu);
    ArticleVendu UpdateArticleVendu(ArticleVendu articleVendu);
    void DeleteArticleVendu(ArticleVendu articleVendu);

    ArticleVendu CreateArticleVendu(ResultSet rs) throws SQLException;
}
