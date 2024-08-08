import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit student");
            System.out.println("3. Delete student");
            System.out.println("4. Sort students by Marks");
            System.out.println("5. Search student by ID");
            System.out.println("6. Search students by Name");
            System.out.println("7. Display all students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student marks: ");
                    double marks = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    manager.addStudent(new Student(id, name, marks));
                    break;
                case 2:
                    System.out.print("Enter student ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    double newMarks = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    manager.editStudent(editId, newName, newMarks);
                    break;
                case 3:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteStudent(deleteId);
                    break;
                case 4:
                    manager.sortStudentsByMarks();
                    System.out.println("Students sorted by marks.");
                    break;
                case 5:
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student student = manager.searchStudentById(searchId);
                    if (student != null) {
                        System.out.println("Found: " + student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    List<Student> foundStudents = manager.searchStudentByName(searchName);
                    if (!foundStudents.isEmpty()) {
                        System.out.println("Found students:");
                        for (Student s : foundStudents) {
                            System.out.println(s);
                        }
                    } else {
                        System.out.println("No students found.");
                    }
                    break;
                case 7:
                    manager.displayAllStudents();
                    break;
                case 8:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}