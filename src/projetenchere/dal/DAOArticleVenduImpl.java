package projetenchere.dal;

import projetenchere.bll.ManagerCategorie;
import projetenchere.bll.ManagerEnchere;
import projetenchere.bll.ManagerSingleton;
import projetenchere.bll.ManagerUtilisateur;
import projetenchere.bo.ArticleVendu;
import projetenchere.bo.Categorie;
import projetenchere.bo.Utilisateur;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOArticleVenduImpl implements DAOArticleVendu {

    private final static String SELECT_ALL = "SELECT * FROM ARTICLES_VENDUS ORDER BY date_debut_encheres";
    private final static String SELECT_BY_UTILISATEUR = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur = ? ORDER BY date_debut_encheres";
    private final static String SELECT_BY_UTILISATEUR_AND_ETAT = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur = ? AND etat_vente = ? ORDER BY date_debut_encheres";
    private final static String SELECT_BY_ETAT = "SELECT * FROM ARTICLES_VENDUS WHERE etat_vente = ? ORDER BY date_debut_encheres";
    private final static String SELECT_BY_NUMERO_ARTICLE = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
    private final static String SELECT_BY_CATEGORIE = "SELECT * FROM ARTICLES_VENDUS WHERE no_categorie = ? ORDER BY date_debut_encheres";

    private final static String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente) VALUES(?,?,?,?,?,?,?,?,?)";

    private final static String DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";

    private final static String UPDATE = "UPDATE ARTICLES_VENDUS Set nom_article=?, description=?, date_debut_encheres=? ,date_fin_encheres=? ,prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=?, etat_vente=? WHERE no_article=?";


    @Override
    public List<ArticleVendu> SelectArticleVenduByUtilisateur(Utilisateur utilisateur) {
        List<ArticleVendu> listeArticleVendu = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_UTILISATEUR);
            pstmt.setInt(1, utilisateur.getNoUtilisateur());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeArticleVendu.add(createArticleVendu(rs));
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return listeArticleVendu;
    }

    @Override
    public ArticleVendu SelectArticleVenduByNoArticle(int noArticle) {
        ArticleVendu articleVendu = new ArticleVendu();

        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_NUMERO_ARTICLE);
            pstmt.setInt(1, noArticle);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                articleVendu = createArticleVendu(rs);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return articleVendu;
    }

    @Override
    public List<ArticleVendu> SelectArticleVenduByCategorie(Categorie categorie) {
        List<ArticleVendu> listeArticleVendu = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_CATEGORIE);
            pstmt.setInt(1, categorie.getNoCategorie());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeArticleVendu.add(createArticleVendu(rs));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return listeArticleVendu;
    }

    @Override
    public List<ArticleVendu> SelectArticleVenduByUtilisateurAndEtat(Utilisateur utilisateur, String etat) { //TODO: Dis Function
        List<ArticleVendu> listeArticleVendu = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_UTILISATEUR_AND_ETAT);
            pstmt.setInt(1, utilisateur.getNoUtilisateur());
            pstmt.setString(2, etat);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeArticleVendu.add(createArticleVendu(rs));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        for (ArticleVendu artVendu : listeArticleVendu) {
            System.out.println(artVendu.toString());
        }

        return listeArticleVendu;
    }

    @Override
    public List<ArticleVendu> SelectArticleVenduByEtat(String etat) {
        List<ArticleVendu> listeArticleVendu = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ETAT);
            pstmt.setString(1, etat);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                listeArticleVendu.add(createArticleVendu(rs));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return listeArticleVendu;
    }

    @Override
    public List<ArticleVendu> SelectAllArticleVendu() {
        List<ArticleVendu> listeArticleVendu = new ArrayList<>();

        try (Connection cnx = ConnectionProvider.getConnection()) {
            Statement stmt = cnx.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                listeArticleVendu.add(createArticleVendu(rs));
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return listeArticleVendu;
    }

    @Override
    public void InsertArticleVendu(ArticleVendu articleVendu) {
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            pStmt.setString(1, articleVendu.getNomArticle()); //nom_article
            pStmt.setString(2, articleVendu.getDescription()); //description
            pStmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres())); //date_debut_enchere
            pStmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDateFinEncheres())); //date_fin_enchere
            pStmt.setInt(5, articleVendu.getMiseAPrix()); //mise a prix
            pStmt.setInt(6, articleVendu.getPrixVente()); //prix de vente
            pStmt.setInt(7, articleVendu.getUtilisateur().getNoUtilisateur()); //utilisateur
            pStmt.setInt(8, articleVendu.getCategorie().getNoCategorie()); //utilisateur
            pStmt.setString(9, articleVendu.getEtatVente()); //utilisateur


            pStmt.executeUpdate();


            ResultSet rs = pStmt.getGeneratedKeys();
            if(rs.next()) {
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public ArticleVendu UpdateArticleVendu(ArticleVendu articleVendu) { //TODO: Est ce que l'on doit retourner un article ? Finalement, l'article que l'on passe en paramètre, c'est notre nouvel article
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(UPDATE);
            pStmt.setString(1, articleVendu.getNomArticle()); //nom_article
            pStmt.setString(2, articleVendu.getDescription()); //description
            pStmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres())); //date_debut_enchere
            pStmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDateFinEncheres())); //date_fin_enchere
            pStmt.setInt(5, articleVendu.getMiseAPrix()); //mise a prix
            pStmt.setInt(6, articleVendu.getPrixVente()); //prix de vente
            pStmt.setInt(7, articleVendu.getUtilisateur().getNoUtilisateur()); //utilisateur
            pStmt.setInt(8, articleVendu.getCategorie().getNoCategorie()); //utilisateur
            pStmt.setString(9, articleVendu.getEtatVente()); //utilisateur
            pStmt.setInt(10, articleVendu.getNoArticle());

            pStmt.executeUpdate();


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return articleVendu; //TODO: Utilité ? Je crois qu'il y'en a pas. J'ai regardé les autres tps, y'en a aucun qui retourne d'objet (pas de resultset sur un update)
    }

    @Override
    public void DeleteArticleVendu(ArticleVendu articleVendu) {
        try(Connection cnx = ConnectionProvider.getConnection()) {
            PreparedStatement pStmt = cnx.prepareStatement(DELETE);
            pStmt.setInt(1, articleVendu.getNoArticle());

            pStmt.executeUpdate(); //nb de lignes affectées par l'opération (ici delete)

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private ArticleVendu createArticleVendu(ResultSet rs) throws SQLException {

        ManagerUtilisateur managerUtilisateur = ManagerSingleton.getManagerUtilisateur();
        ManagerCategorie managerCategorie = ManagerSingleton.getManagerCategorie();

        ArticleVendu articleVendu = new ArticleVendu();
        articleVendu.setNoArticle(rs.getInt("no_article"));
        articleVendu.setNomArticle(rs.getString("nom_article"));
        articleVendu.setDescription(rs.getString("description"));
        articleVendu.setDateDebutEncheres(rs.getDate("date_debut_encheres").toLocalDate());
        articleVendu.setDateFinEncheres(rs.getDate("date_fin_encheres").toLocalDate());
        articleVendu.setMiseAPrix(rs.getInt("prix_initial"));
        articleVendu.setPrixVente(rs.getInt("prix_vente"));
        articleVendu.setCategorie(managerCategorie.GetCategorieByNoCategorie(rs.getInt("no_categorie")));
        articleVendu.setEtatVente(rs.getString("etat_vente"));
        articleVendu.setUtilisateur(managerUtilisateur.GetUtilisateurByNoUtilisateur(rs.getInt("no_utilisateur")));

        return articleVendu;
    }
}
