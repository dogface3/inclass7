package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "progress report")
public class ProgressReport extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String report;
    private LocalDate lastUpdate;


    @Version
    private long version;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public ProgressReport(String report, Student student){
        this.report = report;
        this.student = student;
        this.lastUpdate = LocalDate.now();
    }

    public Long getId() { return id; }
    public String getNotes() { return report; }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public Long getVersion() { return version; }
    public Student getStudent() { return student; }

    public void setNotes(String notes) { this.report = notes; }
    public void setLastReviewed(LocalDateTime lastReviewed) { this.lastUpdate = lastUpdate; }


}
