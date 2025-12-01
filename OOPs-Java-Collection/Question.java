import java.util.*;

class Question {
    int id;
    String text;

    Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return id + ". " + text;
    }
}

class Student {
    String studentId;
    String name;

    Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + studentId + ")";
    }
}

public class OnlineExamManagementSystem {
    public static void main(String[] args) {
        Set<String> studentIds = new HashSet<>();
        Queue<Student> examQueue = new LinkedList<>();

        Student s1 = new Student("S101", "Alice");
        Student s2 = new Student("S102", "Bob");
        Student s3 = new Student("S101", "Alice Duplicate");

        enrollStudent(studentIds, examQueue, s1);
        enrollStudent(studentIds, examQueue, s2);
        enrollStudent(studentIds, examQueue, s3);

        System.out.println("Enrolled Students:");
        examQueue.forEach(System.out::println);

        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question(1, "What is Java?"));
        questionList.add(new Question(2, "Explain polymorphism."));
        questionList.add(new Question(3, "What is encapsulation?"));
        questionList.add(new Question(4, "Difference between abstract class and interface?"));
        questionList.add(new Question(5, "What is JVM?"));

        Collections.shuffle(questionList);
        System.out.println("\nExam Questions (Randomized):");
        questionList.forEach(System.out::println);

        System.out.println("\nServing Students:");
        while (!examQueue.isEmpty()) {
            Student current = examQueue.poll();
            System.out.println("\nNow serving: " + current);
            takeExam(questionList);
        }
    }

    static void enrollStudent(Set<String> ids, Queue<Student> queue, Student student) {
        if (ids.add(student.studentId)) {
            queue.add(student);
        }
    }

    static void takeExam(List<Question> questions) {
        Stack<Question> stack = new Stack<>();
        for (Question q : questions) {
            stack.push(q);
            System.out.println("Current Question: " + q);
        }
        System.out.println("Navigating backward:");
        while (!stack.isEmpty()) {
            System.out.println("Previous Question: " + stack.pop());
        }
    }
}
