package br.udesc.SchoolManagerAPI.domain.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ClassRepository extends JpaRepository<Class, Long> {

    @Query(value = "SELECT c.academic_category, COUNT(s.id) AS number_of_students " +
            "FROM classes c " +
            "LEFT JOIN students s ON c.id = s.class_id " +
            "GROUP BY c.academic_category", nativeQuery = true)
    List<Object[]> getClassStudentCountByCategory();

}
