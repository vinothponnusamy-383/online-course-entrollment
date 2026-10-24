
package service;

import model.Course;
import model.Enrollment;
import model.Student;
import exception.CourseFullException;
import java.util.ArrayList;

public class EnrollmentService {
    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public boolean enrollStudent(String enrollmentId, Student student,
                                 Course course, String enrollmentDate) {
        try {
            checkCourseCapacity(course);

            Enrollment enrollment = new Enrollment(
                enrollmentId, student, course, enrollmentDate
            );

            enrollments.add(enrollment);
            course.setCapacity(course.getCapacity() - 1);

            System.out.println("Student enrolled successfully!");
            return true;

        } catch (CourseFullException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void checkCourseCapacity(Course course)
            throws CourseFullException {
        if (course.getCapacity() <= 0) {
            throw new CourseFullException("Course is full!");
        }
    }

    public void displayAllEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }

        for (Enrollment enrollment : enrollments) {
            enrollment.displayEnrollment();
            System.out.println("--------------------");
        }
    }
}
