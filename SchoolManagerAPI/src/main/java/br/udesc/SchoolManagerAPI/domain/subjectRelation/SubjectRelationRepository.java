package br.udesc.SchoolManagerAPI.domain.subjectRelation;

import br.udesc.SchoolManagerAPI.domain.classes.Class;
import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.teacher.Teacher;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface SubjectRelationRepository extends Neo4jRepository<SubjectRelation, Long> {

    void deleteAllByaClass(Class aClass);

    List<SubjectRelation> findAllByaClass(Class aClass);

    boolean existsByaClassAndTeacherAndSubject(Class aClass, Teacher teacher, Subject subject);


}
