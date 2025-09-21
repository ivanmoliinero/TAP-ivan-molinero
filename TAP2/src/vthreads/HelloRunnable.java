package vthreads;

/**
 * When creating a thread with the Runnable interface, the constructor of Thread needs to be invoked
 * and fed with a run() implementation, whether it is an anonymous class or a lambda method (Runnable is a
 * functional interface).
 */
public class HelloRunnable implements Runnable {

    public void run() {
        System.out.println("Hello from a thread created with an anonymous class!");
    }

    public static void main(String[] args) {
        (new Thread(new HelloRunnable())).start();
        (new Thread(() -> System.out.println("I am the thread created with a lambda"))).start();
        System.out.println("I am the main thread.");
    }

}

