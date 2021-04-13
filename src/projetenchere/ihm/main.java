package projetenchere.ihm;

import projetenchere.bll.ManagerSingleton;
import projetenchere.bll.ManagerUtilisateur;
import projetenchere.bo.Retrait;
import projetenchere.dal.DAOSingleton;
import projetenchere.dal.DAORetrait;

import javax.naming.Context;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;



public class main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        ManagerUtilisateur managerutilisateur = ManagerSingleton.getManagerUtilisateur();
        managerutilisateur.CheckLoginEmail("cypher-password", "motDePasse");
    }


    private static void ChiffrerMotDePasse(String motDePasse) throws NoSuchAlgorithmException {
        Charset charset = StandardCharsets.US_ASCII;
        String encryption = "SHA-1";

        MessageDigest md = MessageDigest.getInstance(encryption);
        byte[] hashedPassword = md.digest(motDePasse.getBytes(charset));
        motDePasse = Base64.getEncoder().encodeToString(hashedPassword);
        System.out.println(motDePasse);
    }
}
