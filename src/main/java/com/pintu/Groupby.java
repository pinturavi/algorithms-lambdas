package com.pintu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Groupby {
    public static void main(String[] args) {
        final var numbers = List.of(23, 45, 56, 23, 23, 45);
        final var value = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(numbers.stream().mapToInt(e -> e).sum());
        System.out.println(value);

        final var students = List.of(new Student(12, "ravi"), new Student(11, "ravi"));
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.mapping(Student::getRollno, Collectors.toList()))));

        final var charcount = Arrays.stream("raviii".split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.mapping( String::valueOf, Collectors.counting())));

        System.out.println(charcount);
    }
}

class Student{
    private int rollno;

    private String name;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                '}';
    }
}