
package model;

public class Enrollment {
    private String enrollmentId;
    private Student student;
    private Course course;
    private String enrollmentDate;
    private String status;

    public Enrollment(String enrollmentId, Student student, Course course,
                      String enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.status = "Pending Payment";
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayEnrollment() {
        System.out.println("Enrollment ID: " + enrollmentId);
        System.out.println("Student: " + student.getName());
        System.out.println("Course: " + course.getCourseName());
        System.out.println("Enrollment Date: " + enrollmentDate);
        System.out.println("Status: " + status);
    }
}
