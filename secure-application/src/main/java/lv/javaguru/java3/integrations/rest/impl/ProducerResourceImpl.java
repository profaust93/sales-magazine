package lv.javaguru.java3.integrations.rest.impl;

import lv.javaguru.java3.core.commands.producers.CreateProducerCommand;
import lv.javaguru.java3.core.commands.producers.CreateProducerResult;
import lv.javaguru.java3.core.commands.producers.GetProducerCommand;
import lv.javaguru.java3.core.commands.producers.GetProducerResult;
import lv.javaguru.java3.core.services.CommandExecutor;
import lv.javaguru.java3.integrations.rest.api.ProducerResource;
import lv.javaguru.java3.integrations.rest.api.RESTResource;
import lv.javaguru.java3.integrations.rest.dto.ProducerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path(RESTResource.API_PATH)
public class ProducerResourceImpl implements ProducerResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public ProducerResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/producers")
    public ProducerDTO create(ProducerDTO producerDTO) {
        if(producerDTO == null){
            System.err.println("Producer DTO is NULL");
        } else {
            if(producerDTO.getName() == null){
                System.err.println("Producer name IS NULL");
            }
        }

        CreateProducerCommand command = new CreateProducerCommand(
                producerDTO.getName(), producerDTO.getUrl()
        );
        CreateProducerResult result = commandExecutor.execute(command);
        return result.getProducer();
    }

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/producers/{producerId}")
    public ProducerDTO get(@PathParam("producerId") Long producerId) {
        GetProducerCommand command = new GetProducerCommand(producerId);
        GetProducerResult result = commandExecutor.execute(command);
        return result.getProducer();
    }

}
