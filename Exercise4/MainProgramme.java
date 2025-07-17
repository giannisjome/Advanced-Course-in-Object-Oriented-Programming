import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FoliCard card = new FoliCard();
        CardReader reader = new CardReader();
        Scanner scanner = new Scanner(System.in);

        card.loadFunds(20.0);  // preload some funds

        while (true) {
            System.out.println("\n==== Föli Card Menu ====");
            System.out.println("1. Check card");
            System.out.println("2. Purchase ticket");
            System.out.println("3. Load funds");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    reader.readCard(card);
                    break;
                case 2:
                    System.out.println("Ticket options: 1) SINGLE 2) DAY 3) MONTHLY");
                    int ticketChoice = scanner.nextInt();
                    TicketType type = switch (ticketChoice) {
                        case 1 -> TicketType.SINGLE;
                        case 2 -> TicketType.DAY;
                        case 3 -> TicketType.MONTHLY;
                        default -> null;
                    };
                    if (type != null) {
                        reader.offerTicketPurchase(card, type);
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 3:
                    System.out.print("Enter amount to load: ");
                    double amount = scanner.nextDouble();
                    card.loadFunds(amount);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}
