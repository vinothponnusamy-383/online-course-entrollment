
package model;

public class Receipt {
    private String receiptId;
    private Payment payment;
    private String studentName;
    private String courseName;

    public Receipt(String receiptId, Payment payment,
                   String studentName, String courseName) {
        this.receiptId = receiptId;
        this.payment = payment;
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void displayReceipt() {
        System.out.println("\n========== PAYMENT RECEIPT ==========");
        System.out.println("Receipt ID: " + receiptId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Payment ID: " + payment.getPaymentId());
        System.out.println("Amount Paid: " + payment.getAmount());
        System.out.println("Payment Method: " + payment.getPaymentMethod());
        System.out.println("Payment Status: " + payment.getStatus());
        System.out.println("=====================================");
    }
}
