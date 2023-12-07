package br.udesc.SchoolManagerAPI.domain.subject;


import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("subjects")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject extends BaseEntity {

    @Property(name = "name")
    private String name;
}
