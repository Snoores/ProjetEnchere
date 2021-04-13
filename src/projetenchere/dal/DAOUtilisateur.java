package projetenchere.dal;

import projetenchere.bo.Utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAOUtilisateur {

    Utilisateur UtilisateurConnectionByEmail(String email, String password);
    Utilisateur UtilisateurConnectionByPseudo(String pseudo, String password);


    List<Utilisateur> SelectAllUtilisateur();
    Utilisateur SelectUserByEmail(String email);
    Utilisateur SelectUserByPseudo(String pseudo);
    Utilisateur SelectUserByNoUtilisateur(int noUtilisateur);

    Utilisateur UpdateUtilisateur(Utilisateur utilisateur);
    Utilisateur UpdateCreditUtilisateur(Utilisateur utilisateur, int newCredit);

    void InsertUtilisateur(Utilisateur utilisateur);
    void DeleteUtilisateur(Utilisateur utilisateur);

    Utilisateur CreateUtilisateur(ResultSet rs) throws SQLException;
}
