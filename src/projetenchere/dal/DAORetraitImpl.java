package projetenchere.dal;

import projetenchere.bo.Retrait;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAORetraitImpl implements DAORetrait{

    private final static String INSERT = "INSERT INTO RETRAITS(rue, code_postal, ville) VALUES(?, ?, ?)";


    @Override
    public List<Retrait> SelectAllRetrait() {
        return null;
    }

    @Override
    public Retrait SelectRetraitByNoArticle(int noArticle) {
        return null;
    }

    @Override
    public void InsertRetrait(Retrait retrait) {
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pStmt.setString(1, "test");
            pStmt.setString(2, "test4");
            pStmt.setString(3, "test2");

            pStmt.executeUpdate();
           
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Retrait UpdateRetrait(Retrait retrait) {

        return retrait;
    }

    @Override
    public void DeleteRetrait(Retrait retrait) {

    }
}
