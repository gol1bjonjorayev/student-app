package gol1bjon.developer.springbootapp.service;

import gol1bjon.developer.springbootapp.repository.StudentRepository;
import gol1bjon.developer.springbootapp.entity.Students;
import gol1bjon.developer.springbootapp.exception.NotFoundException;
import gol1bjon.developer.springbootapp.payload.ResponseApi;
import gol1bjon.developer.springbootapp.payload.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Students> getAll() {
        return studentRepository.findAll();
    }

    public Students getOne(Long id) {
       return  studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Student Not Found"));
    }

    public ResponseApi addStudent(StudentDTO dto) {
        Students students = Students.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .course(dto.getCourse())
                .build();
        studentRepository.save(students);
        return new ResponseApi("Create student in database",true);
    }

    public ResponseApi update(Long id, StudentDTO dto) {
        Students students = studentRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Fount Student"));

            students.setFirstName(dto.getFirstName());
            students.setLastName(dto.getLastName());
            students.setCourse(dto.getCourse());
            studentRepository.save(students);
            return new ResponseApi("Student Update",true);

    }

    public ResponseApi delete(Long id) {
        studentRepository.deleteById(id);
        return new ResponseApi("Deleted Student",true);
    }

    public List<Students> searchName(String name) {
        return studentRepository.searchByName(name);
    }


//    @Scheduled(cron = "0 40 23 * * *")
//    public ResponseApi saveScheduled(StudentDTO dto){
//        Students students = Students.builder()
//                .firstName(dto.getFirstName())
//                .lastName(dto.getLastName())
//                .course(dto.getCourse())
//                .build();
//        studentRepository.save(students);
//        return new ResponseApi("Create student in database",true);
//    }
}
