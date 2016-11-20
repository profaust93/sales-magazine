package lv.javaguru.java3.core.database.clients;

import lv.javaguru.java3.core.database.ClientRepository;

import lv.javaguru.java3.core.domain.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static lv.javaguru.java3.core.domain.ClientBuilder.createClient;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClientRepositoryImplTest  {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Transactional
    public void testCreateClient() {
        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        assertThat(client.getId(), is(nullValue()));
        clientRepository.save(client);
        assertThat(client.getId(), is(notNullValue()));
    }

    @Test
    @Transactional
    public void testGetClientById() {
        Client client = createClient()
                .withLogin("login")
                .withPassword("password").build();
        clientRepository.save(client);
        Client clientFromDb = clientRepository.findOne(client.getId());
        assertThat(clientFromDb, is(notNullValue()));
    }

}