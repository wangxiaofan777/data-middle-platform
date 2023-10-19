package com.wxf;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        new ArrayBlockingQueue<Integer>(100);
        new LinkedBlockingDeque<Integer>(100);
        new LinkedBlockingDeque<Integer>(100);


        Person p1 = new Person(1, "w");
        Person p2 = new Person(1, "w");

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        Integer a1 = 1;
        Integer a2 = 1;

        System.out.println(a1 == a2);
        System.out.println(a1.equals(a2));

    }


}

class Person {

    private Integer id;

    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}