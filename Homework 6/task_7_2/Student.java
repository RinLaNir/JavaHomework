package task_7_2;

abstract class Student implements Abiturient{
    protected String name = null;
    protected boolean homework = false;

    public Student(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", homework=" + homework +
                '}';
    }
}
