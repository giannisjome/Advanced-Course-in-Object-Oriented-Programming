// Abstract class defining a generic command-line application behavior
abstract class CommandLineApp {
    // Method to prompt the user and return their input
    String ask(String prompt) {
        System.out.print(prompt + ": ");
        return new java.util.Scanner(System.in).next();
    }
}

// Subclass that inherits the ask() method from CommandLineApp
public class LoginScreen extends CommandLineApp {

    // Lock method simulates a login process
    public void lock() {
        while (true) {
            var id = ask("Username");     // Inherited from CommandLineApp
            var pw = ask("Password");

            // Hardcoded credentials for demo purposes
            if (id.equals("root") && pw.equals("root")) {
                System.out.println("Access granted.");
                return;
            }

            // If credentials are wrong, wait and try again
            try {
                System.out.println("Invalid credentials. Try again in 1 second.");
                Thread.sleep(1000);
            } catch (Exception e) {
                // Ignore interruption errors for simplicity
            }
        }
    }

    // Entry point to run the program
    public static void main(String[] args) {
        new LoginScreen().lock();
    }
}
