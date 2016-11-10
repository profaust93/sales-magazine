package lv.javaguru.java3.integrations.rest.impl;

import lv.javaguru.java3.core.commands.clients.CreateClientCommand;
import lv.javaguru.java3.core.commands.clients.CreateClientResult;
import lv.javaguru.java3.core.commands.clients.GetClientCommand;
import lv.javaguru.java3.core.commands.clients.GetClientResult;
import lv.javaguru.java3.core.services.CommandExecutor;
import lv.javaguru.java3.integrations.rest.api.ClientResource;
import lv.javaguru.java3.integrations.rest.api.RESTResource;
import lv.javaguru.java3.integrations.rest.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Component
@Path(RESTResource.API_PATH)
public class ClientResourceImpl implements ClientResource {

    private CommandExecutor commandExecutor;

    @Autowired
    public ClientResourceImpl(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/clients")
    public ClientDTO create(ClientDTO clientDTO) {
        if(clientDTO == null){
            System.err.println("Cliend DTO is NULL");
        } else {
            if(clientDTO.getLogin() == null){
                System.err.println("Cliend login IS NULL");
            }
             if( clientDTO.getPassword() == null){
                 System.err.println("Pwd is null");
             }
        }

        CreateClientCommand command = new CreateClientCommand(
                clientDTO.getLogin(), clientDTO.getPassword()
        );
        CreateClientResult result = commandExecutor.execute(command);
        return result.getClient();
    }

    @GET
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    @Path("/clients/{clientId}")
    public ClientDTO get(@PathParam("clientId") Long clientId) {
        GetClientCommand command = new GetClientCommand(clientId);
        GetClientResult result = commandExecutor.execute(command);
        return result.getClient();
    }

}
