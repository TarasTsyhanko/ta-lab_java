package stringutilstask;

public class Main {
    public static void main(String[] args) {
        String s1 = StringUtils.concat("hello", 5, 9.7, Boolean.TRUE, Object.class);
        System.out.println(s1);
    }
}
