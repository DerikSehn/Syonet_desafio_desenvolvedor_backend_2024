package com.syonet.adapters.rest;

import java.util.List;

import com.syonet.application.service.NewsletterService;
import com.syonet.domain.model.Newsletter;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/noticias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NewsletterResource {

    @Inject
    NewsletterService newsletterService;

    @GET
    public Response getUnsentNewsletters() {
        List<Newsletter> unsentNewsletters = newsletterService.findUnsentNewsletters();
        return Response.ok(unsentNewsletters).build();
    }

    @POST
    @Transactional
    public Response createNewsletter(Newsletter newsletter) {
        newsletterService.saveNewsletter(newsletter);
        return Response.status(Response.Status.CREATED).build();
    }

    /*
     * @Path("/{id}")
     * 
     * @GET
     * public Response getNewsletterById(@PathParam("id") Long id) {
     * return newsletterService.getNewsletterById(id)
     * .map(newsletter -> Response.ok(newsletter).build())
     * .orElse(Response.status(Response.Status.NOT_FOUND).build());
     * }
     */

    /*
     * @PUT
     * 
     * @Path("/{id}")
     * 
     * @Transactional
     * public Response updateNewsletter(@PathParam("id") Long id, Newsletter
     * newsletter) {
     * return newsletterService.getNewsletterById(id)
     * .map(existingNewsletter -> {
     * newsletter.id = id;
     * newsletterService.saveNewsletter(newsletter);
     * return Response.ok().build();
     * })
     * .orElse(Response.status(Response.Status.NOT_FOUND).build());
     * }
     * 
     * @DELETE
     * 
     * @Path("/{id}")
     * 
     * @Transactional
     * public Response deleteNewsletter(@PathParam("id") Long id) {
     * newsletterService.deleteNewsletter(id);
     * return Response.noContent().build();
     * }
     */
}