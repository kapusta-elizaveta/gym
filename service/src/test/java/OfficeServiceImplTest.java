import com.gym.entity.Coach;
import com.gym.entity.Office;
import com.gym.entity.Room;
import com.gym.myException.CoachNotFoundException;
import com.gym.myException.OfficeNotFoundException;
import com.gym.repository.OfficeRepository;
import com.gym.service.OfficeService;
import com.gym.service.impl.CoachServiceImpl;
import com.gym.service.impl.OfficeServiceImpl;
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

public class OfficeServiceImplTest {

    private Office office;

    private List<Office> offices;

    @Mock
    OfficeRepository officeRepository;

    @Mock
    CoachServiceImpl coachService;

    @InjectMocks
    OfficeServiceImpl officeService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        office = new Office(new Room(),new Coach(),"qwerty");
        offices = Stream.of(office).collect(Collectors.toList());
    }

    @Test(expected = OfficeNotFoundException.class)
    public void findByIdTestException(){ officeService.findById(1);}


    @Test
    public void findAllTest(){
        when(officeRepository.findAll()).thenReturn(offices);
        assertEquals(offices, officeService.findAll());
    }

    @Test
    public void findByIdTest(){
        when(officeRepository.findById(1)).thenReturn(Optional.of(office));
        assertEquals(office, officeService.findById(1));
    }

    @Test
    public void findByName(){
        when(officeRepository.findByName("qwerty")).thenReturn(offices);
        assertEquals(offices, officeService.findByName("qwerty"));
    }

    @Test
    public void findByCoachId(){
        when(coachService.findById(1)).thenReturn(new Coach());
        when(officeRepository.findByCoachId(1)).thenReturn(offices);
        assertEquals(offices, officeService.findByCoachId(1));

    }

    @Test
    public void deleteByIdTest(){
        when(officeRepository.findById(1)).thenReturn(Optional.of(office));
        officeService.deleteById(1);
        verify(officeRepository, times(1)).deleteById(1);
    }


}
