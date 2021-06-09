package org.goodfood2.Resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Response;
import javax.persistence.EntityManager;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import org.goodfood2.Entity.Article;
import org.goodfood2.Entity.Categorie_Article;
import org.goodfood2.Entity.VoArtAllergene;
import org.goodfood2.Entity.VoArtPromo;
import org.goodfood2.utils.QueryUtils;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;

/**
 * Route liees aux articles.
 */
@Path("/Article")
@Tag(name = "Article Resource", description = "L'ensemble des routes pour la partie Article")
public class ArticleResource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * @return Le nombre d articles.
     */
    @Path("/nombre")
    @GET
    @Transactional
    @PermitAll
    public long nombreArticle() throws Exception {
        return Article.count();
    }

    /**
     * @return Le nombre d ingredients.
     */
    @Path("/Ingr/nombre")
    @GET
    @Transactional
    @PermitAll
    public long nombreIngr() throws Exception {
        return Article.count("from Article obj where i_estMenu = 0");
    }

    /**
     * @return Le nombre de menus.
     */
    @Path("/Menu/nombre")
    @GET
    @Transactional
    @PermitAll
    public long nombreMenu() throws Exception {
        return Article.count("from Article obj where i_estMenu = 1");
    }

    /**
     * Recupere un article.
     * 
     * @param id L id de l article.
     * @return L article.
     */
    @Path("/{id}")
    @GET
    @Transactional
    @PermitAll
    public Article articleId(@PathParam("id") Long id) throws Exception {
        Article article = (Article) entityManager
                .createQuery(QueryUtils.makeFindByParamQueryInt("Article", "id", id.toString())).getResultList().get(0);
        return article;
    }

    /**
     * Supprime un article.
     * 
     * @param id L id de l article.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    @RolesAllowed({ "admin" })
    public Response supprArticle(@PathParam("id") Long id) throws Exception {
        Article article = (Article) entityManager
                .createQuery(QueryUtils.makeFindByParamQueryInt("Article", "id", id.toString())).getResultList().get(0);
        if (article == null) {
            return Response.status(404).build();
        }
        entityManager.remove(article);
        return Response.status(200).build();
    }

    /**
     * Cree un article.
     * 
     * @param a L article.
     * @return Le statut de la reponse.
     */
    @Path("/creer")
    @POST
    @Transactional
    // @RolesAllowed({ "admin" })
    public Response creerArticle(Article a) throws Exception {
        entityManager.persist(a);
        return Response.status(200).build();
    }

    /**
     * Modifie un article.
     * 
     * @param a L article.
     * @return L article modifie.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    @RolesAllowed({ "admin" })
    public Article modifArticle(Article a) throws Exception {
        return entityManager.merge(a);
    }

    /**
     * Recupere les allergenes liees a un article.
     * 
     * @param id L id de l article.
     * @return La liste des allergenes.
     * @throws Exception
     */
    @Path("/{id}/Allergene")
    @GET
    @Transactional
    @PermitAll
    public List<VoArtAllergene> artAllergene(@PathParam("id") Long id) throws Exception {
        return entityManager
                .createNativeQuery(
                        "select distinct(libelle_allergene) from Vo_Full_Art_Allergenes where id_article = " + id)
                .getResultList();
    }

    /**
     * Recupere les promotions liees a un article.
     * 
     * @param id L id de l article.
     * @return La liste des promotions.
     * @throws Exception
     */
    @Path("/{id}/Promo")
    @GET
    @Transactional
    @PermitAll
    public List<VoArtPromo> artPromo(@PathParam("id") Long id) throws Exception {
        return entityManager.createNativeQuery("select distinct(reduction) from Vo_Art_Promo where id_article = " + id)
                .getResultList();
    }

    /**
     * Recupere les categories liees a un article.
     * 
     * @param id L id de l article.
     * @return La categorie.
     * @throws Exception
     */
    @Path("/{id}/Categorie_Article")
    @GET
    public List<Categorie_Article> categorieArticleId(@PathParam("id") Long id) throws Exception {
        Categorie_Article ret = null;
        return entityManager.createNativeQuery("select id_categorie_article from Article where id_article = " + id)
                .getResultList();
    }

    /**
     * Recupere la liste des articles en fonctions de plusieurs parametres.
     * 
     * @param pageSize             Le nombre d articles par page.
     * @param pageNumber           Le numero de page.
     * @param i_estMenu            Choix pour recuperer les ingredients, les menus
     *                             ou tous les articles.
     * @param d_libelleArticle     Une partie d'un libelle.
     * @param e_descriptionArticle Une partie de la description.
     * @param b_idCategorieArticle Une categorie specifique d articles.
     * @return La liste d articles.
     */
    @Path("/")
    @GET
    @Transactional
    @PermitAll
    public List<Article> articles(@DefaultValue("25") @QueryParam("pageSize") Integer pageSize,
            @DefaultValue("1") @QueryParam("pageNumber") Integer pageNumber,
            @DefaultValue("") @QueryParam("i_estMenu") String i_estMenu,
            @DefaultValue("") @QueryParam("d_libelleArticle") String d_libelleArticle,
            @DefaultValue("") @QueryParam("e_descriptionArticle") String e_descriptionArticle,
            @DefaultValue("") @QueryParam("b_idCategorieArticle") String b_idCategorieArticle) {
        PanacheQuery<Article> articles = null;
        String query = "from Article" + " ";
        query += String.format("where d_libelleArticle like '%s'", "%" + d_libelleArticle + "%") + " ";
        query += String.format("and e_descriptionArticle like '%s'", "%" + e_descriptionArticle + "%") + " ";

        if (!i_estMenu.isEmpty()) {
            query += String.format("and i_estMenu = '%s'", i_estMenu) + " ";
        }

        if (!b_idCategorieArticle.isEmpty()) {
            query += String.format("and b_idCategorieArticle = %s", b_idCategorieArticle) + " ";
        }

        query += "and j_estActive = 1";

        articles = Article.find(query);
        articles.page(Page.ofSize(pageSize));
        for (int i = 0; i < pageNumber - 1; i++) {
            articles.nextPage();
        }
        return articles.list();
    }

}
