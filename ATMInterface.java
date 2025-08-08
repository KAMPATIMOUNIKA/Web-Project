import java.util.Scanner;

// Bank Account class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited: ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("✅ Withdrawn: ₹" + amount);
        }
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }
}

// ATM Machine class
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option;
        do {
            System.out.println("\n=== 🏧 ATM Menu ===");
            System.out.println("1. 💵 Deposit");
            System.out.println("2. 🏦 Withdraw");
            System.out.println("3. 📋 Check Balance");
            System.out.println("4. ❌ Exit");
            System.out.print("Choose an option (1-4): ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("👋 Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("⚠️ Invalid option. Please choose 1-4.");
            }
        } while (option != 4);
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000);  // Initial balance ₹1000
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}
