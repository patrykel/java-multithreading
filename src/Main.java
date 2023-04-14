import exercises.ex01_basics.RunnableDemo;
import exercises.ex01_basics.ThreadDemo;
import exercises.ex02_monitor.GFGMonitor;
import exercises.ex03_monitor_sender.SyncDemo;
import exercises.ex04_synchronize.SynchronizedBlock;
import exercises.ex04_synchronize.SynchronizedMethod;
import exercises.ex04_synchronize.SynchronizedStatic;
import exercises.ex05_inter_thread_communication.ProducerConsumer;


public class Main {

  private static void exerciseOne() {
    RunnableDemo R1 = new RunnableDemo( "Runnable-1");
    R1.start();

    RunnableDemo R2 = new RunnableDemo( "Runnable-2");
    R2.start();

    ThreadDemo T1 = new ThreadDemo("Thread-1");
    T1.start();

    ThreadDemo T2 = new ThreadDemo("Thread-2");
    T2.start();
  }

  private static void exerciseTwo() {
    GFGMonitor.runMonitor();
  }

  private static void exerciseThree() {
    SyncDemo.run();
  }

  private static void exerciseFour() {
    /*
    // SynchronizedMethod.run();
    // SynchronizedBlock.run();
    // SynchronizedStatic.run();
    */
  }

  private static void exerciseFive() {
    try {
      ProducerConsumer.run();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    exerciseFive();
  }
}