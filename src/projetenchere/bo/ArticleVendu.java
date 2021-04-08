package projetenchere.bo;

import java.util.Date;

public class ArticleVendu {
    private int noArticle;
    private String nomArticle;
    private String description;
    private Date dateDebutEncheres;
    private Date dateFinEncheres;
    private int miseAPrix;
    private int prixVente;
    private Utilisateur utilisateur;
    private Categorie categorie;
    private String etatVente;
    private Retrait lieuRetrait;
    private Enchere enchere;

    public ArticleVendu() {
    }

    public ArticleVendu(String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres, int miseAPrix, int prixVente, Utilisateur utilisateur, Categorie categorie, String etatVente, Retrait lieuRetrait, Enchere enchere) {
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.etatVente = etatVente;
        this.lieuRetrait = lieuRetrait;
        this.enchere = enchere;
    }

    public ArticleVendu(int noArticle, String nomArticle, String description, Date dateDebutEncheres, Date dateFinEncheres, int miseAPrix, int prixVente, Utilisateur utilisateur, Categorie categorie, String etatVente, Retrait lieuRetrait, Enchere enchere) {
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEncheres = dateDebutEncheres;
        this.dateFinEncheres = dateFinEncheres;
        this.miseAPrix = miseAPrix;
        this.prixVente = prixVente;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
        this.etatVente = etatVente;
        this.lieuRetrait = lieuRetrait;
        this.enchere = enchere;
    }

    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebutEncheres() {
        return dateDebutEncheres;
    }

    public void setDateDebutEncheres(Date dateDebutEncheres) {
        this.dateDebutEncheres = dateDebutEncheres;
    }

    public Date getDateFinEncheres() {
        return dateFinEncheres;
    }

    public void setDateFinEncheres(Date dateFinEncheres) {
        this.dateFinEncheres = dateFinEncheres;
    }

    public int getMiseAPrix() {
        return miseAPrix;
    }

    public void setMiseAPrix(int miseAPrix) {
        this.miseAPrix = miseAPrix;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getEtatVente() {
        return etatVente;
    }

    public void setEtatVente(String etatVente) {
        this.etatVente = etatVente;
    }

    public Retrait getLieuRetrait() {
        return lieuRetrait;
    }

    public void setLieuRetrait(Retrait lieuRetrait) {
        this.lieuRetrait = lieuRetrait;
    }

    public Enchere getEnchere() {
        return enchere;
    }

    public void setEnchere(Enchere enchere) {
        this.enchere = enchere;
    }

    @Override
    public String toString() {
        return "ArticleVendu{" +
                "noArticle=" + noArticle +
                ", nomArticle='" + nomArticle + '\'' +
                ", description='" + description + '\'' +
                ", dateDebutEncheres=" + dateDebutEncheres +
                ", dateFinEncheres=" + dateFinEncheres +
                ", miseAPrix=" + miseAPrix +
                ", prixVente=" + prixVente +
                ", utilisateur=" + utilisateur +
                ", categorie=" + categorie +
                ", etatVente='" + etatVente + '\'' +
                ", lieuRetrait=" + lieuRetrait +
                ", enchere=" + enchere +
                '}';
    }
}
