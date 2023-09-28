package br.udesc.SchoolManagerAPI.domain.student;

import br.udesc.SchoolManagerAPI.domain.classes.Class;
import br.udesc.SchoolManagerAPI.domain.classes.ClassRepository;
import br.udesc.SchoolManagerAPI.domain.student.dto.CreateStudentDTO;
import br.udesc.SchoolManagerAPI.domain.student.dto.ListStudentDTO;
import br.udesc.SchoolManagerAPI.utils.SchoolManagerUtils;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ClassRepository classRepository;

    public void create(CreateStudentDTO createStudentDTO) {
        Student student = new Student();
        student.setName(createStudentDTO.getName());

        Long classId = createStudentDTO.getClassId();

        if (classId != null) {
            Class aClass = classRepository.findById(classId).get();
            student.setAClass(aClass);
        }

        studentRepository.save(student);
    }

    public void edit(Long id, CreateStudentDTO createStudentDTO) {
        Student student = this.studentRepository.findById(id).get();
        student.setName(createStudentDTO.getName());

        if (createStudentDTO.getClassId() != null) {
            Class aClass = this.classRepository.findById(createStudentDTO.getClassId()).get();
            student.setAClass(aClass);
        }

        this.studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public List<ListStudentDTO> listStudents() {
        List<ListStudentDTO> listStudentDTOs = this.studentRepository.findAll().stream().map(student -> new ListStudentDTO(student)).toList();
        return listStudentDTOs;
    }

    @Transactional(readOnly = true)
    public String getStudentClassSubjectInfoReport() {
        String name = "Lista de Alunos por Turma e Disciplina";
        int colums = 3;
        List<Object[]> rows = this.studentRepository.getStudentClassSubjectInfo();

        String report = SchoolManagerUtils.buildReport(name, rows, colums);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("report", report);

        return jsonObject.toString();
    }

    public String getNotEnrolledStudentsReport() {
        List<Student> students = this.studentRepository.getNotEnrolledStudents();

        List<Object[]> rows = new ArrayList<Object[]>();

        for (Student student : students) {
            Object[] obj = new Object[1];
            obj[0] = student.getName();
            rows.add(obj);
        }

        String report = SchoolManagerUtils.buildReport("Alunos sem turma", rows, 1);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("report", report);

        return jsonObject.toString();
    }

    public void delete(Long studentId) {
        this.studentRepository.deleteById(studentId);
    }

    public ListStudentDTO findById(Long id) {
        Student student = this.studentRepository.findById(id).get();
        ListStudentDTO listStudentDTO = new ListStudentDTO(student);

        return listStudentDTO;
    }

}
