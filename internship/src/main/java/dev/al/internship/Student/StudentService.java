package dev.al.internship.Student;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
//ketu shkruher gjithe logjika , po i perdor metodat e gatshme te jpa repo duke shtuar nje println .

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
//ruaj student  //printimet do printohen ne console
    public void saveStudent(Student student) {
        repository.save(student);
        System.out.println(" Studenti u ruajt ne databaze :  " + student.getName());
    }

   //gjej ne baze te id-se
    public Student getStudentById(int id) {
        Optional<Student> result = repository.findById(id);
        if (result.isPresent()) {
            System.out.println(" Studenti u gjet  " + result.get().getName());
            return result.get();
        } else {
            System.out.println(" Studenti me kete id nuk u gjet " + id);
            return null;
        }
    }

  //kthe te gjithe student
    public List<Student> getAllStudents() {
        List<Student> students = repository.findAll();
        System.out.println(" Numri i stud : " + students.size());
        return students;
    }

   //fshi nga id
    public void deleteStudentById(int id) {
        repository.deleteById(id);
        System.out.println(" U fshi studenti me id  " + id);
    }
}