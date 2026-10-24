
package model;

public class Payment {
    private String paymentId;
    private String enrollmentId;
    private double amount;
    private String paymentDate;
    private String paymentMethod;
    private String status;

    public Payment(String paymentId, String enrollmentId, double amount,
                   String paymentDate, String paymentMethod) {
        this.paymentId = paymentId;
        this.enrollmentId = enrollmentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = "Successful";
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayPayment() {
        System.out.println("Payment ID: " + paymentId);
        System.out.println("Enrollment ID: " + enrollmentId);
        System.out.println("Amount: " + amount);
        System.out.println("Payment Date: " + paymentDate);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Status: " + status);
    }
}
