import com.gym.convertors.ClientConvert;
import com.gym.dto.ClientDto;
import com.gym.entity.Client;
import com.gym.entity.Office;
import com.gym.repository.ClientRepository;
import com.gym.service.impl.ClientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;
import org.mockito.Spy;


import static org.mockito.Mockito.*;

public class ClientServiceImplTest {

    private Client client;
    
    private Client client1;
    
    private Client client2;

    private ClientDto clientDto;

    List<Client> clients;

    List<ClientDto> clientDtos;

    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    ClientServiceImpl clientService;

    @Spy
    ClientConvert clientConvert;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        client = new Client(new Office(),"qwerty","qwerty","qwerty","qwerty","qwerty");
        client1 = new Client(new Office(),"qwerty","qwert","qwert","qwert","qwert");
        client2 = new Client(new Office(),"qwerty","qwer","qwer","qwer","qwer");
        clientDto = new ClientDto("qwerty","qwerty","qwerty","qwerty","qwerty", 1);
        clients = Stream.of(client, client1, client2)
                .collect(Collectors.toList());
        clientDtos = clients.stream()
                .map(clientConvert::convert)
                .collect(Collectors.toList());


    }

    @Test
    public void findByIdTest(){
        when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        assertEquals(clientConvert.convert(client), clientService.findById(1));
    }

    @Test
    public void findAllTest(){
        when(clientRepository.findAll()).thenReturn(clients);
        assertEquals(clientDtos , clientService.findAll());
    }

    @Test
    public void findByNameTest(){
        when(clientRepository.findByName("qwerty")).thenReturn(clients);
        assertEquals(clientDtos, clientService.findByName("qwerty"));
    }

    @Test
    public void findByLoginTest(){
        when(clientRepository.findByLogin("qwerty")).thenReturn(client);
        assertEquals(clientConvert.convert(client
        ),clientService.findByLogin("qwerty"));
    }

    @Test
    public void deleteByIdTest(){
        when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        clientService.deleteById(1);
        verify(clientRepository, times(1)).deleteById(1);
    }



}
