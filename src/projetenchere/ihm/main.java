package projetenchere.ihm;

import projetenchere.bo.Retrait;
import projetenchere.dal.DAOSingleton;
import projetenchere.dal.DAORetrait;

public class main {
    public static void main(String[] args) {
        DAORetrait daoRetrait = DAOSingleton.getDAORetrait();
        daoRetrait.InsertRetrait(new Retrait());
    }
}
