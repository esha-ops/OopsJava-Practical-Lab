
package services;

public class Interest {
    private final double rate = 5.0;

    public double calculateUpdatedBalance(double balance) {
        return balance + (balance * rate / 100);
    }
}
