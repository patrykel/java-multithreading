package exercises.ex04_synchronize;

// Java Program Illustrate Synchronized
// Using static synchronization

// Class 1
// Helper class
class PrintStaticTest extends Thread {

  // Static synchronization locks the class PrintStaticTest
  synchronized public static void printThread(int n) {
    for (int i = 1; i <= 10; i++) {
      // Print message when threads are executing
      System.out.println("Thread " + n + " is working...");

      // Try block to check for exceptions
      try {
        // making thread to sleep for 0.6 seconds
        Thread.sleep(600);
      }

      // Catch block to handle the exceptions
      catch (Exception ex) {
        // Print message when exception occurs
        System.out.println(ex.toString());
      }
    }

    // Display message for better readability
    System.out.println("--------------------------");

    try {
      Thread.sleep(1000);
    }

    catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }

  /*
   Now each thread waits on class access
   If we remove here synchronized we may interleave non-synchronized method with synchronized one
   */
  synchronized public static void otherSynchronizedPrint(int n) {
    for (int i = 1; i <= 10; i++) {
      // Print message when threads are executing
      System.out.println("Thread " + n + " is working...");

      // Try block to check for exceptions
      try {
        // making thread to sleep for 0.6 seconds
        Thread.sleep(600);
      }

      // Catch block to handle the exceptions
      catch (Exception ex) {
        // Print message when exception occurs
        System.out.println(ex.toString());
      }
    }
    System.out.println("--------------------------");
  }
}

// Class 2
// Helper class extending Thread class
class ThreadStatic1 extends Thread {
  // run() method for thread
  public void run() {
    // Passing the class not the object
    PrintStaticTest.printThread(1);
  }
}

// Class 3
// Helper class extending Thread class
class ThreadStatic2 extends Thread {
  public void run() {
    // Passing the class not the object
    PrintStaticTest.printThread(2);
  }
}

class ThreadStatic3 extends Thread {
  public void run() {
    // Passing the class not the object
    PrintStaticTest.otherSynchronizedPrint(3);
  }
}

// Class 4
// Main class
public class SynchronizedStatic {

  // Main driver method
  public static void run() {
    // No shared object
    // Creating objects of class 2 and 3 that
    // are extending to Thread class
    ThreadStatic1 t1 = new ThreadStatic1();
    ThreadStatic2 t2 = new ThreadStatic2();
    ThreadStatic3 t3 = new ThreadStatic3();

    // Starting thread with help of start() method
    t1.start();
    t2.start();
    t3.start();
  }
}
