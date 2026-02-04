package com.student.controller;

import com.student.dto.StudentCreateDTO;
import com.student.service.Impl.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("student")
public class StudentController {
    private final StudentServiceImpl studentService;

    @PostMapping("add")
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentCreateDTO studentCreateDTO){
        studentService.addStudent(studentCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


























//    @GetMapping("/get")
//    public List<StudentEntity> getStudents(){
//        return studentRepository.findAll();
//    }
//
//    @GetMapping("/get/id")
//    public StudentEntity getStudents(Long id){
//        return studentRepository.findById(id).orElseThrow(
//                ()-> new RuntimeException("not found user")
//        );
//    }
//
//    @GetMapping("getOld")
//    public StudentEntity getStudent(){
//        List<StudentEntity> list = studentRepository.findAll();
//        return list.stream()
//                .max(comparingInt(s->s.getAge()))
//                .get();
//    }

//    ArrayList<String> students = new ArrayList<>(List.of("Gunel", "Gunay", "Arzu"));
//    Map<Integer, String> studentMap = new HashMap<>(Map.of(1, "Gunel",
//            2, "Gunay",
//            3, "Arzu",
//            4, "Zahra"));
//
//    @GetMapping("/get")
//    public String hello (@RequestParam(value = "firstName",defaultValue = "Zahra",required = false) String firstName,
//                         @RequestParam(value = "lastName",defaultValue = "Malik",required = false) String lastName){
//        return firstName+ " " + lastName;
//    }
//
//    @GetMapping("/get/students")
//    public List<String> students(){
//        return students;
//    }
//
//    @GetMapping("get/students/check")
//    public List<String> checkStudent(@RequestParam(value = "name", defaultValue = "Kazim", required = false) String name){
//        if(!students.contains(name)){
//            students.add(name);
//            return students;
//        }
//        return students;
//    }
//
//    @GetMapping("getById")
//    public List<String> getStudentById(@RequestParam(value = "id") Integer id){
//        return studentMap.entrySet().stream().filter(s -> s.getKey().equals(id))
//                .map(Map.Entry::getValue)
//                .toList();
//    }

}
