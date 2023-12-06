package br.udesc.SchoolManagerAPI.domain.subjectRelation;

import br.udesc.SchoolManagerAPI.domain.classes.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRelationRepository extends JpaRepository<SubjectRelation, Long> {

    void deleteAllByaClass(Class aClass);

}
