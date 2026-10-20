package app;

import app.config.HibernateConfig;
import app.entities.Course;
import app.entities.CourseName;
import app.entities.Student;
import app.entities.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        try (EntityManager em = emf.createEntityManager()) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime twoHoursLater = now.plusHours(2);
            Course c1 = Course.builder().courseName(CourseName.MATH).description("Multiplikation").startDate(now).endDate(twoHoursLater).build();

            Teacher t1 = Teacher.builder().name("Emil").email("EmilStabil@gmail.com").zoom("https/zoom.com/emilStabil/join").build();

            Student s1 = Student.builder().name("Nicolai").email("Nicolainoah@gmail.com").createdAt(LocalDateTime.of(2025,06,24,15,22)).updatedAt(LocalDateTime.now()).build();

            t1.addCourse(c1);
            s1.addCourse(c1);




            em.getTransaction().begin();

            em.getTransaction().commit();


        }
        emf.close();
    }
}
