package br.udesc.SchoolManagerAPI.domain.teacher;

import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import br.udesc.SchoolManagerAPI.domain.classes.Class;
import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "teachers")
@Entity(name = "Teacher")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinColumn(name = "subject_id", nullable = false)
    private List<Subject> subjects;

    @OneToOne
    @JoinColumn(name = "managed_class_id")
    private Class managedClass;

    public Teacher(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

}
