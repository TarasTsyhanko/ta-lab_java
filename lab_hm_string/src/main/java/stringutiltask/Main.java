package stringutiltask;

public class Main {
    public static void main(String[] args) {
        String s1 = StringUtils.concat("hello",5,9.7, Boolean.TRUE,new Object().getClass());
        System.out.println(s1);
    }
}
