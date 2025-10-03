package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    @Convert(converter = rankConverter.class)
    private aikidoRank rank;
    private LocalDate joinDate;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Transient
    private int membershipDuration;

    @ManyToMany
    @JoinTable(
            name = "training_session_students", // This is the join table
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "training_session_id")
    )
    private List<TrainingSession> trainingSessions;

    public Student() {}

    public Student(String name, String email, String  rank, LocalDate joinDate) {
        this.name = name;
        this.email = email;
        this.rank = aikidoRank.valueOf(rank);
        this.joinDate = joinDate;
    }


    @PostLoad
    protected void calculateMembershipDuration() {
        this.membershipDuration = LocalDate.now().getYear() - joinDate.getYear();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public aikidoRank getRank() { return rank; }
    public LocalDate getJoinDate() { return joinDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public int getMembershipDuration() { return membershipDuration; }
    public List<TrainingSession> getTrainingSessions() { return trainingSessions; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setRank(String rank) { this.rank = aikidoRank.valueOf(rank); }
    public void setJoinDate(LocalDate joinDate) { this.joinDate = joinDate; }
    public void setTrainingSessions(List<TrainingSession> trainingSessions) { this.trainingSessions = trainingSessions; }
}
