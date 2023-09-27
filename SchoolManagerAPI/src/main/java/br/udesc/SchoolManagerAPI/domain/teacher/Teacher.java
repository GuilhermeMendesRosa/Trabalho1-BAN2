package br.udesc.SchoolManagerAPI.domain.teacher;

import br.udesc.SchoolManagerAPI.domain.classes.Class;
import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "teachers")
@Entity(name = "Teacher")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;
    private String name;
    @ManyToMany
    @JoinColumn(name = "subject_id", nullable = false)
    private List<Subject> subjects;
    @OneToOne
    @JoinColumn(name = "managed_class_id", nullable = true)
    private Class managedClass;

    public Teacher(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

}
