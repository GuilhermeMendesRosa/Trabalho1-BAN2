package br.udesc.SchoolManagerAPI.domain.classes.dto;

import br.udesc.SchoolManagerAPI.domain.classes.Class;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListClassDTO {

    private Long id;
    private String name;
    private String academicCategory;
    private String teacherManagerName;

    public ListClassDTO(Class aClass) {
        this.id = aClass.getId();
        this.name = aClass.getName();
        this.academicCategory = aClass.getAcademicCategory().toString();
        this.teacherManagerName = aClass.getTeacherManager().getName();
    }

}
