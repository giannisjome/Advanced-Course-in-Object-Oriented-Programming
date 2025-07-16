import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double principal = getPrincipalFromUser(scanner);
        int loanTerm = getLoanTermFromUser(scanner);

        if (loanTerm == 0) {
            printErrorMessage("Loan term cannot be 0 months. Please try again.");
            return;
        }

        double installment = calculateInstallment(principal, loanTerm);
        printMonthlyInstallment(installment);
    }

    public static double getPrincipalFromUser(Scanner scanner) {
        double principal = -1;
        while (principal <= 0) {
            System.out.print("Enter the principal amount: ");
            try {
                principal = Double.parseDouble(scanner.nextLine());
                if (principal <= 0) {
                    printErrorMessage("Principal must be a positive number.");
                }
            } catch (NumberFormatException e) {
                printErrorMessage("Invalid input. Please enter a numeric value.");
            }
        }
        return principal;
    }

    public static int getLoanTermFromUser(Scanner scanner) {
        int loanTerm = -1;
        while (loanTerm < 1 || loanTerm > 300) {
            System.out.print("Enter the loan term in months (1–300): ");
            try {
                loanTerm = Integer.parseInt(scanner.nextLine());
                if (loanTerm < 1 || loanTerm > 300) {
                    printErrorMessage("Loan term must be between 1 and 300 months.");
                }
            } catch (NumberFormatException e) {
                printErrorMessage("Invalid input. Please enter an integer value.");
            }
        }
        return loanTerm;
    }

    public static double calculateInstallment(double principal, int loanTerm) {
        return (principal / loanTerm) + (principal / 240);
    }

    public static void printMonthlyInstallment(double installment) {
        System.out.printf("Monthly Installment: €%.2f%n", installment);
    }

    public static void printErrorMessage(String message) {
        System.out.println("Error: " + message);
    }
}
