package com.student.service.Impl;

import com.student.dao.repository.StudentRepository;
import com.student.dto.StudentCreateDTO;
import com.student.exception.FormatInvalidException;
import com.student.exception.IsNullException;
import com.student.mapper.AllMapper;
import com.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final AllMapper mapper;

    String nameRegex = "^[A-Za-zƏəÖöĞğŞşÇçİıÜü]{2,30}$";


//    @Override
//    public void addStudent(StudentCreateDTO studentCreateDTO) {
//        if(studentCreateDTO.getFirstName()==null || studentCreateDTO.getLastName()==null ||
//            studentCreateDTO.getAge()==null){
//            throw new IsNullException();
//        }
//
//        if(!Pattern.matches(nameRegex, studentCreateDTO.getFirstName())){
//            throw new FormatInvalidException();
//        }
//
//        if(!Pattern.matches(nameRegex, studentCreateDTO.getLastName())){
//            throw new FormatInvalidException();
//        }
//
//        if(studentCreateDTO.getAge()<18){
//            throw new FormatInvalidException();
//        }
//
//        studentRepository.save(mapper.simpleDtoToEntity(studentCreateDTO));
//    }


    @Override
    public void addStudent(StudentCreateDTO studentCreateDTO) {
        studentRepository.save(mapper.simpleDtoToEntity(studentCreateDTO));
    }
}
