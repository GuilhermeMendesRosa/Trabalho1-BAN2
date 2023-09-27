export interface Class {
  id: number;
  name?: string;
  academicCategory: string;
  teacherManagerId?: number;
  teacherManagerName?: string;
  subjectIds?: number[]
}
