package br.udesc.SchoolManagerAPI.domain.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.managedClass = null")
    List<Teacher> findNoManagingTeachers();

    @Query(value = "SELECT t.name AS teacher_name, c.name AS class_name " +
            "FROM teachers t " +
            "LEFT JOIN classes c ON t.managed_class_id = c.id", nativeQuery = true)
    List<Object[]> getTeacherClassInfo();

}
