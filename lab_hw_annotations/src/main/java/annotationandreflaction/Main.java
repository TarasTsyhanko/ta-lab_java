package annotationandreflaction;

import annotationandreflaction.myclasses.Gender;
import annotationandreflaction.myclasses.MyClass;
import annotationandreflaction.myclasses.Person;

public class Main {
    public static void main(String[] args){
        Reflactions reflactions = new Reflactions();
        Person person = new Person("Ivan", "JavaScriper", 20, Gender.MALE);
        reflactions.setNationality(person);
        reflactions.printFieldInformation(person);
        reflactions.printAnnotationValue(person);
        reflactions.printMethodReturnType(person);
        reflactions.myMethod("java", 3, 6, 7, 2, 6);
        reflactions.printInformationAboutClass(new MyClass<Person>(person));
    }
}
