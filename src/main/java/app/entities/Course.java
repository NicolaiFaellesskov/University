    package app.entities;

    import jakarta.persistence.*;
    import lombok.*;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;


    import java.time.LocalDateTime;
    import java.util.HashSet;
    import java.util.Set;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @Entity

    public class Course{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Enumerated(EnumType.STRING)
        private CourseName courseName;
        private String description;
        private LocalDateTime endDate;
        private LocalDateTime startDate;

        @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
        @Builder.Default
        private Set<Student> students = new HashSet<>();

        @ManyToOne
        private Teacher teacher;

    }
