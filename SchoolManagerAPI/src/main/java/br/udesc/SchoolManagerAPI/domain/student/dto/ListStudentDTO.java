package br.udesc.SchoolManagerAPI.domain.student.dto;

import br.udesc.SchoolManagerAPI.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListStudentDTO {

    private Long id;
    private String name;
    private Long classId;
    private String className;

    public ListStudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();

        if (student.getAClass() != null) {
            this.classId = student.getAClass().getId();
            this.className = student.getAClass().getName();
        }
    }
}
