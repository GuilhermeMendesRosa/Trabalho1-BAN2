package br.udesc.SchoolManagerAPI.domain.classes;

import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import br.udesc.SchoolManagerAPI.domain.classes.dto.ClassDTO;
import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "classes")
@Entity(name = "Class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Class extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private AcademicCategoryEnum academicCategory;

    @OneToOne
    @JoinColumn(name = "teacher_manager_id", nullable = true)
    private Teacher teacherManager;

    @ManyToMany
    @JoinColumn(name = "subject_id", nullable = false)
    private List<Subject> subjects;

    public Class(ClassDTO classDTO, Teacher teacherManager, List<Subject> subjects) {
        this.name = classDTO.getName();
        this.academicCategory = classDTO.getAcademicCategory();
        this.teacherManager = teacherManager;
        this.subjects = subjects;
    }

}
