package br.udesc.SchoolManagerAPI.domain.teacher.dto;

import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {

    private Long id;
    private String name;
    private List<Long> subjectIds;

    public TeacherDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.subjectIds = teacher.getSubjects().stream()
                .map(subject -> subject.getId())
                .toList();
    }

}
