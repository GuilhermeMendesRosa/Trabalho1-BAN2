package br.udesc.SchoolManagerAPI.domain.classes.dto;

import br.udesc.SchoolManagerAPI.domain.classes.AcademicCategoryEnum;
import br.udesc.SchoolManagerAPI.domain.classes.Class;
import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassDTO {

    private Long id;
    private String name;
    private AcademicCategoryEnum academicCategory;
    private Long teacherManagerId;
    private String teacherManagerName;
    private List<Long> subjectIds;

    public ClassDTO(Class aClass) {
        this.id = aClass.getId();
        this.name = aClass.getName();
        this.academicCategory = aClass.getAcademicCategory();
        this.subjectIds = aClass.getSubjects().stream()
                .map(subject -> subject.getId())
                .toList();

        Teacher teacherManager = aClass.getTeacherManager();
        if (teacherManager != null) {
            this.teacherManagerId = teacherManager.getId();
            this.teacherManagerName = teacherManager.getName();
        }
    }

}
