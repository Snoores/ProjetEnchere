package projetenchere.dal.Categorie;

import projetenchere.bo.Categorie;
import projetenchere.bo.Enchere;

import java.util.List;

public interface DAOCategorie {

    Categorie SelectCategorieByNoCategorie(int noCategorie);
    Categorie SelectCategorieByLibelle(String libelle);

    //CheckUniqueLibelle(String libelle);

    List<Categorie> SelectAllCategorie();
    void InsertCategorie(Categorie categorie);
    Categorie UpdateCategorie(Categorie categorie);
    void DeleteCategorie(Categorie categorie);

    //TODO: CreateCategorie();
}
