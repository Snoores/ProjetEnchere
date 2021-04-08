package projetenchere.dal;

import projetenchere.bo.Utilisateur;

import java.util.List;

public interface DAOUtilisateur {

    Utilisateur UtilisateurConnectionByEmail(String email, String password);
    Utilisateur UtilisateurConnectionByPseudo(String pseudo, String password);


    List<Utilisateur> SelectAllUtilisateur();
    Utilisateur SelectUserByEmail(String email);
    Utilisateur SelectUserByPseudo(String pseudo);
    Utilisateur SelectUserByNoUtilisateur(int noUtilisateur);

    Utilisateur UpdateUtilisateur(Utilisateur utilisateur);

    void InsertUtilisateur(Utilisateur utilisateur);
    void DeleteUtilisateur(Utilisateur utilisateur);
}
