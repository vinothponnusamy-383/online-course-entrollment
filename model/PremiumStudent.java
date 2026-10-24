
package model;

public class PremiumStudent extends Student {
    private double discount;

    public PremiumStudent(String studentId, String name, String email,
                          double discount) {
        super(studentId, name, email);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double calculateFee(double originalFee) {
        return originalFee - (originalFee * discount / 100);
    }

    public void displayPremiumStudent() {
        displayStudent();
        System.out.println("Discount: " + discount + "%");
    }
}
