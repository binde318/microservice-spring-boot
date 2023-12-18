package com.binde.school;

import com.binde.school.client.StudentClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    @Autowired
    private StudentClient client;
    private final static String NAME=" NAME NOT FOUND";
    private final static String EMAIL= "MAIL NOT FOUND";

    public void saveSchool(School school){
        schoolRepository.save(school);

    }
public List<School> findAllSchools(){
    return schoolRepository.findAll();

}

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {

        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name(NAME)
                        .email(EMAIL)
                        .build());

        var students = client.findAllStudentsBySchool(schoolId); //find all students from student microservice

        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
