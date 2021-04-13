package projetenchere.bll;

import projetenchere.bo.Utilisateur;
import projetenchere.dal.DAOSingleton;
import projetenchere.dal.DAOUtilisateur;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

public class ManagerUtilisateurImpl implements ManagerUtilisateur{
	private static DAOUtilisateur daoUtilisateur;

    static {
    	daoUtilisateur = DAOSingleton.getDAOUtilisateur();
    }

    @Override
    public String ChiffrerMotDePasse(String motDePasse) throws NoSuchAlgorithmException {
        Charset charset = StandardCharsets.US_ASCII;
        String encryption = "SHA-1";

        MessageDigest md = MessageDigest.getInstance(encryption);
        byte[] hashedPassword = md.digest(motDePasse.getBytes(charset));
        motDePasse = Base64.getEncoder().encodeToString(hashedPassword);
        return motDePasse;
    }
    
    @Override
    public void Logout() {

    }
    
    @Override
    public Utilisateur CheckLoginEmail(String login, String motDePasse) throws NoSuchAlgorithmException {
    	motDePasse = ChiffrerMotDePasse(motDePasse);
        System.out.println(motDePasse);
        if(login.contains("@")) {
    		return daoUtilisateur.UtilisateurConnectionByEmail(login, motDePasse);
    	}
    	else {
    		return daoUtilisateur.UtilisateurConnectionByPseudo(login, motDePasse);
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
    public void CreateUtilisateur(Utilisateur utilisateur) throws NoSuchAlgorithmException {
        utilisateur.setMotDePasse(ChiffrerMotDePasse(utilisateur.getMotDePasse()));
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
