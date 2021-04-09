package projetenchere.bo;

public class Retrait {
    private String rue;
    private String codePostal;
    private String ville;
    private int no_article;

    public Retrait() {
    }

    public Retrait(int no_article, String rue, String codePostal, String ville) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.no_article = no_article;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNoArticle() {
        return no_article;
    }

    public void setNoArticle(int no_article) {
        this.no_article = no_article;
    }

    @Override
    public String toString() {
        return "Retrait{" +
                "rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", no_article=" + no_article +
                '}';
    }
}
