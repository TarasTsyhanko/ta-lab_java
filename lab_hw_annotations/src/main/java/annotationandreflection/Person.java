package annotationandreflection;

import annotationandreflection.myannotation.MyAnnotation;
import annotationandreflection.myannotation.Nationality;

public class Person {
    @MyAnnotation
    public String firstName;
    @MyAnnotation
    public String lastName;
    @MyAnnotation
    private Gender gender;
    private int age;
    @Nationality(
            text = "ukrainian"
    )
    private String nationality;

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
