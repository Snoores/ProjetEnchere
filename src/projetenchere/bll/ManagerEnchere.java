package projetenchere.bll;

import projetenchere.bo.Categorie;
import projetenchere.bo.Enchere;
import projetenchere.bo.Utilisateur;

import java.util.List;

public interface ManagerEnchere {

    Utilisateur GetGagnantEnchere(Enchere enchere);
    Enchere CheckMeilleureOffre(Enchere oldEnchere, Enchere newEnchere);

    public List<Enchere> GetAllEnchere();
    public void CreateEnchere(Enchere enchere);
    public void DeleteEnchere(Enchere enchere);
    public void UpdateEnchere(Enchere enchere);
}
