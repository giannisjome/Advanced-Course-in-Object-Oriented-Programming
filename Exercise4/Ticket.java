public class Ticket {
    private final long purchaseTimeMillis;
    private final long validityPeriodMillis;
    private final TicketType type;

    public Ticket(TicketType type) {
        this.purchaseTimeMillis = System.currentTimeMillis();
        this.validityPeriodMillis = type.validityMillis;
        this.type = type;
    }

    public boolean isValid() {
        return System.currentTimeMillis() < purchaseTimeMillis + validityPeriodMillis;
    }

    public TicketType getType() {
        return type;
    }

    public long getExpirationTime() {
        return purchaseTimeMillis + validityPeriodMillis;
    }
}
