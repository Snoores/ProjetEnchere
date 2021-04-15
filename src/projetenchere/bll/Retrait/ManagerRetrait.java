package projetenchere.bll.Retrait;

import projetenchere.bo.Enchere;
import projetenchere.bo.Retrait;

import java.util.List;

public interface ManagerRetrait {

    Retrait GetRetraitByNoArticle(int noArticle);


    public List<Retrait> GetAllRetrait();
    public void CreateRetrait(Retrait retrait);
    public void DeleteRetrait(Retrait retrait);
    public void UpdateRetrait(Retrait retrait);
}
