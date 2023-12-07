package br.udesc.SchoolManagerAPI.domain.student;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface StudentRepository extends Neo4jRepository<Student, Long> {

    @Query("MATCH (s:Student)-[:BELONGS_TO]->(c:Neo4jClass)-[:TEACHES]->(sub:Subject) RETURN s.name, c.name, sub.name")
    List<Object[]> getStudentClassSubjectInfo();

    @Query("MATCH (s:Student) WHERE NOT (s)-[:BELONGS_TO]->(:Neo4jClass) RETURN s")
    List<Student> getNotEnrolledStudents();

    @Query("MATCH (:Neo4jClass)-[:BELONGS_TO]->(s:Student) WHERE id(s) = $aClassId RETURN COUNT(s) > 0")
    boolean existsByaClassId(Long aClassId);
}
