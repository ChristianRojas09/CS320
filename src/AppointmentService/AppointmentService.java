package AppointmentService;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.List;

public class AppointmentService {
    final private List<Appointment> apptList = new ArrayList<>();

    private String uniqueId() {
        return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
    }

    //create a new appointment
    public void newAppt() {
        Appointment appt = new Appointment(uniqueId());
        apptList.add(appt);
    }

    public void newAppt(Date date) {
        Appointment appt = new Appointment(uniqueId(), date);
        apptList.add(appt);
    }

    public void newAppt(Date date, String desc) {
        Appointment appt = new Appointment(uniqueId(), date, desc);
        apptList.add(appt);
      }

      //delete existing appointment
      public void deleteAppt(String id) throws Exception {
          apptList.remove(findAppt(id));
      }

      public List<Appointment> getApptList() {
          return apptList;
      }

      //method for searching appointment list to find an appointment
      private Appointment findAppt(String id) throws Exception {
          int index = 0;
          while(index < apptList.size()) {
              if(id.equals(apptList.get(index).getApptId())) {
                  return apptList.get(index);
              }
              index++;
          }
          throw new Exception("Appointment does not exist."); //return if appointment is not in the list
      }
}
