package br.udesc.SchoolManagerAPI.domain.teacher;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends Neo4jRepository<Teacher, Long> {

    @Query("MATCH (t:Teacher) WHERE NOT (t)-[:MANAGES]->(:Neo4jClass) RETURN t")
    List<Teacher> findNoManagingTeachers();

    @Query("MATCH (t:Teacher)-[:MANAGES]->(c:Neo4jClass) RETURN t.name AS teacher_name, c.name AS class_name")
    List<Object[]> getTeacherClassInfo();

    @Query("MERGE (teacher:teachers {name: $name}) " +
            "ON CREATE SET teacher.createdAt = timestamp(), teacher.updatedAt = timestamp() " +
            "WITH teacher " +
            "UNWIND $subjectIds as subjectId " +
            "MATCH (subject:subjects) WHERE ID(subject) = subjectId " +
            "MERGE (teacher)-[:TEACHES]->(subject) " +
            "RETURN teacher")
    Teacher createTeacher(@Param("name") String name, @Param("subjectIds") List<Long> subjectIds);

}
