package FeesManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private double totalFeesPaid;

    public Student(String studentId, String name, double totalFeesPaid) {
        this.studentId = studentId;
        this.name = name;
        this.totalFeesPaid = totalFeesPaid;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getTotalFeesPaid() {
        return totalFeesPaid;
    }

    public void payFees(double feesPaid) {
        totalFeesPaid += feesPaid;
    }

    public double getRemainingFees(double totalFees) {
        return totalFees - totalFeesPaid;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Total Fees Paid: $" + totalFeesPaid;
    }
}

class FeesManagementSystem {
    private List<Student> students;

    public FeesManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String studentId, String name, double totalFeesPaid) {
        students.add(new Student(studentId, name, totalFeesPaid));
    }

    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void recordPayment(String studentId, double feesPaid) {
        Student student = findStudent(studentId);
        if (student != null) {
            student.payFees(feesPaid);
            System.out.println("Payment recorded successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudentInfo(String studentId) {
        Student student = findStudent(studentId);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        FeesManagementSystem system = new FeesManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Fees Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Record Payment");
            System.out.println("3. Display Student Info");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Total Fees Paid: ");
                    double totalFeesPaid = scanner.nextDouble();
                    system.addStudent(studentId, name, totalFeesPaid);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    System.out.print("Enter Payment Amount: ");
                    double paymentAmount = scanner.nextDouble();
                    system.recordPayment(studentId, paymentAmount);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    system.displayStudentInfo(studentId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
