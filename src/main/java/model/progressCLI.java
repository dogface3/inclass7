package model;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.OptimisticLockException;

public class progressCLI {

    private final EntityManager em;

    public progressCLI(EntityManager em){
        this.em = em;
    }

    public void updateProgressReport(Long reportId, String newReport) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            ProgressReport report = em.find(ProgressReport.class, reportId);
            if (report == null) {
                System.out.println("Report not found!");
                return;
            }

            report.setNotes(newReport);
            report.setLastReviewed(java.time.LocalDateTime.now());

            em.persist(report);
            tx.commit();

            System.out.println("Progress report updated.");

        } catch (OptimisticLockException e) {
            tx.rollback();
            System.out.println("Conflict detected.");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}
