
/*Question 5
Develop a Java program to demonstrate dynamic method dispatch using an online payment
system with computation.Create a base class Payment that accepts an amount and defines a
method to process a payment.
Derive three subclasses — CreditCardPayment, UPIPayment, and NetBankingPayment —
each overriding the processing method to apply different transaction fees:
    Credit Card payments add a 2% service charge,
    UPI payments add a flat ₹5 charge,
    Net Banking payments apply a 1.5% service fee.
In the main program, input the payment amount and allow the user to choose a payment
method.
Use a base-class reference to point to different subclass objects at runtime, and invoke
the overridden method to calculate and display the final payable amount, demonstrating
runtime polymorphism.
*/

import java.util.Scanner;

class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    void processPayment() {
        System.out.println("Final payable amount: Rs. " + amount);
    }
}

class CreditCardPayment extends Payment {
    CreditCardPayment(double amount) {
        super(amount);
    }

    void processPayment() {
        double total = amount + amount * 0.02;
        System.out.println("Credit Card Payment");
        System.out.println("Final payable amount: Rs. " + total);
    }
}

class UPIPayment extends Payment {
    UPIPayment(double amount) {
        super(amount);
    }

    void processPayment() {
        double total = amount + 5;
        System.out.println("UPI Payment");
        System.out.println("Final payable amount: Rs. " + total);
    }
}

class NetBankingPayment extends Payment {
    NetBankingPayment(double amount) {
        super(amount);
    }

    void processPayment() {
        double total = amount + amount * 0.015;
        System.out.println("Net Banking Payment");
        System.out.println("Final payable amount: Rs. " + total);
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter payment amount: ");
        double amount = sc.nextDouble();

        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Net Banking");
        System.out.print("Choose payment method: ");
        int choice = sc.nextInt();

        Payment p;

        switch (choice) {
            case 1:
                p = new CreditCardPayment(amount);
                break;
            case 2:
                p = new UPIPayment(amount);
                break;
            case 3:
                p = new NetBankingPayment(amount);
                break;
            default:
                System.out.println("Invalid payment method");
                sc.close();
                return;
        }

        p.processPayment();

        sc.close();
    }
}
