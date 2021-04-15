package projetenchere.ihm;

import projetenchere.bll.ManagerSingleton;
import projetenchere.bll.Utilisateur.ManagerUtilisateur;
import projetenchere.bo.Utilisateur;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;


public class main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Utilisateur utilisateur = new Utilisateur();
        System.out.println();

    }

    public String ChiffrerMotDePasse(String motDePasse) throws NoSuchAlgorithmException {
        Charset charset = StandardCharsets.US_ASCII;
        String encryption = "SHA-1";

        MessageDigest md = MessageDigest.getInstance(encryption);
        byte[] hashedPassword = md.digest(motDePasse.getBytes(charset));
        motDePasse = Base64.getEncoder().encodeToString(hashedPassword);
        return motDePasse;
    }


}
