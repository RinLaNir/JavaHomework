package task_2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private final int id;
    private final Lock lock;
    private final char type;

    public Book(int id, char type){
        this.id = id;
        this.lock = new ReentrantLock();
        this.type = type;
    }

    public boolean take(){
        return lock.tryLock();
    }

    public void read(Student student) throws InterruptedException {
        lock.tryLock(30, TimeUnit.MILLISECONDS);
        System.out.println(student + " start reading " + this);
        Student.sleep(ThreadLocalRandom.current().nextInt(5000,10000+1));
        lock.unlock();
        System.out.println(student + " has finished reading " + this);
    }

    @Override
    public String toString() {
        return "Book №" + id + type;
    }
}
