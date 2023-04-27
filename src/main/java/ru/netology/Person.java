package ru.netology;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String city;

    //зачем это?
//    public Person(String name, String surname) {
//        this.name = name;
//        this.surname = surname;
//    }
//
//    public Person(String name, String surname, int age) {
//        this.name = name;
//        this.surname = surname;
//        if (age >= 0) this.age = age;
//    }

    protected Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.city = personBuilder.city;
    }

    public boolean hasAge() {
//        return this.age > 0;
//        return ((getAge().orElse(-1) > 0) ? true : false);
        return getAge().isPresent();
    }

    public boolean hasAddress() {
        return !city.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String city) {
        this.city = city;
    }

    public void happyBirthday() {
//        if (getAge().isPresent()) {
//            ++this.age;
//        }
        this.age = getAge().getAsInt() + 1;
    }

    @Override
    public String toString() {
        return name + ' ' + surname + ", (возраст " + getAge().getAsInt() +
                ", город " + city + ')';
    }

    @Override
    // а это зачем?
    public int hashCode() { /*...*/
        return 0;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.city)
                .setAge(0);
    }
}