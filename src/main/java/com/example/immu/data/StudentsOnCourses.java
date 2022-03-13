package com.example.immu.data;

public class StudentsOnCourses {
    private int studentId;
    private int courseId;
    private int studentsOnCourseId;

    //Staattinen muuttuja uniikkia ID:tä varten
    private static int count = 0;

    //ALustin
    public StudentsOnCourses(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.studentsOnCourseId = count++;
    }

    //Getterit
    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getStudentsOnCourseId() {
        return studentsOnCourseId;
    }
}
