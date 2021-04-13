package projetenchere.bll;

import projetenchere.bo.Utilisateur;

import java.util.List;

public interface ManagerUtilisateur {

    void Logout();
    Utilisateur LoginPseudo(String pseudo, String motDePasse);
    Utilisateur LoginEmail(String email, String motDePasse);
    Boolean CheckLoginEmail(String login);

    Utilisateur GetUtilisateurByNoUtilisateur(int noUtilisateur);
    Utilisateur GetUtilisateurByPseudo(String pseudo);
    Utilisateur GetUtilisateurByEmail(String email);

    public List<Utilisateur> GetAllUtilisateur();
    public void CreateUtilisateur(Utilisateur utilisateur);
    public void DeleteUtilisateur(Utilisateur utilisateur);
    public void UpdateUtilisateur(Utilisateur utilisateur);
    public void UpdateCreditUtilisateur(Utilisateur utilisateur, int newCredit);
}
