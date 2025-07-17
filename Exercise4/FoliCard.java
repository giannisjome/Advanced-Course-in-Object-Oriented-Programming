public class FoliCard {
    private double balance;
    private Ticket currentTicket;

    public FoliCard() {
        this.balance = 0.0;
        this.currentTicket = null;
    }

    public void loadFunds(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Funds loaded: €" + amount);
        }
    }

    public boolean hasValidTicket() {
        return currentTicket != null && currentTicket.isValid();
    }

    public Ticket getCurrentTicket() {
        return currentTicket;
    }

    public boolean purchaseTicket(TicketType type) {
        if (hasValidTicket()) {
            System.out.println("Ticket still valid. No need to purchase.");
            return false;
        }

        if (balance >= type.price) {
            balance -= type.price;
            currentTicket = new Ticket(type);
            System.out.println(type.name() + " ticket purchased. Valid until: " + new java.util.Date(currentTicket.getExpirationTime()));
            return true;
        } else {
            System.out.println("Insufficient balance. Please load more funds.");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }
}
