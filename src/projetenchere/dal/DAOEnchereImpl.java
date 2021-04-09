package projetenchere.dal;

import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOEnchereImpl implements DAOEnchere{

    private final static String SELECT_BY_UTILISATEUR = "SELECT * FROM ENCHERES WHERE no_utilisateur = ?";
    private final static String SELECT_BY_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article = ?";
    private final static String SELECT_ALL = "SELECT * FROM ENCHERES ORDER BY no_article";

    private final static String INSERT = "INSERT INTO ENCHERES (no_utilisateur,no_article,date_enchere,montant_enchere) VALUES(?,?,?,?)";

    private final static String UPDATE = "UPDATE ENCHERES SET no_utilisateur=?,no_article=?,date_enchere=?,montant_enchere=? WHERE no_utilisateur=? AND no_article=?";

    private final static String DELETE = "DELETE FROM ENCHERES WHERE no_utilisateur=? AND no_article=?";

    @Override
    public Enchere SelectEnchereByNoArticle(int noArticle) {
        Enchere enchere = new Enchere();
        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ARTICLE);
            pstmt.setInt(1, noArticle);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                enchere.setNoArticle(rs.getInt("no_article"));
                enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
                enchere.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
                enchere.setMontantEnchere(rs.getInt("montant_enchere"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(enchere.toString());

        return enchere;
    }

    public List<Enchere> SelectEnchereByUtilisateur(Utilisateur utilisateur) {
        List<Enchere> listeEnchere = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_UTILISATEUR);
            pstmt.setInt(1, utilisateur.getNoUtilisateur());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Enchere enchere = new Enchere();
                enchere.setNoArticle(rs.getInt("no_article"));
                enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
                enchere.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
                enchere.setMontantEnchere(rs.getInt("montant_enchere"));
                listeEnchere.add(enchere);
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        for(Enchere ench : listeEnchere){
            System.out.println(ench.toString());
        }

        return listeEnchere;
    }

    @Override
    public Enchere SelectEnchereByArticle(ArticleVendu article) {
        Enchere enchere = new Enchere();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ARTICLE);
            pstmt.setInt(1, article.getNoArticle());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
                enchere.setNoArticle(rs.getInt("no_article"));
                enchere.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
                enchere.setMontantEnchere(rs.getInt("montant_enchere"));
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(enchere.toString());

        return enchere;
    }

    @Override
    public List<Enchere> SelectAllEnchere() {
        List<Enchere> listeEnchere = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Enchere enchere = new Enchere();
                enchere.setNoArticle(rs.getInt("no_article"));
                enchere.setNoUtilisateur(rs.getInt("no_utilisateur"));
                enchere.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
                enchere.setMontantEnchere(rs.getInt("montant_enchere"));
                listeEnchere.add(enchere);
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        for (Enchere enchere : listeEnchere) {
            System.out.println(enchere.toString());
        }

        return listeEnchere;
    }

    @Override
    public void InsertEnchere(Enchere enchere) {
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(INSERT);

            pStmt.setInt(1, enchere.getNoUtilisateur()); //nom_article
            pStmt.setInt(2, enchere.getNoArticle()); //description
            pStmt.setDate(3, java.sql.Date.valueOf(enchere.getDateEnchere())); //date_debut_enchere
            pStmt.setInt(4, enchere.getMontantEnchere()); //date_debut_enchere
            pStmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Enchere UpdateEnchere(Enchere enchere) {

        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
            pStmt.setInt(1, enchere.getNoUtilisateur());
            pStmt.setInt(2, enchere.getNoArticle());
            pStmt.setDate(3, java.sql.Date.valueOf(enchere.getDateEnchere()));
            pStmt.setInt(4, enchere.getMontantEnchere());
            pStmt.setInt(5, enchere.getNoUtilisateur());
            pStmt.setInt(6, enchere.getNoArticle());


            pStmt.executeUpdate();


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }


        return enchere; //TODO: Utilité ? Je crois qu'il y'en a pas. J'ai regardé les autres tps, y'en a aucun qui retourne d'objet (pas de resultset sur un update)
    }

    @Override
    public void DeleteEnchere(Enchere enchere) {
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(DELETE);
            pStmt.setInt(1, enchere.getNoUtilisateur());
            pStmt.setInt(2, enchere.getNoArticle());

            pStmt.executeUpdate(); //nb de lignes affectées par l'opération (ici delete)

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
