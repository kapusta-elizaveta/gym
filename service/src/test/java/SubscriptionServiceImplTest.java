import com.gym.entity.Subscription;
import com.gym.repository.SubscriptionRepository;
import com.gym.service.impl.SubscriptionServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static junit.framework.TestCase.assertEquals;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;
import static org.mockito.Mockito.*;

public class SubscriptionServiceImplTest {

    Subscription subscription;

    @Mock
    SubscriptionRepository subscriptionRepository;

    @InjectMocks
    SubscriptionServiceImpl subscriptionService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        subscription = new Subscription(123,12);
    }

    @Test
    public void findAllTest(){
        when(subscriptionRepository.findAll()).thenReturn(Stream.of(subscription)
                .collect(Collectors.toList()));
        assertEquals(Stream.of(subscription).collect(Collectors.toList()), subscriptionService.findAll());

    }

    @Test
    public void findByIdTest(){
        when(subscriptionRepository.findById(1)).thenReturn(Optional.of(subscription));
        assertEquals(subscription, subscriptionService.findById(1));
    }

    @Test
    public void findCheaperSubscriptionTest(){
        when(subscriptionRepository.findCheaperSubscription(140)).thenReturn(Stream.of(subscription)
                .collect(Collectors.toList()));
        assertEquals(Stream.of(subscription).collect(Collectors.toList()), subscriptionService.findCheaperSubscription(140));
    }
}
