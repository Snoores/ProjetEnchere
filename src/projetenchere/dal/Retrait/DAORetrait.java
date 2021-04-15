package projetenchere.dal.Retrait;

import projetenchere.bo.Retrait;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DAORetrait  {
    List<Retrait> SelectAllRetrait();
    Retrait SelectRetraitByNoArticle(int noArticle);
    void InsertRetrait(Retrait retrait);
    Retrait UpdateRetrait(Retrait retrait);
    void DeleteRetrait(Retrait retrait);

    Retrait CreateRetrait(ResultSet rs) throws SQLException;
}
