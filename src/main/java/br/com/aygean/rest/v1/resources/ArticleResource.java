package br.com.aygean.rest.v1.resources;

import br.com.aygean.rest.core.entities.Article;
import br.com.aygean.rest.core.services.ArticleService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/article")
public class ArticleResource {

    @Inject
    private ArticleService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response index(){
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response show(@PathParam("id") Long id){
        return Response.ok(service.show(id)).build();
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response show(@RequestBody Article article){
        return Response.ok(service.insert(article)).build();
    }
}
