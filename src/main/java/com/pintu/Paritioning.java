package com.pintu;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Paritioning {
    public static void main(String[] args) {
        System.out.println("ok");
        final var persons1 = getPersons();
        final var persons = persons1.stream().
               collect(Collectors.partitioningBy(p -> p.getAge() % 2 ==0));
        System.out.println(persons);
        System.out.println(persons1.stream().collect(Collectors.groupingBy(Person::getName, mapping(Person::getAge, toList()))));
    }

    private static List<Person> getPersons() {
        return List.of(
                new Person("Sara", 12),
                new Person("Joe", 25),
                new Person("Sara", 67),
                new Person("pintu", 80),
                new Person("Ravi", 45),
                new Person("PInt", 12),
                new Person("Sara", 56)
        );
    }
}

class Person{
    private String name;

    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                 name + '\'' +
                 + age
                ;
    }
}