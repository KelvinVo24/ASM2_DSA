import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudent(String id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void deleteStudent(String id) {
        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (!removed) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void sortStudentsByMarks() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() < students.get(j + 1).getMarks()) {
                    // Swap students[j+1] and students[j]
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    public Student searchStudentById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null); // Student not found
    }

    public List<Student> searchStudentByName(String name) {
        return students.stream()
                .filter(student -> student.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList()); // Return list of matched students
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}