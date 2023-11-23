package br.udesc.SchoolManagerAPI.domain.teacher;

import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.classes.Class;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("teachers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher extends BaseEntity {

    @Property(name="name")
    private String name;

    @Relationship(type = "TEACHES", direction = Relationship.Direction.OUTGOING)
    private List<Subject> subjects;

    @Relationship(type = "MANAGES", direction = Relationship.Direction.OUTGOING)
    private Class managedClass;

    public Teacher(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

}
