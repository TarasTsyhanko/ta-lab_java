package readcomments;

public class ExampleComments {
    private Object obj;//this is comment in java source file
    private String slash = "//hello"; //this is comment, try to read it

    //This class is for task where I should create a program witch read comment from java file
    //that is why that class has no any logic
    /* another type of comment
    java java java
*/

    String str = "March/* month of the year */";/*february month*/
    /* java comment",la ,la"*/
    /** hello world
     *
     */
    private void doSomething(){
        System.out.println("//this is not a comment");//boom
        System.out.println("/* do not catch it */");
    }
}