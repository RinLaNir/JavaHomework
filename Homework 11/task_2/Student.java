package task_2;

import java.util.concurrent.ThreadLocalRandom;

public class Student extends Thread{

    private int id;

    public Student(){
    }
    public Student(int id){
        this.id = id;
        start();
    }

    public void reading(int state) throws InterruptedException {
        while (true){
            if (state == 0){
                int bookID = ThreadLocalRandom.current().nextInt(Library.LIBRARYTOHOME.length);
                Book book = Library.LIBRARYTOHOME[bookID];
                if (book.take()){
                    book.read(this);
                    return;
                }
            }
            else {
                int bookID = ThreadLocalRandom.current().nextInt(Library.LIBRARYTOREADROOM.length);
                Book book = Library.LIBRARYTOREADROOM[bookID];
                if (book.take()) {
                    book.read(this);
                    return;
                }
            }
        }
    }

    @Override
    public void run() {
        while (true){

            int state = ThreadLocalRandom.current().nextInt(2);
            int numberOfBooks = ThreadLocalRandom.current().nextInt(1,3+1);
            if (state == 0)
                System.out.println(this + " go to read at home");
            else
                System.out.println(this + " go to read in the reading room");
            for (int i=1;i<=numberOfBooks;i++){
                try {
                    this.reading(state);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Student №" + id;
    }
}
