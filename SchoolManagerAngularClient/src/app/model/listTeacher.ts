import {Subject} from "./subject";

export interface ListTeacher {
  id: number;
  name?: string;
  subjectName?: string;
  className?: string;
  subjects?: Subject[];
}
