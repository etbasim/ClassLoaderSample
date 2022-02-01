package com.xxx.webutilities;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/test/v1")
public class TestRestServiceImpl {

    @GET
    @Path("/request")
    public Response longRequest(
    ) {
        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        return builder.build();
    }
}
