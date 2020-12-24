/// synchoronized

package HandCode;

public class Print1 {
    
    private static int count = 1;
    private static final Object LOCK = new Object();
    private static class Printer implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (LOCK) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    LOCK.notifyAll();
                    try {
                        if(count <= 100) {
                            LOCK.wait();
                        } else {
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new Printer(), "Thread1").start();
        new Thread(new Printer(), "Thread2").start();
        new Thread(new Printer(), "Thread3").start();
        new Thread(new Printer(), "Thread4").start();
    }
}

// ReentrantLock
package HandCode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Print2 {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int count = 1;

    private static class PrintThread implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    condition.signalAll();
                    if(count <= 100) {
                        condition.await();
                    } else {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrintThread(), "Thread1").start();
        new Thread(new PrintThread(), "Thread2").start();
        new Thread(new PrintThread(), "Thread3").start();
        new Thread(new PrintThread(), "Thread4").start();
    }
}
