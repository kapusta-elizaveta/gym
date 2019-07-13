import com.gym.convertors.ClientConvert;
import com.gym.dto.ClientDto;
import com.gym.entity.Client;
import com.gym.entity.Office;
import com.gym.myException.ClientNotFoundException;
import com.gym.repository.ClientRepository;
import com.gym.service.impl.ClientServiceImpl;
import com.gym.service.impl.OfficeServiceImpl;
import com.gym.validate.Validate;
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

    @Mock
    OfficeServiceImpl officeService;

    @Spy
    ClientConvert clientConvert;

    @Spy
    Validate validate;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        client = new Client(new Office(),"qwerty","qwerty","qwerty","qwerty","+375295642354");
        client1 = new Client(new Office(),"qwerty","qwert","qwert","qwert","+375295642354");
        client2 = new Client(new Office(),"qwerty","qwer","qwer","qwer","+375295642354");
        clientDto = new ClientDto("qwerty","qwerty","qwerty","qwerty","+375295642354", 1);
        clients = Stream.of(client, client1, client2)
                .collect(Collectors.toList());
        clientDtos = clients.stream()
                .map(clientConvert::convert)
                .collect(Collectors.toList());


    }

    @Test(expected = ClientNotFoundException.class)
    public void findByIdTestException(){ clientService.findById(1); }

    @Test
    public void saveTest(){
        when(officeService.findById(1)).thenReturn(new Office());
        when(clientRepository.save(client)).thenReturn(client);
        assertEquals(client, clientService.save(clientDto));
     }


    @Test
    public void findAllTest(){
        when(clientRepository.findAll()).thenReturn(clients);
        assertEquals(clients , clientService.findAll());
    }

    @Test
    public void findByNameTest(){
        when(clientRepository.findByName("qwerty")).thenReturn(clients);
        assertEquals(clients, clientService.findByName("qwerty"));
    }

    @Test
    public void findByLoginTest(){
        when(clientRepository.findByLogin("qwerty")).thenReturn(client);
        assertEquals(client,clientService.findByLogin("qwerty"));
    }

    @Test
    public void deleteByIdTest(){
        when(clientRepository.findById(1)).thenReturn(Optional.of(client));
        clientService.deleteById(1);
        verify(clientRepository, times(1)).deleteById(1);
    }



}
