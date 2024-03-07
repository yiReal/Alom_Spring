package hello.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TodoList {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Code;
    private String Email;
    private String Informaiton;
    private String Done;
    private String StartTime;
    private String EndTime;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getInformaiton() {
        return Informaiton;
    }

    public void setInformaiton(String informaiton) {
        Informaiton = informaiton;
    }

    public String getDone() {
        return Done;
    }

    public void setDone(String done) {
        Done = done;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }


    public Long getCode() {
        return Code;
    }

    public void setCode(Long code) {
        Code = code;
    }
}
