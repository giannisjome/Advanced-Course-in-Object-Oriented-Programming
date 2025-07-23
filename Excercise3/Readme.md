# 🏦 Duckburg Bank Mortgage Calculator (Java CLI Prototype)

This is a command-line prototype of a **mortgage installment calculator** for Duckburg Bank. It calculates the **monthly installment** based on the **loan principal** and **loan term** in months, using a simplified formula.

> This prototype is intended for eventual integration into a web-based version.

---

## Formula Used

For simplicity, the monthly installment is calculated using the following formula:

monthly_installment = principal / loan_term + principal / 240


>  The loan term must be between **1 and 300** months.  
> If the loan term is `0`, an error is shown to avoid division by zero.

---

## Features

- Command-line interaction for user input.
- Input validation for principal and loan term.
- Clear separation of concerns using **method-level abstraction**.
- Designed for future **object-oriented expansion**.
- Easily extendable to support Euribor-based calculations.

---

##  Methods

| Method Name                         | Purpose                                                                 |
|------------------------------------|-------------------------------------------------------------------------|
| `main(String[] args)`              | Orchestrates the entire program                                         |
| `calculateMonthlyInstallment(...)` | Calculates the monthly installment using the fixed formula              |
| `isValidPrincipal(...)`            | Validates that the principal is a positive number                       |
| `isValidLoanTerm(...)`             | Ensures the loan term is within the allowed range (1–300 months)        |
| `promptForPrincipal(...)`         | Prompts the user for valid principal input                              |
| `promptForLoanTerm(...)`          | Prompts the user for valid loan term input                              |
| `displayMonthlyInstallment(...)`   | Outputs the result in a clear, formatted way                            |

---





