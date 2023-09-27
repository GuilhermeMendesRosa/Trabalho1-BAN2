package br.udesc.SchoolManagerAPI.domain.teacher;

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

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ClassRepository classRepository;

    public void create(TeacherDTO teacherDTO) {
        List<Subject> subjects = subjectRepository.findAllById(teacherDTO.getSubjectIds());
        Teacher teacher = new Teacher(teacherDTO.getName(), subjects);

        this.teacherRepository.save(teacher);
    }

    public List<TeacherDTO> findNoManagingTeachers() {
        List<TeacherDTO> teacherDTOS = this.teacherRepository.findNoManagingTeachers()
                .stream()
                .map(teacher -> new TeacherDTO(teacher))
                .toList();

        return teacherDTOS;
    }

    public List<ListTeacherDTO> listAll() {
        List<ListTeacherDTO> listTeacherDTOS = this.teacherRepository.findAll()
                .stream()
                .map(teacher -> new ListTeacherDTO(teacher))
                .toList();

        return listTeacherDTOS;
    }

    public ListTeacherDTO findById(Long id) {
        Teacher teacher = this.teacherRepository.findById(id).get();
        ListTeacherDTO listTeacherDTO = new ListTeacherDTO(teacher);

        return listTeacherDTO;
    }

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

            this.classRepository.save(managedClass);
            this.teacherRepository.save(teacher);
        }

        this.teacherRepository.deleteById(teacherId);
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
