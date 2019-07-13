import com.gym.entity.Subscription;
import com.gym.myException.SubscriptionNotFoundException;
import com.gym.repository.SubscriptionRepository;
import com.gym.service.impl.SubscriptionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static junit.framework.TestCase.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;
import static org.mockito.Mockito.*;

public class SubscriptionServiceImplTest {

    private Subscription subscription;

    private List<Subscription> subscriptions;

    @Mock
    SubscriptionRepository subscriptionRepository;

    @InjectMocks
    SubscriptionServiceImpl subscriptionService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        subscription = new Subscription(123,12);
        subscriptions = Stream.of(subscription).collect(Collectors.toList());

    }

    @Test(expected = SubscriptionNotFoundException.class)
    public void findByIdTestException(){ subscriptionService.findById(1);}

    @Test(expected = IllegalArgumentException.class)
    public void findCheaperSubscriptionTestException(){ subscriptionService.findCheaperSubscription(-120);}

    @Test
    public void findAllTest(){
        when(subscriptionRepository.findAll()).thenReturn(subscriptions);
        assertEquals(subscriptions, subscriptionService.findAll());

    }

    @Test
    public void findByIdTest(){
        when(subscriptionRepository.findById(1)).thenReturn(Optional.of(subscription));
        assertEquals(subscription, subscriptionService.findById(1));
    }

    @Test
    public void findCheaperSubscriptionTest(){
        when(subscriptionRepository.findCheaperSubscription(140)).thenReturn(subscriptions);
        assertEquals(subscriptions, subscriptionService.findCheaperSubscription(140));
    }

    @Test
    public void deleteByIdTest(){
        when(subscriptionRepository.findById(1)).thenReturn(Optional.of(subscription));
        subscriptionService.deleteById(1);
        verify(subscriptionRepository, times(1)).deleteById(1);
    }
}
