package projetenchere.dal;

import projetenchere.bo.Retrait;

import java.util.List;

public interface DAORetrait  {
    List<Retrait> SelectAllRetrait();
    Retrait SelectRetraitByNoArticle(int noArticle);
    void InsertRetrait(Retrait retrait);
    Retrait UpdateRetrait(Retrait retrait);
    void DeleteRetrait(Retrait retrait);
}
