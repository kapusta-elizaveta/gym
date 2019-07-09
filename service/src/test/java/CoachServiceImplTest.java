import com.gym.entity.Coach;
import com.gym.repository.CoachRepository;
import com.gym.service.impl.CoachServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

public class CoachServiceImplTest {

    private Coach coach;

    @Mock
    CoachRepository coachRepository;

    @InjectMocks
    CoachServiceImpl coachService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        coach = new Coach("qwerty","qwert","2344i876543");
    }

    @Test
    public void findAllTest(){
        when(coachRepository.findAll()).thenReturn(Stream.of(coach)
                .collect(Collectors.toList()));
        assertEquals(Stream.of(coach).collect(Collectors.toList()), coachService.findAll() );
    }

    @Test
    public void findByNameTest(){
        when(coachRepository.findByName("qwerty")).thenReturn(Stream.of(coach)
                .collect(Collectors.toList()));
        assertEquals(Stream.of(coach).collect(Collectors.toList()), coachService.findByName("qwerty"));
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
