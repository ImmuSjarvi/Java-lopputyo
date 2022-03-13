package com.example.immu.service;

import com.example.immu.data.Courses;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    FileService myFileService;

    private List<Courses> courses = new ArrayList<>();



    //Kun CourseService olio luodaan springiin, niin haetaan kurssi tiedot filestä
    public CourseService(){
        myFileService= new FileService();
        try {
            courses = myFileService.readCoursesFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException f){
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
    }

    //Kurssin lisäys listaan, kirjotetaan samalla tiedostoon
    public void addCourse(Courses course){
        courses.add(course);
        try {
            myFileService.writeCoursesToFile(courses,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Palauttaa kurssilistan
    public List<Courses> getCourses(){
        return new ArrayList<>(courses);
    }

    //Palauttaa kaikki kurssit, joilla on sama opettaja. opettaja annetaan parametrinä
    public List<Courses> getCoursesByTeacher(String teacher){
        List<Courses> foundCourses = new ArrayList<>();

        for (Courses c : courses) {
            if(c.getTeacher().equals(teacher)) {
                foundCourses.add(c);
            }
        }
        return foundCourses;
    }
}
