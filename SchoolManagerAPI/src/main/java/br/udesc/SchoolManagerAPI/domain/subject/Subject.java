package br.udesc.SchoolManagerAPI.domain.subject;


import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "subjects")
@Entity(name = "Subject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;
}
