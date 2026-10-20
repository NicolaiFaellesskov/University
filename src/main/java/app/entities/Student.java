package app.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime createdAt;
    private String email;
    private String name;
    LocalDateTime updatedAt;

    @ManyToOne
    private Course course;

    public void addCourse(Course course) {

        this.course = course;
        if (course != null) {
            course.getStudents().add(this);
        }
    }
}
