package br.udesc.SchoolManagerAPI.domain.subjectRelation;

import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import br.udesc.SchoolManagerAPI.domain.classes.Class;
import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "subject_relations")
@Entity(name = "SubjectRelation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectRelation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "class_id")
    Class aClass;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;

}
