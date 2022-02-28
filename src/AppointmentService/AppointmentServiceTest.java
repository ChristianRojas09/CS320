package AppointmentService;

import AppointmentService.AppointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Before;

import java.util.Calendar;
import java.util.Date;

public class AppointmentServiceTest {

    private String id, desc, longDesc;
    private Date date, pastDate;

    @SuppressWarnings("deprecation")
    @Before

    //set test parameters
    void setUp() {
        id = "1234567890";
        desc = "The appt shall require a description.";
        date = new Date(3000, Calendar.JANUARY, 1);
        longDesc = "This is a sample description that is meant to test for a description that is too long!";
        pastDate = new Date(0);
    }
    
    @Test
    void testNewAppt() {
        AppointmentService service = new AppointmentService();

        service.newAppt();
        assertNotNull(service.getApptList().get(0).getDesc());
        assertNotNull(service.getApptList().get(0).getApptId());
        assertNotNull(service.getApptList().get(0).getApptDate());

        service.newAppt(date);
        assertNotNull(service.getApptList().get(1).getApptId());
        assertNotNull(date, service.getApptList().get(1).getApptDate());
        assertNotNull(service.getApptList().get(1).getDesc());

        service.newAppt(date, desc);
        assertNotNull(service.getApptList().get(2).getApptId());
        assertEquals(date, service.getApptList().get(2).getApptDate());
        assertEquals(desc, service.getApptList().get(2).getDesc());

        assertNotEquals(service.getApptList().get(0).getApptId(), service.getApptList().get(1).getApptId());
        assertNotEquals(service.getApptList().get(0).getApptId(), service.getApptList().get(2).getApptId());
        assertNotEquals(service.getApptList().get(1).getApptId(), service.getApptList().get(2).getApptId());

        assertThrows(IllegalArgumentException.class, () -> service.newAppt(pastDate));
        assertThrows(IllegalArgumentException.class, () -> service.newAppt(date, longDesc));
    }

    @Test
    void deleteAppt() throws Exception {
        AppointmentService service = new AppointmentService();

        service.newAppt();
        service.newAppt();
        service.newAppt();

        String firstId = service.getApptList().get(0).getApptId();
        String secondId = service.getApptList().get(1).getApptId();
        String thirdId = service.getApptList().get(2).getApptId();

        assertNotEquals(id, firstId);
        assertNotEquals(id, secondId);
        assertNotEquals(id, thirdId);
        assertNotEquals(firstId, secondId);
        assertNotEquals(firstId, thirdId);
        assertNotEquals(secondId, thirdId);

        assertThrows(Exception.class, () -> service.deleteAppt(id));

        service.deleteAppt(firstId);
        assertThrows(Exception.class, () -> service.deleteAppt(firstId));
        assertNotEquals(firstId, service.getApptList().get(0).getApptId());
    }
}
