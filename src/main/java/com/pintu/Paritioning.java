package com.pintu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Paritioning {
    public static void main(String[] args) {
        System.out.println("ok");
        final var persons1 = getPersons();
        final var persons = persons1.stream().
                collect(Collectors.partitioningBy(p -> p.getAge() % 2 == 0));
        System.out.println(persons);
        System.out.println(
                persons1.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getName, mapping(Person::getAge, toList())
                                )
                        )
        );
        System.out.println(persons1.stream().collect(groupingBy(Person::getName, collectingAndThen(counting(), Long::intValue))));

        System.out.println(persons1.stream().min(Comparator.comparing(Person::getAge)));
        System.out.println(persons1.stream().max(Comparator.comparing(Person::getAge)));
        final var maxPerson = persons1.stream().collect(collectingAndThen(maxBy(Comparator.comparing(Person::getAge)), person -> person.map(Person::getName).orElse("")));
        System.out.println(maxPerson);
        System.out.println(persons1.stream().collect(groupingBy(Person::getName, filtering(p -> p.getAge() > 30, toList()))));
        System.out.println(persons1.stream().collect(groupingBy(Person::getName, mapping(Person::getName, filtering(name -> name.length() > 2, toList())))));
        System.out.println(persons1.stream().collect(filtering(e -> e.getAge() > 2, mapping(Person::getName, toList()))));

        System.out.println(persons1.stream().collect(groupingBy(Person::getAge, flatMapping(e -> Arrays.stream(e.getName().split("")), toList()))));
        Stream.of(new String[]{"a", "b", "c"}).forEach(System.out::print);

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

class Person {
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
                name + " -- " +
                        +age
                ;
    }
}