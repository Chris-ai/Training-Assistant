package com.example.trainingassistant;
public class Person {


    private String gender;
    private String name;
    private int Age;
    private int Weight;
    private int Height;

    StringBuilder stringBuilder;

    public Person(String name, String surname, int Age, int Weight, int Height, String gender) {
        stringBuilder = new StringBuilder().append(name).append(" ").append(surname);
        this.name = stringBuilder.toString();
        this.Age = Age;
        this.Height = Height;
        this.Weight = Weight;
        this.gender = gender;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }
}
