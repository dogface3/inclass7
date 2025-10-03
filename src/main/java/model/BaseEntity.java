package model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @Column(updatable = false)
    private LocalDateTime lastUpdated;
    private LocalDateTime created;

    @PreUpdate
    protected void onUpdate() {
        LocalDateTime now = LocalDateTime.now();
        lastUpdated = now;
    }

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        created = now;
        lastUpdated = now;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
