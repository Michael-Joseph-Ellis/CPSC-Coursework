public class HelloWorld {

    public static void printGreeting() {
        String name = "Michael";
        System.out.println("Hello, " + name + "!");
    }

    public static void printNameMessage() {
        String name = "Michael";
        System.out.println("My name is " + name + ".");
    }

    public static void printAge() {
        int age = 25; 
        System.out.println("I am " + age + " years old.");
    }

    public static void printHeight() {
        float height = 5.9f; 
        System.out.println("I am " + height + " feet tall.");
    }

    public static void printGPA() {
        double gpa = 3.75; 
        System.out.println("My GPA is " + gpa + ".");
    }

    public static void printInitial() {
        char initial = 'M'; 
        System.out.println("My initial is " + initial + ".");
    }

    public static void printIsStudent() {
        boolean isStudent = true; 
        System.out.println("Am I a student? " + isStudent);
    }

    public static void main(String[] args) {
        printGreeting();
        printNameMessage();
        printAge();
        printHeight();
        printGPA();
        printInitial();
        printIsStudent();
    }
}
