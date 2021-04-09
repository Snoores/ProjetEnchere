package projetenchere.bll;

import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;
import projetenchere.dal.DAOEnchere;
import projetenchere.dal.DAOFactory;
import projetenchere.dal.DAOUtilisateur;

import java.util.List;

public class ManagerEnchereImpl implements ManagerEnchere{
    DAOEnchere daoEnchere = DAOFactory.getDAOEnchere();
    DAOUtilisateur daoUtilisateur = DAOFactory.getDAOUtilisateur();

    @Override
    public Utilisateur GetGagnantEnchere(Enchere enchere) {
        return daoUtilisateur.SelectUserByNoUtilisateur(enchere.getNoUtilisateur());
    }

    @Override
    public Enchere CheckMeilleureOffre(Enchere oldEnchere, Enchere newEnchere) {

        if (oldEnchere.getMontantEnchere() < newEnchere.getMontantEnchere()){
            UpdateEnchere(newEnchere);
            return newEnchere;
        }
        return oldEnchere;
    }

    @Override
    public List<Enchere> GetAllEnchere() {
        return daoEnchere.SelectAllEnchere();
    }

    @Override
    public void CreateEnchere(Enchere enchere) {
        daoEnchere.InsertEnchere(enchere);
    }

    @Override
    public void DeleteEnchere(Enchere enchere) {
        daoEnchere.DeleteEnchere(enchere);
    }

    @Override
    public void UpdateEnchere(Enchere enchere) {
        daoEnchere.UpdateEnchere(enchere);
    }
}
