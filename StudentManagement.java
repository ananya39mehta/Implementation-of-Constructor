package Assignment_3;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentManagement system = new StudentManagement();
        system.showMenu();
    }
    public void showMenu() {
        int choice;
        do {
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudents();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);
    }

    private void addStudent() {
        System.out.print("Enter PRN: ");
        String prn = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth: ");
        String dob = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character
        Student student = new Student(prn, name, dob, marks);
        students.add(student);
        System.out.println("Student added successfully!");
    }
    private void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println("PRN: " + student.getPrn());
                System.out.println("Name: " + student.getName());
                System.out.println("Date of Birth: " + student.getDob());
                System.out.println("Marks: " + student.getMarks());
                System.out.println("--------------------");
            }
        }
    }
    private void searchStudents() {
        System.out.println("1. Search by PRN");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Position");
        System.out.print("Enter your choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        switch (searchChoice) {
            case 1:
                System.out.print("Enter PRN to search: ");
                String prnSearch = scanner.nextLine();
                boolean foundByPRN = false;
                for (Student student : students) {
                    if (student.getPrn().equalsIgnoreCase(prnSearch)) {
                        displayStudentDetails(student);
                        foundByPRN = true;
                        break;
                    }
                }
                if (!foundByPRN) {
                    System.out.println("Student with PRN " + prnSearch + " not found.");

                }
                break;
            case 2:
                System.out.print("Enter Name to search: ");
                String nameSearch = scanner.nextLine();
                boolean foundByName = false;
                for (Student student : students) {
                    if (student.getName().equalsIgnoreCase(nameSearch)) {
                        displayStudentDetails(student);
                        foundByName = true;
                        break;
                    }
                }
                if (!foundByName) {
                    System.out.println("Student with Name " + nameSearch + " not found.");
                }
                break;
            case 3:
                System.out.print("Enter position to search: ");
                int position = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                if (position >= 0 && position < students.size()) {
                    displayStudentDetails(students.get(position));
                } else {
                    System.out.println("Invalid position.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    private void displayStudentDetails(Student student) {
        System.out.println("PRN: " + student.getPrn());
        System.out.println("Name: " + student.getName());
        System.out.println("Date of Birth: " + student.getDob());
        System.out.println("Marks: " + student.getMarks());
        System.out.println("--------------------");
    }
    private void updateStudent() {
        System.out.print("Enter PRN of student to update: ");
        String prn = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getPrn().equalsIgnoreCase(prn)) {
                System.out.print("Enter new Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new Date of Birth: ");
                String dob = scanner.nextLine();

                System.out.print("Enter new Marks: ");
                double marks = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                student.setName(name);
                student.setDob(dob);
                student.setMarks(marks);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with PRN " + prn + " not found.");
        }
    }
    private void deleteStudent() {
        System.out.print("Enter PRN of student to delete: ");
        String prn = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getPrn().equalsIgnoreCase(prn)) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with PRN " + prn + " not found.");
        }
    }
}