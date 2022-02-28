package AppointmentService;

import AppointmentService.Appointment;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Before;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
    
    private String longId, longDesc; //id and desriptions that are past character limit
    private String id, desc;
    private Date date, pastDate;

    @SuppressWarnings("deprecation")

    //set test parameters
    @Before
    void setUp() {
        id = "1234567890";
        desc = "The appt shall require a description.";
        date = new Date(3000, Calendar.JANUARY, 1);
        longId = "111222333444555666777888999000";
        longDesc = "This is a sample description that is meant to test for a description that is too long!";
        pastDate = new Date(0);
    }

    @Test
    void testUpdateApptId() {
        Appointment appt = new Appointment();
        assertThrows(IllegalArgumentException.class, () -> appt.updateApptId(null));
        assertThrows(IllegalArgumentException.class, () -> appt.updateApptId(longId));
        appt.updateApptId(id);
        assertEquals(id, appt.getApptId());
    }

    @Test
    void testGetApptId() {
        Appointment appt = new Appointment(id);
        assertNotNull(appt.getApptId());
        assertEquals(appt.getApptId().length(), 10);
        assertEquals(id, appt.getApptId());
    }

    @Test
    void testUpdateDate() {
        Appointment appt = new Appointment();
        assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
        assertThrows(IllegalArgumentException.class, () -> appt.updateDate(pastDate));
        appt.updateDate(date);
        assertEquals(date, appt.getApptDate());
    }

    @Test
  void testGetAppointmentDate() {
    Appointment appt = new Appointment(id, date);
    assertNotNull(appt.getApptDate());
    assertEquals(date, appt.getApptDate());
  }

  @Test
  void testUpdateDesc() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDesc(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDesc(longDesc));
    appt.updateDesc(desc);
    assertEquals(desc, appt.getDesc());
  }

  @Test
  void testGetDescription() {
    Appointment appt = new Appointment(id, date, desc);
    assertNotNull(appt.getDesc());
    assertTrue(appt.getDesc().length() <= 50);
    assertEquals(desc, appt.getDesc());
  }
}
