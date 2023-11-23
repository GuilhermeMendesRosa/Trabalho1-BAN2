package br.udesc.SchoolManagerAPI.domain.subject;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends Neo4jRepository<Subject, Long> {
}
