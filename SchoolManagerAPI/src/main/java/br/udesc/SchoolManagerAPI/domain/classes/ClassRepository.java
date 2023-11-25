package br.udesc.SchoolManagerAPI.domain.classes;

import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Map;

public interface ClassRepository extends Neo4jRepository<Class, Long> {

    @Query("""
            MATCH (c:Neo4jClass)-[:BELONGS_TO]->(s:Student)
            RETURN c.academicCategory AS academic_category, COUNT(s) AS number_of_students
            ORDER BY c.academicCategory
    """)
    List<Object[]> getClassStudentCountByCategory();

    @Query("""
            MATCH (c:classes)-[r:MANAGED_BY]->(oldTeacher:teachers)
            WHERE ID(c) = $classId
            SET r.teacherManager = null
            WITH oldTeacher, c
            MATCH (oldTeacher)-[m:MANAGES]->(c)
            DELETE m
    """)
    void removeTeacherManager(Long classId);

    @Query("""
        CREATE (c:classes {name: $name, academicCategory: $academicCategory})
        MERGE (t:teachers {id: $teacherId})
        MERGE (c)-[:MANAGED_BY]->(t)
        WITH c, $subjects AS subjectsList
        UNWIND subjectsList AS subject
        MERGE (s:subjects {id: subject})
        MERGE (c)-[:TEACHES]->(s)
        RETURN c
    """)
    Class create(String name, AcademicCategoryEnum academicCategory, Long teacherId, List<Long> subjects);

}
