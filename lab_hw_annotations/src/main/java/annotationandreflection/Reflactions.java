package annotationandreflection;

import annotationandreflection.myannotation.MyAnnotation;
import annotationandreflection.myannotation.Nationality;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflactions {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public Reflactions() {
    }

    public void printFieldInformation(Person person) {
        Field[] var2 = person.getClass().getDeclaredFields();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Field fields = var2[var4];
            fields.setAccessible(true);
            if (fields.isAnnotationPresent(Nationality.class) || fields.isAnnotationPresent(MyAnnotation.class)) {
                LOG.info(fields.getType());
                LOG.info(fields.getName());

                try {
                    Object value = fields.get(person);
                    LOG.info(value);
                } catch (IllegalAccessException var7) {
                    var7.printStackTrace();
                }
            }
        }

    }

    public void setNationality(Person person) {
        Field[] var2 = person.getClass().getDeclaredFields();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Field fields = var2[var4];
            if (fields.isAnnotationPresent(Nationality.class)) {
                Nationality nationality = (Nationality)fields.getAnnotation(Nationality.class);

                try {
                    fields.setAccessible(true);
                    fields.set(person, nationality.text());
                } catch (IllegalAccessException var8) {
                    var8.printStackTrace();
                }
            }
        }

    }

    public void printAnnotationValue(Person person) {
        Field[] var2 = person.getClass().getDeclaredFields();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Field fields = var2[var4];
            Nationality nationality = (Nationality)fields.getAnnotation(Nationality.class);
            if (nationality != null) {
                LOG.info("Annotation value - " + nationality.text() + "  " + Nationality.class.getSimpleName());
            }
        }

    }

    public void printMethodReturnType(Person person) {
        Method[] var2 = person.getClass().getDeclaredMethods();
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Method methods = var2[var4];
            LOG.info(methods.getName() + "  " + methods.getReturnType() + " " + Arrays.toString(methods.getParameterTypes()));
        }

    }

    public void printInformationAboutClass(MyClass<?> myClass) {
        try {
            Class<?> genericClass = Class.forName(myClass.getClass().getName());
            LOG.info(Arrays.toString(genericClass.getConstructors()));
            Field[] var3 = genericClass.getDeclaredFields();
            int var4 = var3.length;

            int var5;
            for(var5 = 0; var5 < var4; ++var5) {
                Field field = var3[var5];
                LOG.info(field.getName() + " " + field.getGenericType());
            }

            Method[] var8 = genericClass.getMethods();
            var4 = var8.length;

            for(var5 = 0; var5 < var4; ++var5) {
                Method method = var8[var5];
                method.setAccessible(true);
                LOG.info(method.getName() + " " + method.getGenericReturnType() + " " + Arrays.toString(method.getParameterTypes()));
            }
        } catch (ClassNotFoundException var7) {
            var7.printStackTrace();
        }

    }

    public void myMethod(String s, int... args) {
        LOG.info(s + " " + Arrays.toString(args));
    }

    public void myMethod2(String... args) {
        LOG.info(Arrays.toString(args));
    }
}
