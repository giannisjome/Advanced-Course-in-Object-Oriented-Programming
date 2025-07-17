public class CardReader {

    public void readCard(FoliCard card) {
        System.out.println("Reading card...");
        System.out.println("Current balance: €" + card.getBalance());

        if (card.hasValidTicket()) {
            System.out.println("Valid " + card.getCurrentTicket().getType().name().toLowerCase() + " ticket found.");
        } else {
            System.out.println("No valid ticket found. Please purchase one.");
        }
    }

    public void offerTicketPurchase(FoliCard card, TicketType type) {
        System.out.println("Attempting to purchase: " + type.name());
        boolean success = card.purchaseTicket(type);
        if (success) {
            System.out.println("Purchase successful. New balance: €" + card.getBalance());
        }
    }
}
