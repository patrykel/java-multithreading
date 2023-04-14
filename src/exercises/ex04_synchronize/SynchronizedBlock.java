package exercises.ex04_synchronize;

// Java Program Illustrating Synchronized Code
// Using synchronized block

// Class 1
// Helper class extending Thread class
class PrintBlockTest extends Thread {

  // Method 1
  // To print the thread
  public void printThread(int n) {

    // Making synchronized block that makes the block
    // synchronized
    synchronized (this) {
      // Iterating using for loop
      for (int i = 1; i <= 10; i++) {
        // Print message when these thread are
        // executing
        System.out.println("Thread " + n + " is working...");

        // Try block to check for exceptions
        try {
          // Making thread to pause for 0.6
          // seconds
          Thread.sleep(600);
        }

        // Catch block to handle exceptions
        catch (Exception ex) {

          // Print message when exception.s occur
          System.out.println(ex.toString());
        }
      }
    }

    // Display message only
    System.out.println("--------------------------");

    try {
      // Making thread t osleep for 1 sec
      Thread.sleep(1000);
    }

    catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }
}

// Class 2
// Helper class extending Thread class
class ThreadBlock1 extends Thread {

  PrintBlockTest test;
  ThreadBlock1(PrintBlockTest p) {
    test = p;
  }

  public void run() {
    test.printThread(1);
  }
}

// Class 3
// Helper class extending Thread class
class ThreadBlock2 extends Thread {

  PrintBlockTest test;
  ThreadBlock2(PrintBlockTest p) {
    test = p;
  }

  public void run() {
    test.printThread(2);
  }
}

// Class 4
// Main class
public class SynchronizedBlock {

  // Main driver method
  public static void run(){
    // Creating instance for class 1 inside main()
    PrintBlockTest p = new PrintBlockTest();

    // Creating threads and
    // passing same object
    ThreadBlock1 t1 = new ThreadBlock1(p);
    ThreadBlock2 t2 = new ThreadBlock2(p);

    // Starting these thread using start() method
    t1.start();
    t2.start();
  }
}
