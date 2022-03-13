package com.example.immu.data;

public class Students {
    private String fname;
    private String lname;
    private int age;
    private int studentId;

    //Staattinen muuttuja uniikkia ID:tä varten
    private static int count = 0;


    //Alustin
    public Students(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.studentId = count++;
    }

    //Oletus alustin
    public Students(){
        this("","",0);
    }

    //***
    //Getterit ja setterit alkaa

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    //Getterit ja setterit loppuu
    //***
}
