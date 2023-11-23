package br.udesc.SchoolManagerAPI.domain.classes;

import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import br.udesc.SchoolManagerAPI.domain.classes.dto.ClassDTO;
import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node("classes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Class extends BaseEntity {

    @Property(name = "name")
    private String name;

    @Property(name = "academicCategory")
    private AcademicCategoryEnum academicCategory;

    @Relationship(type = "MANAGED_BY", direction = Relationship.Direction.OUTGOING)
    private Teacher teacherManager;

    @Relationship(type = "TEACHES", direction = Relationship.Direction.OUTGOING)
    private List<Subject> subjects;

    public Class(ClassDTO classDTO, Teacher teacherManager, List<Subject> subjects) {
        this.name = classDTO.getName();
        this.academicCategory = classDTO.getAcademicCategory();
        this.teacherManager = teacherManager;
        this.subjects = subjects;
    }
}