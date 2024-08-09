import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of students to manage
        System.out.print("Enter the number of students to manage: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            manager.addStudent(new Student(id, name, marks));
        }

        // Display all students after input
        System.out.println("\nList of students:");
        manager.displayAllStudents();



        manager.addStudent(new Student("BD00283", "Vo Van Thanh Binh", 9.5));
        manager.addStudent(new Student("BD00234", "Nguyen Minh Thu", 9.0));
        manager.addStudent(new Student("BD00129", "Le Tien Quan", 5.4));
        manager.addStudent(new Student("BD00291", "Truong Van Khoa", 9.8));
        manager.addStudent(new Student("BD00523", "Tran Duc Tien", 6.8));
        manager.addStudent(new Student("BD00444", "Taylor Swift", 7.5));


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


//        StudentManager manager = new StudentManager();

//        // Test case: Adding students
//        manager.addStudent(new Student("BD00283", "Vo Van Thanh Binh", 8));
//        manager.addStudent(new Student("BD00200", "Le Ha Canh Thuan", 7.0));
//        manager.addStudent(new Student("BD00123", "Nguyen Minh Thu", 9.2));
//        manager.addStudent(new Student("BD00666", "Le Tien Quan", 5.4));
//        manager.addStudent(new Student("BD00523", "Tran Duc Tien", 6.8));
//
//        System.out.println("SE06101 list of students:");
//        manager.displayAllStudents();
//
//        // Test case: Editing a student's information
//        manager.editStudent("BD00283", "Vo Van Thanh Binh", 9.5);
//        System.out.println("\nAfter editing Binh's information:");
//        manager.displayAllStudents();
//
//        // Test case: Deleting a student
//        manager.deleteStudent("BD00666");
//        System.out.println("\nAfter deleting Quan:");
//        manager.displayAllStudents();
//
//        // Test case: Sorting students by marks
//        manager.sortStudentsByMarks();
//        System.out.println("\nAfter sorting by marks:");
//        manager.displayAllStudents();
//
//        // Test case: Searching for a student by ID
//        Student student = manager.searchStudentById("BD00283");
//        System.out.println("\nSearching for student with ID BD00283:");
//        if (student != null) {
//            System.out.println(student);
//        } else {
//            System.out.println("Student not found.");
//        }
//
//        // Test case: Searching for students by name
//        System.out.println("\nSearching for students with name containing 'Binh':");
//        List<Student> studentsByName = manager.searchStudentByName("Bin");
//        for (Student s : studentsByName) {
//            System.out.println(s);
//        }
//    }
//    }