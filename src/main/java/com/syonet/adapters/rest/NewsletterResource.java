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

}