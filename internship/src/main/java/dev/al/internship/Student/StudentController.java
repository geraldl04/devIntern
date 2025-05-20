package dev.al.internship.Student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dev.al.internship.Student.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //krijo student , perdora metoden reqquest body
    @PostMapping
    public String saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Studenti u ruajt";
    }

    //marr student duke perdor pathvariable qe merr nga url dhe jo query
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

   //merr studentat
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    //fshi studentat
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return "Studenti u fshi ";
    }
}
