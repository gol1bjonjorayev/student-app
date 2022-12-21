package gol1bjon.developer.springbootapp.controller;


import gol1bjon.developer.springbootapp.entity.Students;
import gol1bjon.developer.springbootapp.payload.ResponseApi;
import gol1bjon.developer.springbootapp.payload.StudentDTO;
import gol1bjon.developer.springbootapp.service.StudentService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    final
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public HttpEntity<List<Students>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/getOne/{id}")
    public HttpEntity<Students> getOne(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getOne(id));
    }

    @PostMapping("/addStudent")
    public HttpEntity<ResponseApi> addStudent(@RequestBody StudentDTO dto){
        return ResponseEntity.ok(studentService.addStudent(dto));
    }

    @PutMapping("update/{id}")
    public HttpEntity<ResponseApi> update(@PathVariable Long id, @RequestBody StudentDTO dto){
        return ResponseEntity.ok(studentService.update(id,dto));
    }

    @DeleteMapping("delete/{id}")
    public HttpEntity<ResponseApi> delete(@PathVariable Long id){
        return ResponseEntity.ok(studentService.delete(id));
    }

    @GetMapping("search/{name}")
    public HttpEntity<List<Students>> searchName(@PathVariable String name){
        return ResponseEntity.ok(studentService.searchName(name));
    }

}
