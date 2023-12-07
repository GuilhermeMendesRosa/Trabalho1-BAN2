package br.udesc.SchoolManagerAPI.domain.subject;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends Neo4jRepository<Subject, Long> {


    @Query("CREATE (c:subjects {name: $name, createdAt: timestamp(), updatedAt: timestamp(), version: 0}) RETURN c")
    Subject createSubject(@Param("name") String name);

    @Query("MATCH (subject:`subjects`) return subject")
    List<Subject> getAll();
}
