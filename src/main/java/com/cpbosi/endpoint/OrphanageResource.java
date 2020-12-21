package com.cpbosi.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cpbosi.dto.CreateOrphanageDTO;
import com.cpbosi.entity.Orphanage;
import com.cpbosi.service.OrphanageService;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * OrphanageResource
 */
@Path("/orphanages")
@Tag(name = "orphanages")
public class OrphanageResource {

    @Inject OrphanageService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        description = "Retrieve the Orphanages Lists in all the situations (logical deleted or not).", 
        summary = "Retrieve All Orphanages")
    public Response listOrphanages(){
        return Response.ok(service.listOrphanages()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        description = "Insert a new Orphanage... more informations.", 
        summary = "Save an Orphanage")
    public Response createOrphanage(@RequestBody CreateOrphanageDTO dto){
        Orphanage orphanage = new Orphanage();
        orphanage.setName(dto.getName());
        service.createOrphanage(orphanage);
        
        return Response.ok().build();
    }

    @GET
    @Path("/other")
    @Tag(name = "Other Group too")
    @Tag(name = "orphanages")
    @Operation(
        description = "Resource build only to have example of another tag can be created.", 
        summary = "Just another resource")
    @APIResponse(responseCode = "200",  description = "OK")
    @APIResponse(responseCode = "404",  description = "Case error on process")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listSomethingOtherGroupSameResource(){
        return Response.ok().build();
    }
}