package stringutiltask;

public class StringUtils {
    @SafeVarargs
    public static <T> String concat(T ... obj){
        String s = "" ;
        for (T type:obj) {
          s = s+ type.toString() ;
        }
        return s;
    }
}
