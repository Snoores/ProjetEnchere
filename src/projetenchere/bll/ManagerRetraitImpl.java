package projetenchere.bll;

import projetenchere.bo.Retrait;
import projetenchere.dal.DAOFactory;
import projetenchere.dal.DAORetrait;

import java.util.List;

public class ManagerRetraitImpl implements ManagerRetrait{
    DAORetrait daoRetrait = DAOFactory.getDAORetrait();

    @Override
    public Retrait GetRetraitByNoArticle(int noArticle) {
        return daoRetrait.SelectRetraitByNoArticle(noArticle);
    }

    @Override
    public List<Retrait> GetAllRetrait() {
        return daoRetrait.SelectAllRetrait();
    }

    @Override
    public void CreateRetrait(Retrait retrait) {
        daoRetrait.InsertRetrait(retrait);
    }

    @Override
    public void DeleteRetrait(Retrait retrait) {
        daoRetrait.DeleteRetrait(retrait);
    }

    @Override
    public void UpdateRetrait(Retrait retrait) {
        daoRetrait.InsertRetrait(retrait);
    }
}
