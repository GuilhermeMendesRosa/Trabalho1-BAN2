package br.udesc.SchoolManagerAPI.domain.student;

import br.udesc.SchoolManagerAPI.domain.classes.Class;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "students")
@Entity(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = true)
    private Class aClass;

}
