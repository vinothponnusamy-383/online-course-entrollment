
package main;

import java.util.Scanner;
import model.Instructor;
import model.Course;
import model.Student;
import model.PremiumStudent;
import model.Enrollment;
import model.Receipt;
import service.EnrollmentService;
import service.PaymentService;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create instructor
        Instructor instructor = new Instructor(
            "I101", "Arun", "Java Programming"
        );

        // Create course
        Course course = new Course(
            "C101", "Java Fundamentals", 2000.0, 2, instructor
        );

        // Create services
        EnrollmentService enrollmentService = new EnrollmentService();
        PaymentService paymentService = new PaymentService();

        int studentCount = 0;
        int enrollmentCount = 0;
        int paymentCount = 0;

        Student[] students = new Student[100];
        Enrollment[] enrollments = new Enrollment[100];

        int choice;

        do {
            System.out.println("\n===== ONLINE COURSE ENROLLMENT SYSTEM =====");
            System.out.println("1. Display Course Details");
            System.out.println("2. Register Regular Student");
            System.out.println("3. Register Premium Student");
            System.out.println("4. Enroll Student");
            System.out.println("5. View All Enrollments");
            System.out.println("6. Process Payment");
            System.out.println("7. View All Payments");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    course.displayCourse();
                    break;

                case 2:
                    if (studentCount >= students.length) {
                        System.out.println("Student storage is full!");
                        break;
                    }

                    System.out.print("Enter student ID: ");
                    String studentId = sc.nextLine();

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter student email: ");
                    String email = sc.nextLine();

                    students[studentCount] = new Student(
                        studentId, name, email
                    );

                    studentCount++;
                    System.out.println("Student registered successfully!");
                    break;

                case 3:
                    if (studentCount >= students.length) {
                        System.out.println("Student storage is full!");
                        break;
                    }

                    System.out.print("Enter student ID: ");
                    String premiumId = sc.nextLine();

                    System.out.print("Enter student name: ");
                    String premiumName = sc.nextLine();

                    System.out.print("Enter student email: ");
                    String premiumEmail = sc.nextLine();

                    System.out.print("Enter discount percentage: ");
                    double discount = sc.nextDouble();
                    sc.nextLine();

                    if (discount < 0 || discount > 100) {
                        System.out.println("Invalid discount!");
                        break;
                    }

                    students[studentCount] = new PremiumStudent(
                        premiumId, premiumName, premiumEmail, discount
                    );

                    studentCount++;
                    System.out.println("Premium student registered successfully!");
                    break;

                case 4:
                    if (enrollmentCount >= enrollments.length) {
                        System.out.println("Enrollment storage is full!");
                        break;
                    }

                    if (studentCount == 0) {
                        System.out.println("Register a student first!");
                        break;
                    }

                    System.out.println("\nRegistered Students:");

                    for (int i = 0; i < studentCount; i++) {
                        System.out.println(
                            students[i].getStudentId() + " - "
                            + students[i].getName()
                        );
                    }

                    System.out.print("Enter student ID to enroll: ");
                    String searchId = sc.nextLine();

                    Student selectedStudent = null;

                    for (int i = 0; i < studentCount; i++) {
                        if (students[i].getStudentId().equals(searchId)) {
                            selectedStudent = students[i];
                            break;
                        }
                    }

                    if (selectedStudent == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    System.out.print("Enter enrollment date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    String enrollmentId = "E" + (enrollmentCount + 101);

                    boolean enrolled = enrollmentService.enrollStudent(
                        enrollmentId, selectedStudent, course, date
                    );

                    if (enrolled) {
                        enrollments[enrollmentCount] = new Enrollment(
                            enrollmentId, selectedStudent, course, date
                        );

                        enrollmentCount++;
                    }
                    break;

                case 5:
                    enrollmentService.displayAllEnrollments();
                    break;

                case 6:
                    if (enrollmentCount == 0) {
                        System.out.println("Enroll a student first!");
                        break;
                    }

                    System.out.println("\nEnrollments:");

                    for (int i = 0; i < enrollmentCount; i++) {
                        System.out.println(
                            enrollments[i].getEnrollmentId() + " - "
                            + enrollments[i].getStudent().getName()
                            + " - " + enrollments[i].getCourse().getCourseName()
                        );
                    }

                    System.out.print("Enter enrollment ID: ");
                    String paymentEnrollmentId = sc.nextLine();

                    Enrollment selectedEnrollment = null;

                    for (int i = 0; i < enrollmentCount; i++) {
                        if (enrollments[i].getEnrollmentId()
                                .equals(paymentEnrollmentId)) {
                            selectedEnrollment = enrollments[i];
                            break;
                        }
                    }

                    if (selectedEnrollment == null) {
                        System.out.println("Enrollment not found!");
                        break;
                    }

                    System.out.print("Enter payment method: ");
                    String method = sc.nextLine();

                    double fee = selectedEnrollment.getCourse().getFee();

                    if (selectedEnrollment.getStudent() instanceof PremiumStudent) {
                        PremiumStudent premium =
                            (PremiumStudent) selectedEnrollment.getStudent();

                        fee = premium.calculateFee(fee);
                    }

                    String paymentId = "P" + (paymentCount + 101);

                    Receipt receipt = paymentService.processPayment(
                        paymentId,
                        selectedEnrollment,
                        fee,
                        "24-10-2026",
                        method
                    );

                    if (receipt != null) {
    paymentCount++;

    selectedEnrollment.setStatus("Confirmed");

    receipt.displayReceipt();
}
                    break;

                case 7:
                    paymentService.displayAllPayments();
                    break;

                case 8:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}
