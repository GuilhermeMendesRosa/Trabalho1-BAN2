package br.udesc.SchoolManagerAPI.domain.subject;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "subjects")
@Entity(name = "Subject")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;
    private String name;
}
