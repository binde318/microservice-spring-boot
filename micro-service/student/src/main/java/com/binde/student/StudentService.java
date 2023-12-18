package com.binde.student;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void saveStudent(Student student){
        studentRepository.save(student);

    }
public List<Student> findAllStudent(){
    return studentRepository.findAll();

}

    public List<Student> findAllStudentsBySchool(Integer schoolId) {

        return studentRepository.findAllBySchoolId(schoolId);
    }
}
