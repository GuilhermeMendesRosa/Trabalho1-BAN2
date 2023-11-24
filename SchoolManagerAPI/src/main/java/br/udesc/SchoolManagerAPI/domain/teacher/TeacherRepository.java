package br.udesc.SchoolManagerAPI.domain.teacher;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends Neo4jRepository<Teacher, Long> {

    @Query("MATCH (t:teachers) WHERE NOT (t)-[:MANAGES]->(:classes) RETURN t")
    List<Teacher> findNoManagingTeachers();

    @Query("MATCH (t:Teacher)-[:MANAGES]->(c:Neo4jClass) RETURN t.name AS teacher_name, c.name AS class_name")
    List<Object[]> getTeacherClassInfo();

    @Query("""
            MATCH (teacher:teachers)-[:TEACHES]->(subject:subjects)
            OPTIONAL MATCH (teacher)-[:MANAGES]->(managedClass:classes)
            RETURN teacher, COLLECT(subject) AS subjects, COLLECT(managedClass) AS managedClasses
            """)
    @Override
    List<Teacher> findAll();

    @Query("""
            MERGE (teacher:teachers {name: $name})
            ON CREATE SET teacher.createdAt = timestamp(), teacher.updatedAt = timestamp()
            WITH teacher
            UNWIND $subjectIds as subjectId
            MATCH (subject:subjects) WHERE ID(subject) = subjectId
            MERGE (teacher)-[:TEACHES]->(subject)
            RETURN teacher
            """)
    Teacher createTeacher(@Param("name") String name, @Param("subjectIds") List<Long> subjectIds);

    @Query("""
    MATCH (teacher:teachers)-[:TEACHES]->(subject:subjects)
    OPTIONAL MATCH (teacher)-[:MANAGES]->(managedClass:classes)
    WHERE ID(teacher) = $id
    RETURN teacher, subject, managedClass
    LIMIT 1
""")
    @Override
    Optional<Teacher> findById(@Param("id") Long id);
}
