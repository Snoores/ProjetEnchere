package projetenchere.dal;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAOEnchere {

    List<Enchere> SelectEnchereByNoArticle(int noArticle);
    List<Enchere> SelectEnchereByNoArticleWithArticle(int noArticle, ArticleVendu articleVendu);
    List<Enchere> SelectEnchereByNoUtilisateur(int noUtilisateur);
    List<Enchere> SelectEnchereByNoUtilisateurWithUtilisateur(int noUtilisateur, Utilisateur utilisateur);
    List<Enchere> SelectEnchereByUtilisateur(Utilisateur utilisateur);
    Enchere SelectEnchereByArticle(ArticleVendu article);

    List<Enchere> SelectAllEnchere();
    void InsertEnchere(Enchere enchere);
    void UpdateEnchere(Enchere enchere);
    void DeleteEnchere(Enchere enchere);

    public Enchere CreateNewEnchere(ResultSet rs) throws SQLException;
    public Enchere CreateNewEnchereWithArticle(ResultSet rs, ArticleVendu articleVendu) throws SQLException;
    public Enchere CreateNewEnchereWithUtilisateur(ResultSet rs, Utilisateur utilisateur) throws SQLException;

    }
