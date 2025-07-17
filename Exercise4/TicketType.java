public enum TicketType {
    SINGLE(3.0, 1000L * 60 * 60 * 2),        // 2 hours
    DAY(8.0, 1000L * 60 * 60 * 24),          // 24 hours
    MONTHLY(55.0, 1000L * 60 * 60 * 24 * 30); // 30 days

    public final double price;
    public final long validityMillis;

    TicketType(double price, long validityMillis) {
        this.price = price;
        this.validityMillis = validityMillis;
    }
}
