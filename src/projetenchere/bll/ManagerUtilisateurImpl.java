package projetenchere.bll;

import projetenchere.bo.Utilisateur;
import projetenchere.dal.DAOSingleton;
import projetenchere.dal.DAOUtilisateur;

import java.util.List;

public class ManagerUtilisateurImpl implements ManagerUtilisateur{
	private static DAOUtilisateur daoUtilisateur;

    static {
    	daoUtilisateur = DAOSingleton.getDAOUtilisateur();
    }
    
    @Override
    public void Logout() {

    }

    @Override
    public Utilisateur LoginPseudo(String pseudo, String motDePasse) {
        return daoUtilisateur.UtilisateurConnectionByPseudo(pseudo, motDePasse);
    }
    
    @Override
    public Utilisateur LoginEmail(String email, String motDePasse) {
        return daoUtilisateur.UtilisateurConnectionByEmail(email, motDePasse);
    }
    
    @Override
    public Boolean CheckLoginEmail(String login) {
    	if(login.contains("@")) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    @Override
    public Utilisateur GetUtilisateurByNoUtilisateur(int noUtilisateur) {
        return daoUtilisateur.SelectUserByNoUtilisateur(noUtilisateur);
    }

    @Override
    public Utilisateur GetUtilisateurByPseudo(String pseudo) {
        return daoUtilisateur.SelectUserByPseudo(pseudo);
    }

    @Override
    public Utilisateur GetUtilisateurByEmail(String email) {
        return daoUtilisateur.SelectUserByEmail(email);
    }

    @Override
    public List<Utilisateur> GetAllUtilisateur() {
    	return daoUtilisateur.SelectAllUtilisateur();
    }

    @Override
    public void CreateUtilisateur(Utilisateur utilisateur) {
    	daoUtilisateur.InsertUtilisateur(utilisateur);
    }

    @Override
    public void DeleteUtilisateur(Utilisateur utilisateur) {
    	daoUtilisateur.DeleteUtilisateur(utilisateur);
    }

    @Override
    public void UpdateUtilisateur(Utilisateur utilisateur) {
    	daoUtilisateur.UpdateUtilisateur(utilisateur);
    }
    
    @Override
    public void UpdateCreditUtilisateur(Utilisateur utilisateur, int newCredit) {
    	daoUtilisateur.UpdateCreditUtilisateur(utilisateur, newCredit);
    }
}
