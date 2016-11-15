package lv.javaguru.java3.integrations.rest.impl;

import lv.javaguru.java3.core.commands.product.CreateProductCommand;
import lv.javaguru.java3.core.commands.product.CreateProductResult;
import lv.javaguru.java3.core.services.CommandExecutor;
import lv.javaguru.java3.core.services.product.ProductValidator;
import lv.javaguru.java3.integrations.rest.api.ProductResource;
import lv.javaguru.java3.integrations.rest.api.RESTResource;
import lv.javaguru.java3.integrations.rest.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path(RESTResource.API_PATH)
public class ProductResourceImpl implements ProductResource {

    private CommandExecutor commandExecutor;

    @Autowired
    private ProductValidator validator;

    @Autowired
    public ProductResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/clients")
    @Override
    public ProductDTO create(ProductDTO productDTO) {
        validator.validate(productDTO);
        CreateProductCommand command = new CreateProductCommand(
                productDTO.getName(),
                productDTO.getPrice(),
                productDTO.getProductUrl());
        CreateProductResult result = commandExecutor.execute(command);
        return result.getProduct();
    }

    @GET
    @Produces(APPLICATION_JSON)
    @Path("/product/{productId}")
    @Override
    public ProductDTO get(@PathParam("productId") Long productId) {
        return null;
    }


}
