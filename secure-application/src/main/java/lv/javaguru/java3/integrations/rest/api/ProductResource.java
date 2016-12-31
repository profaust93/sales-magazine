package lv.javaguru.java3.integrations.rest.api;

import lv.javaguru.java3.dto.ProductDTO;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path(RESTResource.API_PATH)
public interface ProductResource {

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/product")
    ProductDTO create(ProductDTO productDTO);

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/product/{productId}")
    ProductDTO get(@PathParam("productId")Long productId);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/product/update")
    ProductDTO update(ProductDTO productDTO);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/product/remove/{productId}")
    String remove(@PathParam("productId")Long productId);
}
