import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Human {
    protected String firstName;
    protected String lastName;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}

class Student extends Human {
//     student number (5-10 digits/ letters).
    protected String studentNum;

    public Student(String firstName, String lastName, String studentNum) {
        // must call parent class constructor
        super(firstName, lastName);
        this.studentNum = studentNum;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public String toString() {
        // override toString method for ease of use
        return "Name: " + firstName + " " + lastName + "\nStudent number: " + studentNum;
    }

    public int compareTo(Student o) {
        return getStudentNum().compareTo(o.getStudentNum());
    }
}

class Worker extends Human {
//     fields WeekSalary and WorkHoursPerDay
//     MoneyPerHour() that returns the pay earned by hour
    protected float weekSalary;
    protected float workHoursPerDay;

    public Worker(String firstName, String lastName, float weekSalary, float workHoursPerDay) {
        // must call parent class constructor
        super(firstName, lastName);
        this.weekSalary = weekSalary;
        this.workHoursPerDay = workHoursPerDay;
    }

    public float moneyPerHour(){
        // assuming workers work 5 days a week
        float totalHours = workHoursPerDay * 5;
        return weekSalary/totalHours;
    }

    public String toString() {
        // override toString method for ease of use
        return "Name: " + firstName + " " + lastName + "\nPayment Per Hour: " + moneyPerHour();
    }
}

class App {
    public static void main(String[] args) {
        Student[] students = new Student[10];
        List<Worker> workers = new ArrayList<Worker>();

        students[0] = new Student("Tom", "Sawyer", "9209TS93");
        students[1] = new Student("John", "Siegal", "9209JS63");
        students[2] = new Student("Sally", "Stevens", "9209SS92");
        students[3] = new Student("Steve", "Heslop", "9209SH19");
        students[4] = new Student("Jesse", "Adams", "9209JA64");
        students[5] = new Student("Raquel", "Corona", "9209RC31");
        students[6] = new Student("Jos", "Williams", "9209JW13");
        students[7] = new Student("Wendy", "Brown", "9209WB42");
        students[8] = new Student("Michael", "Martinez", "9209MM00");
        students[9] = new Student("Gideon", "Chapel", "9209GC09");

        workers.add(new Worker("Tom", "Sawyer", 1200, 8));
        workers.add(new Worker("John", "Siegal", 1670, 6));
        workers.add(new Worker("Sally", "Stevens", 1500, 7));
        workers.add(new Worker("Steve", "Heslop", 1200, 6.5f));
        workers.add(new Worker("Jesse", "Adams", 1100, 5.5f));
        workers.add(new Worker("Raquel", "Corona", 800, 4));
        workers.add(new Worker("Jos", "Williams", 1440, 8));
        workers.add(new Worker("Wendy", "Brown", 1300, 8));
        workers.add(new Worker("Michael", "Martinez", 2400, 9));
        workers.add(new Worker("Gideon", "Chapel", 1800, 9));
//        Initialize an array of 10 students and sort them by student number in ascending order
//        Initialize a list of 10 workers and sort them by payment per hour in descending order

        sort(students);
        print(students);
        sort(workers);
        print(workers);
    }
    public static void sort(List<Worker> workers){
        workers.sort(Comparator.comparing(Worker::moneyPerHour));
    }

    public static void sort(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            for (int j = i+ 1; j < students.length; j++) {
                if (students[i].compareTo(students[j]) > 0) {
                    // temp used to store student object for swap
                    Student temp = students[j];
                    students[j] = students[i];
                    students[i] = temp;
                }
            }
        }
    }

    public static void print(Student[] students) {
        System.out.println("Students:");
        // Print students by student number in ascending order
        for (int i = 0; i < 10; i++) {
            System.out.println(students[i].toString());
        }
    }

    public static void print(List<Worker> workers) {
        System.out.println("Workers:\n");
        // Print workers by payment per hour in descending order
        for (int i = 9; i >= 0; i--) {
            System.out.println(workers.get(i).toString());
        }
    }
}