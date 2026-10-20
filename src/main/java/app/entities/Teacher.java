package app.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;
    private String zoom;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @Builder.Default

    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course) {
        if (course != null) {
            this.courses.add(course);
            course.setTeacher(this);
        }
    }

}
