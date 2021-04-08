package projetenchere.bll;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;
import projetenchere.bo.Utilisateur;

import java.util.List;

public interface ManagerArticleVendu {

    public List<ArticleVendu> GetAllArticleVendu();
    public void CreateArticleVendu(ArticleVendu article);
    public void DeleteArticleVendu(ArticleVendu article);
    public void UpdateArticleVendu(ArticleVendu article);

    public ArticleVendu GetArticleVenduByNoArticle(int noArticle);
    public List<ArticleVendu> GetArticleVenduByCategorie(Categorie categorie);
    public List<ArticleVendu> GetArticleVenduByUtilisateurAndEtat(Utilisateur utilisateur, String etat);
    public List<ArticleVendu> GetArticleVenduByEtat(String etat);
    public List<ArticleVendu> GetArticleVenduByUtilisateur(Utilisateur utilisateur);

}
