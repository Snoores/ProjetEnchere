package projetenchere.dal;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;

import java.util.List;

public interface DAOEnchere {

    List<Enchere> SelectEnchereByUtilisateur(Utilisateur utilisateur);
    Enchere SelectEnchereByArticle(ArticleVendu article);

    List<Enchere> SelectAllEnchere();
    void InsertEnchere(Enchere enchere);
    Enchere UpdateEnchere(Enchere enchere);
    void DeleteEnchere(Enchere enchere);
}
