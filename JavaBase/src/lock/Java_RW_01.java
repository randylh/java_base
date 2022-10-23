package lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Java_RW_01 {

    private static int value = 0;

    private static ReentrantLock lock = new ReentrantLock();

    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    private static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    private static void write(Lock lock, int v) {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over");
        }catch (Exception e) {

        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {

        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
//                read(lock);
                read(readLock);
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
//                write(lock, new Random().nextInt());
                write(writeLock, new Random().nextInt());
            }
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }

        for (int j = 0; j < 2; j++) {
            new Thread(writeRunnable).start();
        }
    }
}
