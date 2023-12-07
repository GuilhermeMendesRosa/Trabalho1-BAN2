import {Subject} from "./subject";
import {SubjectTeacherRelationDTO} from "./SubjectTeacherRelationDTO";

export interface CreateSubjectRelationDTO {
  classId?: number;
  subjectTeacherRelationList?: SubjectTeacherRelationDTO[];
}
