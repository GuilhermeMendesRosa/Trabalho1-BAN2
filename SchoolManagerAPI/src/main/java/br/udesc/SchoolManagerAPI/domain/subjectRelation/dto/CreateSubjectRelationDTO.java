package br.udesc.SchoolManagerAPI.domain.subjectRelation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubjectRelationDTO {

    private Long classId;
    private List<SubjectTeacherRelationDTO> subjectTeacherRelationList;

}
