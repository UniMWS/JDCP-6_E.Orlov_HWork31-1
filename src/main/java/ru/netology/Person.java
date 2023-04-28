package ru.netology;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String city;

    protected Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.city = personBuilder.city;
    }

    public boolean hasAge() {
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
        this.age = getAge().getAsInt() + 1;
    }

    @Override
    public String toString() {
        return name + ' ' + surname + ", (возраст " + getAge().getAsInt() +
                ", город " + city + ')';
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAddress(this.city)
                .setAge(0);
    }
}