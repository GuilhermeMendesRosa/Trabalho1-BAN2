package br.udesc.SchoolManagerAPI.domain.subject.dto;

import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {

    private Long id;
    private String name;

    public SubjectDTO(Subject subject) {
        this.id = subject.getId();
        this.name = subject.getName();
    }

}
