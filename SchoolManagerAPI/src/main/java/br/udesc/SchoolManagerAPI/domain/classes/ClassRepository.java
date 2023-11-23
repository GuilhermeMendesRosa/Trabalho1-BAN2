package br.udesc.SchoolManagerAPI.domain.classes;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Map;

public interface ClassRepository extends Neo4jRepository<Class, Long> {

    @Query("MATCH (c:Neo4jClass)-[:BELONGS_TO]->(s:Student) " +
            "RETURN c.academicCategory AS academic_category, COUNT(s) AS number_of_students " +
            "ORDER BY c.academicCategory")
    List<Object[]> getClassStudentCountByCategory();

}
