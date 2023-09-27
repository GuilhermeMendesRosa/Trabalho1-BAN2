package br.udesc.SchoolManagerAPI.domain.student;

import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import br.udesc.SchoolManagerAPI.domain.classes.Class;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "students")
@Entity(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends BaseEntity {

    private String name;
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = true)
    private Class aClass;

}
