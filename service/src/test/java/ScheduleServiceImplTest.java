import com.gym.entity.Office;
import com.gym.entity.Room;
import com.gym.entity.Schedule;
import com.gym.myException.ScheduleNotFoundException;
import com.gym.repository.ScheduleRepository;
import com.gym.service.impl.OfficeServiceImpl;
import com.gym.service.impl.RoomServiceImpl;
import com.gym.service.impl.ScheduleServiceImpl;
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

public class ScheduleServiceImplTest {

    private Schedule schedule;

    private List<Schedule> schedules;

    @Mock
    ScheduleRepository scheduleRepository;

    @Mock
    OfficeServiceImpl officeService;

    @Mock
    RoomServiceImpl roomService;

    @InjectMocks
    ScheduleServiceImpl scheduleService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        schedule = new Schedule(new Office(), new Room(), "10/12/2019", "12/12/2019");
        schedules = Stream.of(schedule).collect(Collectors.toList());
    }

    @Test(expected = ScheduleNotFoundException.class)
    public void findByIdTestException(){ scheduleService.findById(1);}

    @Test
    public void findByIdTest(){
        when(scheduleRepository.findById(1)).thenReturn(Optional.of(schedule));
        assertEquals(schedule, scheduleService.findById(1));
    }

    @Test
    public void findAll(){
        when(scheduleRepository.findAll()).thenReturn(schedules);
        assertEquals(schedules, scheduleService.findAll());
    }

    @Test
    public void findByOfficeIdTest(){
        when(officeService.findById(1)).thenReturn(new Office());
        when(scheduleRepository.findByOfficeId(1)).thenReturn(schedules);
        assertEquals(schedules, scheduleService.findByOfficeId(1));
    }

    @Test
    public void findByRoomIdTest(){
        when(roomService.findById(1)).thenReturn(new Room());
        when(scheduleRepository.findByRoomId(1)).thenReturn(schedules);
        assertEquals(schedules, scheduleService.findByRoomId(1));
    }

    @Test
    public void deleteByIdTest(){
        when(scheduleRepository.findById(1)).thenReturn(Optional.of(schedule));
        scheduleService.deleteById(1);
        verify(scheduleRepository, times(1)).deleteById(1);
    }
}
