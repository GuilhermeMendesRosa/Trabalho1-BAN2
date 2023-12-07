package br.udesc.SchoolManagerAPI.domain.subjectRelation;

import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import br.udesc.SchoolManagerAPI.domain.classes.Class;
import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("subject_relations")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubjectRelation extends BaseEntity {

    @Relationship(type = "BELONGS_TO_CLASS", direction = Relationship.Direction.OUTGOING)
    private Class aClass;

    @Relationship(type = "TEACHES_SUBJECT", direction = Relationship.Direction.OUTGOING)
    private Teacher teacher;

    @Relationship(type = "RELATED_TO_SUBJECT", direction = Relationship.Direction.OUTGOING)
    private Subject subject;

}
