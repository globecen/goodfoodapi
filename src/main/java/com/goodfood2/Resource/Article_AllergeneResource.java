package com.goodfood2.Resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.goodfood2.Entity.Article_Allergene;
import com.goodfood2.utils.QueryUtils;

/**
 * Route liees aux allergenes.
 */
@Path("/Article_Allergene")
@Tag(name = "Article_Allergene Resource", description = "L'ensemble des routes pour la partie Article Allergene")
public class Article_AllergeneResource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere tous les articles_allergenes des utilisateurs.
     * 
     * @return Les allergenes.
     */
    @Path("/")
    @GET
    public List<Article_Allergene> article_allergenes() {
        return entityManager.createQuery(
                QueryUtils.makeFindAllQuery("Article_Allergene"))
                .getResultList();
    }

    /**
     * Cree un article_allergene.
     * 
     * @param a L article_allergene.
     * @return Le statut de la reponse.
     */
    @Path("/creer")
    @POST
    @Transactional
    public Response creerArticle_Allergene(Article_Allergene a) throws Exception {
        entityManager.persist(a);
        return Response.status(200).build();
    }

    /**
     * Modifie un article_allergene.
     * 
     * @param a L article_allergene.
     * @return L article_allergene modifiee.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    public Article_Allergene modifArticle_Allergene(Article_Allergene a) throws Exception {
        return entityManager.merge(a);
    }

    /**
     * Supprime un article_allergene.
     * 
     * @param id L id de l article_allergene.
     * @return Le statut de l article_allergene.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprArticle_Allergene(@PathParam("id") Long id) throws Exception {
        Article_Allergene a = (Article_Allergene) entityManager.createQuery(
                QueryUtils.makeFindByParamQueryInt("Article_Allergene", "id", id.toString()))
                .getResultList().get(0);
        if (a == null) {
            return Response.status(404).build();
        }
        entityManager.remove(a);
        return Response.status(200).build();
    }
}
