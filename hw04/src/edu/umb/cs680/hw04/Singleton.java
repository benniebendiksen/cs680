package edu.umb.cs680.hw04;

public class Singleton {

    private static Singleton oneInstance;

    public static Singleton getInstance() {
        if (oneInstance == null) {
            oneInstance = new Singleton();
        }
        return oneInstance;
    }


    public static void main(String args[]) {
        Singleton singletonInstance = Singleton.getInstance();
        Singleton singletonInstance2 = Singleton.getInstance();
        Singleton singletonInstance3 = Singleton.getInstance();
        System.out.printf("The Singleton Instance \"%s\"\n", singletonInstance);
        System.out.printf("The Singleton Instance 2 \"%s\"\n", singletonInstance2);
        System.out.printf("The Singleton Instance 3\"%s\"\n", singletonInstance3);
    }

}
