package com.example.immu.service;

import com.example.immu.data.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    FileService myFileService;


    private List<Students> students = new ArrayList<>();




    //Kun StudentService olio luodaan springiin, niin haetaan studentti tiedot filestä
    public StudentService(){
        myFileService= new FileService();
        try {
            students = myFileService.readStudentsFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException f){
            System.out.println(f.getMessage());
            f.printStackTrace();
        }
    }

    //Opiskelijan lisääminen listaan, kirjoitetaan samalla tiedostoon "students.txt"
    public void addStudent(Students student) {
        students.add(student);
        try {
            myFileService.writeStudentsToFile(students,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Palauttaa listan opiskelijoista
    public List<Students> getStudents()  {
        return new ArrayList<>(students);
    }

    //Palauttaa opiskelija ID:llä,  annetaan parametrinä
    public List<Students> getStudentById(int id){
        List<Students> foundStudent = new ArrayList<>();

        for (Students s : students) {
            if(s.getStudentId()==id) {
                foundStudent.add(s);
            }
        }
        return foundStudent;
    }

}


