package br.udesc.SchoolManagerAPI.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

        @Query(value = "SELECT s.name, c.name, sub.name " +
                        "FROM students s " +
                        "LEFT JOIN classes c ON c.id = s.class_id " +
                        "LEFT JOIN classes_subjects cs ON cs.class_id = c.id " +
                        "LEFT JOIN subjects sub ON cs.subjects_id = sub.id; ", nativeQuery = true)
        List<Object[]> getStudentClassSubjectInfo();

        @Query("SELECT s FROM Student s WHERE s.aClass IS NULL")
        List<Student> getNotEnrolledStudents();

        Boolean existsByAClassId(Long aClassId);
}
