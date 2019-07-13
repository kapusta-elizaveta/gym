import com.gym.entity.Client;
import com.gym.entity.SaleSubscription;
import com.gym.entity.Subscription;
import com.gym.myException.SaleSubscriptionNotFoundException;
import com.gym.repository.SaleSubscriptionRepository;
import com.gym.service.SaleSubscriptionService;
import com.gym.service.impl.ClientServiceImpl;
import com.gym.service.impl.SaleSubscriptionSaleImpl;
import com.gym.service.impl.SubscriptionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SaleSubscriptionServiceImplTest {

    private SaleSubscription saleSubscription;

    List<SaleSubscription> saleSubscriptions;

    @Mock
    SaleSubscriptionRepository saleSubscriptionRepository;

    @Mock
    ClientServiceImpl clientService;

    @Mock
    SubscriptionServiceImpl subscriptionService;

    @InjectMocks
    SaleSubscriptionSaleImpl saleSubscriptionSale;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        saleSubscription = new SaleSubscription(new Client(), new Subscription(),"12/12/2019",
                "10/12/2019");
        saleSubscriptions = Stream.of(saleSubscription).collect(Collectors.toList());
    }

    @Test(expected = SaleSubscriptionNotFoundException.class)
    public void findByIdTestException(){ saleSubscriptionSale.findById(1);}

    @Test
    public void findByIdTest(){
        when(saleSubscriptionRepository.findById(1)).thenReturn(Optional.of(saleSubscription));
        assertEquals(saleSubscription, saleSubscriptionSale.findById(1));
    }

    @Test
    public void findByClientIdTest(){
        when(clientService.findById(1)).thenReturn(new Client());
        when(saleSubscriptionRepository.findByClientId(1)).thenReturn(saleSubscriptions);
        assertEquals(saleSubscriptions, saleSubscriptionSale.findByClientId(1));
    }

    @Test
    public void findBySubscriptionId(){
        when(subscriptionService.findById(1)).thenReturn(new Subscription());
        when(saleSubscriptionRepository.findBySubscriptionId(1)).thenReturn(saleSubscriptions);
        assertEquals(saleSubscriptions, saleSubscriptionSale.findBySubscriptionId(1));
    }

    @Test
    public void deleteById(){
        when(saleSubscriptionRepository.findById(1)).thenReturn(Optional.of(saleSubscription));
        saleSubscriptionSale.deleteById(1);
        verify(saleSubscriptionRepository, times(1)).deleteById(1);
    }


}
