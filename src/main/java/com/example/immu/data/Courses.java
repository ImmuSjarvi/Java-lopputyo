package com.example.immu.data;

public class Courses {
    private String cName;
    private String teacher;
    private int credits;
    private int CourseId;

    //Staattinen muuttuja uniikkia ID:tä varten
    private static int count = 0;

    //Alustin
    public Courses(String cName, String teacher, int credits) {
        this.cName = cName;
        this.teacher = teacher;
        this.credits = credits;
        this.CourseId = count++;
    }

    //****
    //Getterit ja setterit alkaa

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCourseId() {
        return CourseId;
    }

    //Getterit ja setterit loppuu
    //***
}
