
package service;

import model.Payment;
import model.Receipt;
import model.Enrollment;
import java.util.ArrayList;

public class PaymentService {
    private ArrayList<Payment> payments = new ArrayList<>();

    public Receipt processPayment(String paymentId, Enrollment enrollment,
                                  double amount, String paymentDate,
                                  String paymentMethod) {
        if (amount <= 0) {
            System.out.println("Invalid payment amount!");
            return null;
        }

        Payment payment = new Payment(
            paymentId,
            enrollment.getEnrollmentId(),
            amount,
            paymentDate,
            paymentMethod
        );

        payments.add(payment);

        Receipt receipt = new Receipt(
            "R-" + paymentId,
            payment,
            enrollment.getStudent().getName(),
            enrollment.getCourse().getCourseName()
        );

        System.out.println("Payment processed successfully!");
        return receipt;
    }

    public void displayAllPayments() {
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        for (Payment payment : payments) {
            payment.displayPayment();
            System.out.println("--------------------");
        }
    }
}
