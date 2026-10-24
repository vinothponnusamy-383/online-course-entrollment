
package model;

public class Instructor {
    private String instructorId;
    private String name;
    private String specialization;

    public Instructor(String instructorId, String name, String specialization) {
        this.instructorId = instructorId;
        this.name = name;
        this.specialization = specialization;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void displayInstructor() {
        System.out.println("Instructor ID: " + instructorId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}
