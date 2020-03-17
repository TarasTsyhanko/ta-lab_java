package annotationandreflaction.myclasses;

import annotationandreflaction.createdannotations.MyAnnotation;
import annotationandreflaction.createdannotations.Nationality;

public class Person {
    @MyAnnotation()
    public String firstName;
    @MyAnnotation()
    public String lastName;
    @MyAnnotation()
    private Gender gender;
    private int age;
    @Nationality(text = "ukrainian")
    private String nationality;

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
