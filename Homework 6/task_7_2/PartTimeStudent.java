package task_7_2;

public class PartTimeStudent extends Student{


    public PartTimeStudent(String name) {
        super(name);
    }

    @Override
    public void setName() {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void doHomework() {
        this.homework = true;
    }

    @Override
    public boolean getHomework() {
        return this.homework;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        PartTimeStudent student = new PartTimeStudent("Nikita");
        System.out.println("Step 1: " + student);
        student.doHomework();
        System.out.println("Step 2: " + student);
    }
}
