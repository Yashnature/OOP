package com.school.data;

public class Student {
    private String name;
    private int marks1, marks2, marks3;

    public Student(String name, int marks1, int marks2, int marks3) {
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public String getName() {
        return name;
    }

    public int getMarks1() {
        return marks1;
    }

    public int getMarks2() {
        return marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    @Override
    public String toString() {
        return "Student Name: " + name + "\nMarks: " + marks1 + ", " + marks2 + ", " + marks3;
    }
}
package com.school.util;

import com.school.data.Student;

public class Analyzer {

    public double calculateAverage(Student s) {
        return (s.getMarks1() + s.getMarks2() + s.getMarks3()) / 3.0;
    }

    public String findGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }
}
