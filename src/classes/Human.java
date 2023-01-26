package classes;

import enums.*;
import interfaces.*;

import java.util.Objects;

public class Human extends Life implements DoingSmf, ShowingCondition{
    private String znania = "low";
    private boolean son = false;
    private Gender gender = Gender.MALE;
    Condition condition = Condition.NEUTRAL;
    public String interes;
    int age;
    //конструкторы:
    public Human() {
        this.name = "Безымянный";
        System.out.println("Нигде создан человек без имени");
    }
    public Human(String name) {
        this.name = name;
        System.out.println("Нигде создан человек по имени " + name);
    }
    public Human(String name, Height height) {
        this.name = name;
        this.height = height;
        System.out.println("Создан человек по имени " + name + " в месте под названием " + place.getName());
    }
    public Human(String name, Height height, Place place) {
        this.name = name;
        this.height = height;
        this.place = place;
        System.out.println("Создан человек по имени " + name + " " + height.getName() + " в месте под названием " + place.getName());
    }
    public Human(String name, Height height, Gender gender, Place place) {
        this.name = name;
        this.height = height;
        this.place = place;
        this.gender = gender;
        System.out.println("Создан человек по имени " + name + " " + height.getName() + " в месте под названием " + place.getName());
    }
    public Human(String name, int age, Height height, Gender gender, Place place) {
        if (age <= 0) throw new IncorrectAgeException("Возраст должен быть положительным");
        else
        {
        this.name = name;
        this.age = age;
        this.height = height;
        this.place = place;
        this.gender = gender;
        System.out.println("Создан человек по имени " + name + " " + height.getName() + " в месте под названием " + place.getName());
        }
    }
    //методы людей
    @Override
    public void doingSmf(String doing, String smf){
        System.out.println(condition.getName() + " " + name + " " + doing + " " + smf);
    }
    @Override
    public void showCondition(String reason) {
        switch (condition) {
            case SAD -> System.out.println(name + " грустит, потому что " + reason);
            case FUN -> System.out.println(name + " веселый, потому что " + reason);
            case REMORSE -> System.out.println(name + " раскаивается, потому что " + reason);
            case SHAME -> System.out.println(name + " стыдится, потому что " + reason);
            case NEUTRAL -> System.out.println(name + " нейтральный, потому что " + reason);
            case FAIR -> System.out.println(name + " боится, потому что " + reason);
            default -> System.out.println(name + " в неопределенном состоянии");
        }
    }
    public void showCondition() {
        switch (condition) {
            case SAD -> System.out.println(name + " грустит");
            case FUN -> System.out.println(name + " веселый");
            case REMORSE -> System.out.println(name + " раскаивается");
            case SHAME -> System.out.println(name + " стыдится");
            case NEUTRAL -> System.out.println(name + " нейтральный");
            case FAIR -> System.out.println(name + " боится");
            default -> System.out.println(name + " в неопределенном состоянии");
        }
    }
    public void tell (String phrase){
            System.out.printf("%s сказал: \n-%s. \n", name, phrase);
    }
    public void sleep (){
        if (Place.time == TimeOfDay.NIGHT){
            son = true;
            System.out.println(name + " уснул");
        }
        else {
            System.out.println(name + " не будет спать, потому что сейчас " + Place.time.getName());
        }
    }
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
    public boolean isSon() {
        return son;
    }
    public Condition getCondition() {
        return condition;
    }
    public Gender getGender(){
        return gender;
    }
    @Override
    public String toString() {
        return "Class Classes.Human{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", gender=" + gender +
                ", place=" + place.getName() +
                ", condition=" + condition +
                ", son:" + son +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return Objects.equals(getHeight(), human.getHeight());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
    //новые методы для 4 лабы
    public void setInteres(Human obj){
        interes = obj.getName();
        System.out.println(this.name + " интересуется " + obj.getName());
    }
    public void outInteres(Human obj){
        interes = null;
        System.out.println(this.name + " перестал интересоваться о/об " + obj.getName());
    }

    public String getZnania() {
        return znania;
    }

    public void setZnania(String znania) {
        this.znania = znania;
    }
}