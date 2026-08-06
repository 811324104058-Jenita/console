import java.util.*;

class Account {
    private int accNo;
    private String name;
    private double balance;

    public Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class Services {

    HashMap<Integer, Account> accounts = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void createAccount() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (accounts.containsKey(accNo)) {
            System.out.println("Account already exists.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account acc = new Account(accNo, name, balance);
        accounts.put(accNo, acc);

        System.out.println("Account Created Successfully.");
    }

    public void deposit() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        acc.setBalance(acc.getBalance() + amount);

        System.out.println("Amount Deposited Successfully.");
        System.out.println("Current Balance: " + acc.getBalance());
    }

    public void withdraw() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        if (amount > acc.getBalance()) {
            System.out.println("Insufficient Balance.");
            return;
        }

        acc.setBalance(acc.getBalance() - amount);

        System.out.println("Amount Withdrawn Successfully.");
        System.out.println("Current Balance: " + acc.getBalance());
    }

    public void checkBalance() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        Account acc = accounts.get(accNo);

        if (acc == null) {
            System.out.println("Account Not Found.");
            return;
        }

        System.out.println("Account Holder: " + acc.getName());
        System.out.println("Current Balance: " + acc.getBalance());
    }
}

public class Bank1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Services op = new Services();

        int ch;

        do {

            System.out.println("\n------ MENU ------");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    op.createAccount();
                    break;

                case 2:
                    op.deposit();
                    break;

                case 3:
                    op.withdraw();
                    break;

                case 4:
                    op.checkBalance();
                    break;

                case 5:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (ch != 5);
    }
}