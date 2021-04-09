package projetenchere.bo;

import java.time.LocalDate;

public class Enchere {
    private int no_utilisateur;
    private int no_article;
    private LocalDate dateEnchere;
    private int montantEnchere;

    public Enchere() {
    }

    public Enchere(int no_utilisateur, int no_articleVendu, LocalDate dateEnchere, int montantEnchere) {
        this.no_utilisateur = no_utilisateur;
        this.no_article = no_articleVendu;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
    }

    public int getNoUtilisateur() {
        return no_utilisateur;
    }

    public void setNoUtilisateur(int no_utilisateur) {
        this.no_utilisateur = no_utilisateur;
    }

    public int getNoArticle() {
        return no_article;
    }

    public void setNoArticle(int no_article) {
        this.no_article = no_article;
    }

    public LocalDate getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(LocalDate dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public int getMontantEnchere() {
        return montantEnchere;
    }

    public void setMontantEnchere(int montantEnchere) {
        this.montantEnchere = montantEnchere;
    }

    @Override
    public String toString() {
        return "Enchere{" +
                "utilisateur=" + no_utilisateur +
                ", articleVendu=" + no_article +
                ", dateEnchere=" + dateEnchere +
                ", montantEnchere=" + montantEnchere +
                '}';
    }
}
