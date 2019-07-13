import com.gym.entity.Room;
import com.gym.myException.RoomNotFoundException;
import com.gym.repository.RoomRepository;
import com.gym.service.impl.RoomServiceImpl;
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

public class RoomServiceImplTest {

    private Room room;

    private List<Room> rooms;

    @Mock
    RoomRepository roomRepository;

    @InjectMocks
    RoomServiceImpl roomService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        room = new Room("qwerty");
        rooms = Stream.of(room).collect(Collectors.toList());
    }

    @Test(expected = RoomNotFoundException.class)
    public void findByIdTestException(){ roomService.findById(1);}

    @Test
    public void findAllTest(){
        when(roomRepository.findAll()).thenReturn(rooms);
        assertEquals(rooms, roomService.findAll());
    }

    @Test
    public void findByNameTest(){
        when(roomRepository.findByName("qwerty")).thenReturn(room);
        assertEquals(room, roomService.findByName("qwerty"));
    }

    @Test
    public void findByIdTest(){
        when(roomRepository.findById(1)).thenReturn(Optional.of(room));
        assertEquals(room, roomService.findById(1));
    }

    @Test
    public void deleteByIdTest(){
        when(roomRepository.findById(1)).thenReturn(Optional.of(room));
        roomService.deleteById(1);
        verify(roomRepository, times(1)).deleteById(1);
    }
}
