package br.udesc.SchoolManagerAPI.domain.teacher;

import br.udesc.SchoolManagerAPI.domain.base.BaseEntity;
import br.udesc.SchoolManagerAPI.domain.classes.Class;
import br.udesc.SchoolManagerAPI.domain.classes.ClassRepository;
import br.udesc.SchoolManagerAPI.domain.subject.Subject;
import br.udesc.SchoolManagerAPI.domain.subject.SubjectRepository;
import br.udesc.SchoolManagerAPI.domain.teacher.dto.ListTeacherDTO;
import br.udesc.SchoolManagerAPI.domain.teacher.dto.TeacherDTO;
import br.udesc.SchoolManagerAPI.utils.SchoolManagerUtils;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassRepository classRepository;

    public Teacher create(TeacherDTO teacherDTO) {
        List<Subject> subjects = subjectRepository.findAllById(teacherDTO.getSubjectIds());
        Teacher teacher = new Teacher(teacherDTO.getName(), subjects);

        return this.teacherRepository.createTeacher(
                teacher.getName(),
                subjects.stream().map(BaseEntity::getId).collect(Collectors.toList())
        );
    }

    @Transactional(readOnly = true)
    public List<TeacherDTO> findNoManagingTeachers() {
        List<TeacherDTO> teacherDTOS = this.teacherRepository.findNoManagingTeachers()
                .stream()
                .map(TeacherDTO::new)
                .toList();

        return teacherDTOS;
    }

    @Transactional(readOnly = true)
    public List<ListTeacherDTO> listAll() {
        List<ListTeacherDTO> listTeacherDTOS = this.teacherRepository.findAll()
                .stream()
                .map(ListTeacherDTO::new)
                .toList();

        return listTeacherDTOS;
    }

    @Transactional(readOnly = true)
    public ListTeacherDTO findById(Long id) {
        Teacher teacher = this.teacherRepository.findById(id).get();
        ListTeacherDTO listTeacherDTO = new ListTeacherDTO(teacher);

        return listTeacherDTO;
    }

    @Transactional(readOnly = true)
    public String report() {
        String name = "Lista de Professores e Turmas que Eles Gerenciam";
        int colums = 2;
        List<Object[]> rows = this.teacherRepository.getTeacherClassInfo();

        String report = SchoolManagerUtils.buildReport(name, rows, colums);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("report", report);

        return jsonObject.toString();
    }

    public void delete(Long teacherId) {
        Teacher teacher = this.teacherRepository.findById(teacherId).get();

        Class managedClass = teacher.getManagedClass();

        if (managedClass != null) {
            managedClass.setTeacherManager(null);
            teacher.setManagedClass(null);

            this.classRepository.removeTeacherManager(managedClass.getId());
        }

        this.teacherRepository.delete(teacherId);
    }

    public void edit(Long id, TeacherDTO teacherDTO) {
        Teacher teacher = this.teacherRepository.findById(id).get();
        teacher.setName(teacherDTO.getName());

        List<Long> subjectIds = teacherDTO.getSubjectIds();
        if (subjectIds != null && !subjectIds.isEmpty()) {
            teacher.setSubjects(this.subjectRepository.findAllById(subjectIds));
        }
    }
}
