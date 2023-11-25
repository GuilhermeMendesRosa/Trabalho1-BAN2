package br.udesc.SchoolManagerAPI.domain.teacher;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends Neo4jRepository<Teacher, Long> {

    @Query("MATCH (t:teachers) WHERE NOT (t)-[:MANAGES]->(:classes) RETURN t")
    List<Teacher> findNoManagingTeachers();

    @Query("MATCH (t:teachers)-[:MANAGES]->(c:classes) RETURN t.name AS teacherName, c.name AS className")
    List<TeacherClassReportVO> getTeacherClassInfo();

    @Query("""
            MATCH (teacher:teachers)-[t:TEACHES]->(subject:subjects)
            OPTIONAL MATCH (teacher)-[m:MANAGES]->(managedClass:classes)
            RETURN teacher, t, subject AS subjects, m, managedClass
            """)
    @Override
    List<Teacher> findAll();

    @Query("""
            MERGE (teacher:teachers {name: $name})
            ON CREATE SET teacher.createdAt = timestamp(), teacher.updatedAt = timestamp()
            WITH teacher
            UNWIND $subjectIds as subjectId
            MATCH (subject:subjects) WHERE ID(subject) = subjectId
            MERGE (teacher)-[t:TEACHES]->(subject)
            RETURN teacher, t, subject AS subjects
            """)
    Teacher createTeacher(@Param("name") String name, @Param("subjectIds") List<Long> subjectIds);

    @Query("""
        MATCH (teacher:teachers)-[t:TEACHES]->(subject:subjects)
        WHERE ID(teacher) = $id
        OPTIONAL MATCH (teacher)-[m:MANAGES]->(managedClass:classes)
        RETURN teacher, t, subject AS subjects, m, managedClass
        LIMIT 1
       """)
    @Override
    Optional<Teacher> findById(@Param("id") Long id);

    @Query("MATCH (t:teachers) WHERE id(t) = $id DETACH DELETE t")
    void delete(@Param("id") Long id);

    @Query("""
        MATCH (t:teachers)-[:MANAGES]->(c:classes)
        WHERE id(t) = $teacherId
        SET t.managedClass = $newManagedClassId
    """)
    void setManagedClass(@Param("teacherId") Long teacherId, @Param("newManagedClassId") Long newManagedClassId);
}
