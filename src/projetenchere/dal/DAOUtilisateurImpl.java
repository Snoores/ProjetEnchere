package projetenchere.dal;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUtilisateurImpl implements DAOUtilisateur{
	private final static String INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final static String SELECTALL = "SELECT * FROM UTILISATEURS";
	private final static String SELECTBYID = "SELECT no_utilisateur,pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE no_utilisateur=?";
	private final static String SELECTBYPSEUDO = "SELECT no_utilisateur,pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE pseudo=?";
	private final static String SELECTBYEMAIL = "SELECT no_utilisateur,pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE email=?";
	private final static String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?";
	private final static String UPDATE = "UPDATE UTILISATEURS set pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? WHERE no_utilisateur=?";
	private final static String UPDATECREDIT = "UPDATE UTILISATEURS set credit=? WHERE no_utilisateur=?";
	
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
    	List<Utilisateur> utilisateurs = new ArrayList<>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECTALL);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
				utilisateurs.add(utilisateur);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilisateurs;
    }

    @Override
    public Utilisateur SelectUserByEmail(String email) {
    	Utilisateur utilisateur = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECTBYEMAIL);
			pStmt.setString(1, email);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				List<Enchere> lste = new ArrayList<>();
				utilisateur.setListeEnchere(lste);
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
    }

    @Override
    public Utilisateur SelectUserByPseudo(String pseudo) {
    	Utilisateur utilisateur = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECTBYPSEUDO);
			pStmt.setString(1, pseudo);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				List<Enchere> lste = new ArrayList<>();
				utilisateur.setListeEnchere(lste);
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
    }

    @Override
    public Utilisateur SelectUserByNoUtilisateur(int noUtilisateur) {
    	Utilisateur utilisateur = new Utilisateur();
		try(Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECTBYID);
			pStmt.setInt(1, noUtilisateur);
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				List<Enchere> lste = new ArrayList<>();

				utilisateur.setListeEnchere(lste);
				utilisateur.setAdministrateur(rs.getBoolean("administrateur"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
    }

    @Override
    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur) {
    	try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
			pStmt.setInt(12, utilisateur.getNoUtilisateur());
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getCredit());
			pStmt.setBoolean(11, utilisateur.isAdministrateur());
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return utilisateur;
    }
    
    @Override
    public Utilisateur UpdateCreditUtilisateur(Utilisateur utilisateur, int newCredit) {
    	try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATECREDIT);
			pStmt.setInt(1, newCredit);
			pStmt.setInt(2, utilisateur.getNoUtilisateur());
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		return utilisateur;
    }

    @Override
    public void InsertUtilisateur(Utilisateur utilisateur) {
    	try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, utilisateur.getPseudo());
            pStmt.setString(2, utilisateur.getNom());
            pStmt.setString(3, utilisateur.getPrenom());
            pStmt.setString(4, utilisateur.getEmail());
            pStmt.setString(5, utilisateur.getTelephone());
            pStmt.setString(6, utilisateur.getRue());
            pStmt.setString(7, utilisateur.getCodePostal());
            pStmt.setString(8, utilisateur.getVille());
            pStmt.setString(9, utilisateur.getMotDePasse());
            pStmt.setInt(10, utilisateur.getCredit());
            pStmt.setBoolean(11, utilisateur.isAdministrateur());
            int nbRows = pStmt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = pStmt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
				}
			}
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void DeleteUtilisateur(Utilisateur utilisateur) {
    	try(Connection cnx = ConnectionProvider.getConnection()) {
    		Utilisateur utilisateurToDelete = utilisateur;
			PreparedStatement pStmt = cnx.prepareStatement(DELETE);
			pStmt.setInt(1, utilisateurToDelete.getNoUtilisateur());
			pStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
