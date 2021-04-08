package projetenchere.bo;

import java.util.Date;

public class Enchere {
    private Utilisateur utilisateur;
    private ArticleVendu articleVendu;
    private Date dateEnchere;
    private int montantEnchere;

    public Enchere() {
    }

    public Enchere(Utilisateur utilisateur, ArticleVendu articleVendu, Date dateEnchere, int montantEnchere) {
        this.utilisateur = utilisateur;
        this.articleVendu = articleVendu;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ArticleVendu getArticleVendu() {
        return articleVendu;
    }

    public void setArticleVendu(ArticleVendu articleVendu) {
        this.articleVendu = articleVendu;
    }

    public Date getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(Date dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public int getMontantEnchere() {
        return montantEnchere;
    }

    public void setMontantEnchere(int montantEnchere) {
        this.montantEnchere = montantEnchere;
    }
}
