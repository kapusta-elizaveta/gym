import com.gym.dto.CoachDto;
import com.gym.entity.Coach;
import com.gym.myException.CoachNotFoundException;
import com.gym.repository.CoachRepository;
import com.gym.service.impl.CoachServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

public class CoachServiceImplTest {

    private Coach coach;

    private List<Coach> coaches;

    private CoachDto coachDto;

    @Mock
    CoachRepository coachRepository;

    @InjectMocks
    CoachServiceImpl coachService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        coach = new Coach("qwerty","qwerty", "+375296541232");
        coaches = Stream.of(coach).collect(Collectors.toList());
        coachDto = new CoachDto("qwerty","qwerty", "+375296541232");
    }

    @Test(expected = CoachNotFoundException.class)
    public void findByIdTestException(){ coachService.findById(10);}

    @Test
    public void saveTest(){
        when(coachRepository.save(coach)).thenReturn(coach);
        assertEquals(coach, coachService.save(coachDto));
    }

    @Test
    public void findAllTest(){
        when(coachRepository.findAll()).thenReturn(coaches);
        assertEquals(coaches, coachService.findAll() );
    }

    @Test
    public void findByNameTest(){
        when(coachRepository.findByName("qwerty")).thenReturn(coaches);
        assertEquals(coaches, coachService.findByName("qwerty"));
    }

    @Test
    public void findByIdTest(){
        when(coachRepository.findById(1)).thenReturn(Optional.of(coach));
        assertEquals(coach, coachService.findById(1));
    }

    @Test
    public void deleteByIdTest(){
        when(coachRepository.findById(1)).thenReturn(Optional.of(coach));
        coachService.deleteById(1);
        verify(coachRepository, times(1)).deleteById(1);
    }
}
