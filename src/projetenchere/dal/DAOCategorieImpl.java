package projetenchere.dal;

import projetenchere.bo.Categorie;
import projetenchere.bo.Enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAOCategorieImpl implements DAOCategorie{
	private final static String INSERT = "INSERT INTO CATEGORIES(libelle) VALUES(?)";

    @Override
    public Categorie SelectCategorieByNoCategorie(int noCategorie) {
        return null;
    }

    @Override
    public Categorie SelectCategorieByLibelle(String libelle) {
        return null;
    }

    @Override
    public List<Categorie> SelectAllCategorie() {
        return null;
    }

    @Override
    public void InsertCategorie(Categorie categorie) {
    	 try(Connection cnx = ConnectionProvider.getConnection()) {
             PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
             pStmt.setString(1, "test");
             pStmt.executeUpdate();
            
         } catch (SQLException e) {
             System.err.println(e.getMessage());
         }
    }

    @Override
    public Enchere UpdateCategorie(Categorie categorie) {
        return null;
    }

    @Override
    public void DeleteCategorie(Categorie categorie) {

    }
}
