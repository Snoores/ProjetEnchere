package projetenchere.ihm;

import projetenchere.bo.Retrait;
import projetenchere.dal.DAOFactory;
import projetenchere.dal.DAORetrait;

public class main {
    public static void main(String[] args) {
        DAORetrait daoRetrait = DAOFactory.getDAORetrait();
        daoRetrait.InsertRetrait(new Retrait());
    }
}
