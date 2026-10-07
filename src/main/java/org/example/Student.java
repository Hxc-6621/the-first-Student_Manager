package org.example;
public class Student {
    private String id;
    private String name;
    private int age;
    private  int score;
    public Student(String id, String name, int age, int score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }
    public Student() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=0&&age<=100){
            this.age = age;
        }else{
            throw new IllegalAgeException("年龄非法");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', age=" + age + ", score=" + score + "}";
    }
}
