package task_2;

public class Library {
    static int STUDENTS = 7;
    static Book[] LIBRARYTOHOME = new Book[16];
    static Book[] LIBRARYTOREADROOM = new Book[21];

    public static void main(String[] args) {
        Student[] students = new Student[STUDENTS];

        for(int i=0;i<16;i++)
            LIBRARYTOHOME[i] = new Book(i,'H');
        for(int i=0;i<21;i++)
            LIBRARYTOREADROOM[i] = new Book(i,'R');

        for (int i=0; i<STUDENTS;i++)
            students[i] = new Student(i);
    }
}
