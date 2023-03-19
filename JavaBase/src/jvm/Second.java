package jvm;

public class Second {
    static int a;
    static int b = 10;
    static final int c = 20;
    static final String d = "hello";
    private static final User user = new User();


    static {
        b = 11;
    }
}
