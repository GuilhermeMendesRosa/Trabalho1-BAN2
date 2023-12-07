package br.udesc.SchoolManagerAPI.domain.student;

import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import lombok.*;
import br.udesc.SchoolManagerAPI.domain.classes.Class;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node("students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends BaseEntity {

    @Property(name = "name")
    private String name;

    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.OUTGOING)
    private Class aClass;

}
