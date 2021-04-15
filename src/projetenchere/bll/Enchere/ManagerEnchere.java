package projetenchere.bll.Enchere;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;

import java.util.List;

public interface ManagerEnchere {

    Utilisateur GetGagnantEnchere(Enchere enchere);
    Enchere CheckMeilleureOffre(Enchere oldEnchere, Enchere newEnchere);
    List<Enchere> GetEnchereByUtilisateur(Utilisateur utilisateur);
    Enchere GetEnchereByArticle(ArticleVendu article);
    List<Enchere> GetEnchereByNoArticle(int noArticle);
    List<Enchere> GetEnchereByNoUtilisateur(int noUtilisateur);
    Enchere GetMeilleureOffre(ArticleVendu articleVendu);

    public List<Enchere> GetAllEnchere();
    public void CreateEnchere(Enchere enchere);
    public void DeleteEnchere(Enchere enchere);
    public void UpdateEnchere(Enchere enchere);
}
