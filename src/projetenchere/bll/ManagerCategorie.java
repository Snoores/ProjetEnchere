package projetenchere.bll;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;

import java.util.List;

public interface ManagerCategorie {

    Categorie GetCategorieByNoCategorie(int noCategorie);
    Categorie GetCategorieByLibelle(String libelle);


    public List<Categorie> GetAllCategorie();
    public void CreateCategorie(Categorie categorie);
    public void DeleteCategorie(Categorie categorie);
    public void UpdateCategorie(Categorie categorie);
}
