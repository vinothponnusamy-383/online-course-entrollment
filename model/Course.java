
package model;

public class Course {
    private String courseId;
    private String courseName;
    private double fee;
    private int capacity;
    private Instructor instructor;

    public Course(String courseId, String courseName, double fee,
                  int capacity, Instructor instructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.fee = fee;
        this.capacity = capacity;
        this.instructor = instructor;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getFee() {
        return fee;
    }

    public int getCapacity() {
        return capacity;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void displayCourse() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Fee: " + fee);
        System.out.println("Capacity: " + capacity);
        System.out.println("Instructor: " + instructor.getName());
    }
}
