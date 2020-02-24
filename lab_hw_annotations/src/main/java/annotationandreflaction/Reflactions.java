package annotationandreflaction;

import annotationandreflaction.createdannotations.MyAnnotation;
import annotationandreflaction.createdannotations.Nationality;
import annotationandreflaction.myclasses.MyClass;
import annotationandreflaction.myclasses.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflactions {
    private static final Logger LOG = LogManager.getLogger(Reflactions.class);

    public void printFieldInformation(Person person) {
        for (Field fields : person.getClass().getDeclaredFields()) {
            fields.setAccessible(true);
            if (fields.isAnnotationPresent(Nationality.class) || fields.isAnnotationPresent(MyAnnotation.class)) {
                LOG.info(fields.getType());
                LOG.info(fields.getName());
                try {
                    Object value = fields.get(person);
                    LOG.info(value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public void setNationality(Person person) {
        for (Field fields : person.getClass().getDeclaredFields()) {
            if (fields.isAnnotationPresent(Nationality.class)) {
                Nationality nationality = fields.getAnnotation(Nationality.class);
                try {
                    fields.setAccessible(true);
                    fields.set(person, nationality.text());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printAnnotationValue(Person person) {
        for (Field fields : person.getClass().getDeclaredFields()) {
            Nationality nationality = fields.getAnnotation(Nationality.class);
            if (nationality != null) {
                LOG.info("Annotation value - " + nationality.text() + "  " + Nationality.class.getSimpleName());
            }
        }
    }

    public void printMethodReturnType(Person person) {
        for (Method methods : person.getClass().getDeclaredMethods()) {
            LOG.info(methods.getName() + "  " + methods.getReturnType() + " " + Arrays.toString(methods.getParameterTypes()));
        }
    }

    public void printInformationAboutClass(MyClass<?> myClass) {
        try {
            Class<?> genericClass = Class.forName(myClass.getClass().getName());
            LOG.info(Arrays.toString(genericClass.getConstructors()));
            for (Field field :genericClass.getDeclaredFields()) {
                LOG.info(field.getName()+" "+field.getGenericType());
            }
            for (Method method : genericClass.getMethods()) {
                method.setAccessible(true);
                LOG.info(method.getName() + " "
                        + method.getGenericReturnType() + " "
                        + Arrays.toString(method.getParameterTypes()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void myMethod(String s, int... args) {
        LOG.info(s + " " + Arrays.toString(args));
    }
    public void myMethod2(int... args) {
        LOG.info( Arrays.toString(args));
    }
}
