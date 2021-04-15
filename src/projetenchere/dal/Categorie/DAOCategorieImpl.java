package projetenchere.dal.Categorie;

import projetenchere.bo.Categorie;
import projetenchere.dal.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCategorieImpl implements DAOCategorie{
	private final static String INSERT = "INSERT INTO CATEGORIES(libelle) VALUES(?)";
	private final static String SELECTALL = "SELECT * FROM CATEGORIES";
	private final static String SELECTBYID = "SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie=?";
	private final static String SELECTBYLIBELLE = "SELECT no_categorie, libelle FROM CATEGORIES WHERE libelle=?";
	private final static String DELETE = "DELETE FROM CATEGORIES WHERE no_categorie=?";
	private final static String UPDATE = "UPDATE CATEGORIES set libelle=? WHERE no_categorie=?";

    @Override
    public Categorie SelectCategorieByNoCategorie(int noCategorie) {
    	Categorie categorie = new Categorie();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECTBYID);
			pStmt.setInt(1, noCategorie);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie; 
    }

    @Override
    public Categorie SelectCategorieByLibelle(String libelle) {
    	Categorie categorie = new Categorie();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECTBYLIBELLE);
			pStmt.setString(1, libelle);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie; 
    }

    @Override
    public List<Categorie> SelectAllCategorie() {
    	List<Categorie> categories = new ArrayList<>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECTALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				categories.add(categorie);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
    }

    @Override
    public void InsertCategorie(Categorie categorie) {
    	 try(Connection cnx = ConnectionProvider.getConnection()) {
             PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
             pStmt.setString(1, categorie.getLibelle());
             pStmt.executeUpdate();
         } catch (SQLException e) {
             System.err.println(e.getMessage());
         }
    }

    @Override
    public Categorie UpdateCategorie(Categorie categorie) {
    	try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
			pStmt.setInt(2, categorie.getNoCategorie());
			pStmt.setString(1, categorie.getLibelle());
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return categorie;
    }

    @Override
    public void DeleteCategorie(Categorie categorie) {
    	try(Connection cnx = ConnectionProvider.getConnection()) {
    		Categorie categorieToDelete = categorie;
			PreparedStatement pStmt = cnx.prepareStatement(DELETE);
			pStmt.setInt(1, categorieToDelete.getNoCategorie());
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
