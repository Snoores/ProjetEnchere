package projetenchere.bll;

import projetenchere.bo.Utilisateur;

import java.util.List;

public interface ManagerUtilisateur {

    void Logout();
    Utilisateur Login(String pseudo, String motDePasse);

    Utilisateur GetUtilisateurByNoUtilisateur(int noUtilisateur);
    Utilisateur GetUtilisateurByPseudo(String pseudo);
    Utilisateur GetUtilisateurByEmail(String email);

    public List<Utilisateur> GetAllUtilisateur();
    public void CreateUtilisateur(Utilisateur utilisateur);
    public void DeleteUtilisateur(Utilisateur utilisateur);
    public void UpdateUtilisateur(Utilisateur utilisateur);
}
