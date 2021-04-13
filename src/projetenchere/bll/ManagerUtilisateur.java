package projetenchere.bll;

import projetenchere.bo.Utilisateur;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface ManagerUtilisateur {

    void Logout();
    Utilisateur CheckLoginEmail(String login, String motDePasse) throws NoSuchAlgorithmException;

    Utilisateur GetUtilisateurByNoUtilisateur(int noUtilisateur);
    Utilisateur GetUtilisateurByPseudo(String pseudo);
    Utilisateur GetUtilisateurByEmail(String email);

    public List<Utilisateur> GetAllUtilisateur();
    public void CreateUtilisateur(Utilisateur utilisateur) throws NoSuchAlgorithmException;
    public void DeleteUtilisateur(Utilisateur utilisateur);
    public void UpdateUtilisateur(Utilisateur utilisateur);
    public void UpdateCreditUtilisateur(Utilisateur utilisateur, int newCredit);

    public String ChiffrerMotDePasse(String motDePasse) throws NoSuchAlgorithmException;
}
