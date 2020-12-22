package com.cpbosi.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * ConfigResource
 */
@Path("/configs")
@Tag(name = "configs")
public class ConfigResource {
    
    @ConfigProperty(name = "learning.system.property", defaultValue = "valorDefault")
    String property;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(
        description = "Retrieve the Config just to study properties config.", 
        summary = "Retrieve the Config")
    public Response listConfigs(){
        return Response.ok(property).build();
    }
}
