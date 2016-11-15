package lv.javaguru.java3.integrations.rest.api;

import lv.javaguru.java3.integrations.rest.dto.ProducerDTO;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path(RESTResource.API_PATH)
public interface ProducerResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/producers")
    ProducerDTO create(ProducerDTO producerDTO);

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/producers/{producerId}")
    ProducerDTO get(@PathParam("producerId") Long producerId);

}
