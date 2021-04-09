package projetenchere.dal;

import projetenchere.bo.Retrait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAORetraitImpl implements DAORetrait{

    private final static String SELECT_ALL = "SELECT * FROM RETRAITS";
    private final static String SELECT_BY_NO_ARTICLE = "SELECT * FROM RETRAITS WHERE no_article = ?";

    private final static String INSERT = "INSERT INTO RETRAITS (no_article,rue,code_postal,ville) VALUES(?,?,?,?)";

    private final static String UPDATE = "UPDATE RETRAITS Set rue=?, code_postal=? ,ville=? WHERE no_article=?";

    private final static String DELETE = "DELETE FROM RETRAITS WHERE no_article=?";

    @Override
    public List<Retrait> SelectAllRetrait() {
        List<Retrait> listeRetrait = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Retrait retrait = new Retrait();
                retrait.setNoArticle(rs.getInt("no_article"));
                retrait.setRue(rs.getString("rue"));
                retrait.setCodePostal(rs.getString("code_postal"));
                retrait.setVille(rs.getString("ville"));
                listeRetrait.add(retrait);
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        for (Retrait retr : listeRetrait) {
            System.out.println(retr.toString());
        }

        return listeRetrait;
    }

    @Override
    public Retrait SelectRetraitByNoArticle(int noArticle) {

        Retrait retrait = new Retrait();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_NO_ARTICLE);
            stmt.setInt(1, noArticle);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                retrait.setNoArticle(rs.getInt("no_article"));
                retrait.setRue(rs.getString("rue"));
                retrait.setCodePostal(rs.getString("code_postal"));
                retrait.setVille(rs.getString("ville"));
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(retrait.toString());

        return retrait;
    }

    @Override
    public void InsertRetrait(Retrait retrait) {
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(INSERT);
            pStmt.setInt(1, retrait.getNoArticle());
            pStmt.setString(2, retrait.getRue());
            pStmt.setString(3, retrait.getCodePostal());
            pStmt.setString(4, retrait.getVille());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Retrait UpdateRetrait(Retrait retrait) {
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
            pStmt.setString(1, retrait.getRue());
            pStmt.setString(2, retrait.getCodePostal());
            pStmt.setString(3, retrait.getVille());
            pStmt.setInt(4, retrait.getNoArticle());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return retrait;
    }

    @Override
    public void DeleteRetrait(Retrait retrait) {
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(DELETE);
            pStmt.setInt(1, retrait.getNoArticle());
            pStmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
