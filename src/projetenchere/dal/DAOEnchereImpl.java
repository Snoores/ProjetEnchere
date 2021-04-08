package projetenchere.dal;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;

import java.util.List;

public class DAOEnchereImpl implements DAOEnchere{
    @Override
    public List<Enchere> SelectEnchereByUtilisateur(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public Enchere SelectEnchereByArticle(ArticleVendu article) {
        return null;
    }

    @Override
    public List<Enchere> SelectAllEnchere() {
        return null;
    }

    @Override
    public void InsertEnchere(Enchere enchere) {

    }

    @Override
    public Enchere UpdateEnchere(Enchere enchere) {
        return null;
    }

    @Override
    public void DeleteEnchere(Enchere enchere) {

    }
}
