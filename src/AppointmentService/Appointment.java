package AppointmentService;

import java.util.Date;

public class Appointment {

    //Initializer will hold a place for now and adopt new input later
    final private String INITIALIZER;
    final private byte APPT_ID_LENGTH; //appointment ID length
    final private byte APPT_DESCRIPTION_LENGTH; // appointment description length
    private String apptId; //appointmnt ID
    private Date apptDate; //appointment date
    private String desc; //description

    //set max length of appointment ID and appointment description
    {
        APPT_ID_LENGTH = 10;
        APPT_DESCRIPTION_LENGTH = 50;
        INITIALIZER = "INITIAL";
    }

    public Appointment() {
        Date todaysDate = new Date();
        apptId = INITIALIZER;
        apptDate = todaysDate;
        desc = INITIALIZER;
    }

    public Appointment(String id) {
        Date todaysDate = new Date();
        updateApptId(id);
        apptDate = todaysDate;
        desc = INITIALIZER;
      }   

      public Appointment(String id, Date date) {
          updateApptId(id);
          updateDate(date);
          desc = INITIALIZER;
      }
 
      public Appointment(String id, Date date, String description) {
        updateApptId(id);
        updateDate(date);
        updateDesc(desc);
      }

      //method to validate the ID input
      public void updateApptId(String id) {
          if (id == null) {
              throw new IllegalArgumentException("Appointment ID cannot be empty.");
          }
          else if (id.length() > APPT_ID_LENGTH){
            throw new IllegalArgumentException("Appointment ID cannot be more than " + APPT_ID_LENGTH + " characters.");
          }

          else {
              this.apptId = id;
          }
      }

      public String getApptId() {
          return apptId;
      }
      
      //method to validate the date input
      public void updateDate(Date date) {
          if(date == null) {
              throw new IllegalArgumentException("Appointment date cannot be empty.");
          }
          else if(date.before(new Date())) {
              throw new IllegalArgumentException("Cannot use past dates.");
          }
          else {
            this.apptDate = date;
          }
        }

          public Date getApptDate() {
              return apptDate;
          }

          //method to validate the description input
          public void updateDesc(String desc) {
              if(desc == null) {
                  throw new IllegalArgumentException("Appointment description cannot be empty.");
              }
              else if(desc.length() > APPT_DESCRIPTION_LENGTH) {
                throw new IllegalArgumentException("Appointment description cannot exceed " + APPT_DESCRIPTION_LENGTH + " characters.");
              }
              else {
                  this.desc = desc;
              }
      }
      public String getDesc() {
          return desc;
      }
}
