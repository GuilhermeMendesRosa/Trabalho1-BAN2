package br.udesc.SchoolManagerAPI.domain.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentDTO {

    private Long id;
    private String name;
    private Long classId;

}
