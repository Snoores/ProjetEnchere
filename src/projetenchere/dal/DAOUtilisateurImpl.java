package projetenchere.dal;

import projetenchere.bo.Utilisateur;

import java.util.List;

public class DAOUtilisateurImpl implements DAOUtilisateur{
    @Override
    public Utilisateur UtilisateurConnectionByEmail(String email, String password) {
        return null;
    }

    @Override
    public Utilisateur UtilisateurConnectionByPseudo(String pseudo, String password) {
        return null;
    }

    @Override
    public List<Utilisateur> SelectAllUtilisateur() {
        return null;
    }

    @Override
    public Utilisateur SelectUserByEmail(String email) {
        return null;
    }

    @Override
    public Utilisateur SelectUserByPseudo(String pseudo) {
        return null;
    }

    @Override
    public Utilisateur SelectUserByNoUtilisateur(int noUtilisateur) {
        return null;
    }

    @Override
    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public void InsertUtilisateur(Utilisateur utilisateur) {

    }

    @Override
    public void DeleteUtilisateur(Utilisateur utilisateur) {

    }
}
