package vthreads;

/**
 * When the thread class is used to be executed, it needs a subclass
 * to implement the run() method. This implementation is not as recommended as the one
 * with Runnable, given that the other implementation is compatible with APIs and more flexible,
 * according to Java Tutorials.
 */
public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String[] args) {
        (new HelloThread()).start();
    }

}