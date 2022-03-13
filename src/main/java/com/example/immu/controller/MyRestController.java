package com.example.immu.controller;

import com.example.immu.data.Courses;
import com.example.immu.data.Students;
import com.example.immu.data.StudentsOnCourses;
import com.example.immu.service.CourseService;
import com.example.immu.service.StudentOnCourseService;
import com.example.immu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    StudentService myStudentService;
    @Autowired
    CourseService myCourseService;
    @Autowired
    StudentOnCourseService myStudentOnCourseService;

    //Luetaan kaikki opiskelijat
    //http://localhost:8080/students
    @GetMapping("students")
    public List<Students> getStudents(){
        return myStudentService.getStudents();
    }

    //Opiskelijan haku Id:llä
    @GetMapping("students/{id}")
    public List<Students> getStudentById(@PathVariable int id){
        return myStudentService.getStudentById(id);
    }

    //Lisätään opiskelija
    @PostMapping("addstudent")
    public String addStudent(@RequestBody Students student){
        myStudentService.addStudent(student);
        return "Lisätty";
    }


    //Haetaan kaikki kurssit
    @GetMapping("courses")
    public List<Courses> getCourses(){
        return myCourseService.getCourses();
    }

    //Haetaan kaikki kurssit, joilla sama opettaja
    @GetMapping("courses/{teacher}")
    public List<Courses> getTeacherCourses(@PathVariable String teacher){
        return myCourseService.getCoursesByTeacher(teacher);
    }

    //Lisätään kurssi
    @PostMapping("addcourse")
    public String addCourse(@RequestBody Courses course){
        myCourseService.addCourse(course);
        return "Kurssi lisätty";
    }

    //Luetaan kaikki opiskelijat kursseilta
    @GetMapping("SOC")
    public List<StudentsOnCourses> getStudentsOnCourse(){
        return myStudentOnCourseService.getStudentsOnCourses();
    }

    //Lisätään opiskelija kurssille
    @PostMapping("addSOC")
    public String addStudentOnCourse(@RequestBody StudentsOnCourses studentsoncourse){
        myStudentOnCourseService.addStudentOnCourse(studentsoncourse);
        return "Lisätty";
    }

    //Hakee kurssit, joilla opiskelija on listoilla. Haku opiskellijan ID:llä
    @GetMapping("SOC/{id}")
    public List<StudentsOnCourses> getSOCbyStudentId(@PathVariable int id){
        return myStudentOnCourseService.getSOCbyStudentId(id);
    }

    //Hakee opiskelijat, jotka on kurssilla. Haku kurssin ID:llä
    @GetMapping("SOCC/{id}")
    public List<StudentsOnCourses> getSOCbyCourseId(@PathVariable int id){
        return myStudentOnCourseService.getSOCbyCourseId(id);
    }

}
