package projetenchere.bll;

import projetenchere.bo.Categorie;
import projetenchere.dal.DAOCategorie;
import projetenchere.dal.DAOSingleton;

import java.util.List;

public class ManagerCategorieImpl implements ManagerCategorie{
	private static DAOCategorie daoCategorie;

    static {
    	daoCategorie = DAOSingleton.getDAOCategorie();
    }
    
    @Override
    public Categorie GetCategorieByNoCategorie(int noCategorie) {
        return daoCategorie.SelectCategorieByNoCategorie(noCategorie);
    }

    @Override
    public Categorie GetCategorieByLibelle(String libelle) {
        return daoCategorie.SelectCategorieByLibelle(libelle);
    }

    @Override
    public List<Categorie> GetAllCategorie() {
        return daoCategorie.SelectAllCategorie();
    }

    @Override
    public void CreateCategorie(Categorie categorie) {
    	daoCategorie.InsertCategorie(categorie);
    }

    @Override
    public void DeleteCategorie(Categorie categorie) {
    	daoCategorie.DeleteCategorie(categorie);
    }

    @Override
    public void UpdateCategorie(Categorie categorie) {
    	daoCategorie.UpdateCategorie(categorie);
    }
}
