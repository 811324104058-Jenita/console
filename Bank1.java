import java.util.*;

class Account {
    private int accNo;
    private String name;
    private double balance;
    private ArrayList<String> transactions = new ArrayList<>();

    public Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
        transactions.add("Account Created | Balance: " + balance);
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

    public ArrayList<String> getTransactions() {
        return transactions;
    }
}

class Services {

    LinkedHashMap<Integer, Account> accounts = new LinkedHashMap<>();
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

        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Deposit Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        Account acc = accounts.get(accNo);
        acc.setBalance(acc.getBalance() + amount);

        acc.getTransactions().add(
            "Deposited: " + amount + " | Balance: " + acc.getBalance()
        );

        System.out.println("Amount Deposited Successfully.");
        System.out.println("Current Balance: " + acc.getBalance());
    }

    public void withdraw() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found.");
            return;
        }

        System.out.print("Enter Withdraw Amount: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid Amount.");
            return;
        }

        Account acc = accounts.get(accNo);

        if (amount > acc.getBalance()) {
            System.out.println("Insufficient Balance.");
            return;
        }

        acc.setBalance(acc.getBalance() - amount);

        acc.getTransactions().add(
            "Withdrawn: " + amount + " | Balance: " + acc.getBalance()
        );

        System.out.println("Amount Withdrawn Successfully.");
        System.out.println("Current Balance: " + acc.getBalance());
    }

    public void checkBalance() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found.");
            return;
        }

        Account acc = accounts.get(accNo);

        System.out.println("Account Number: " + acc.getAccNo());
        System.out.println("Account Holder: " + acc.getName());
        System.out.println("Current Balance: " + acc.getBalance());
    }

    public void miniStatement() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found.");
            return;
        }

        Account acc = accounts.get(accNo);

        System.out.println("\n--------MINI STATEMENT-------------");
        System.out.println("Account Number: " + acc.getAccNo());
        System.out.println("Account Holder: " + acc.getName());

        System.out.println("\nTransactions:");

        for (String transaction : acc.getTransactions()) {
            System.out.println(transaction);
        }

        System.out.println("\nAvailable Balance: " + acc.getBalance());
        System.out.println("----------------------------");
    }
}

public class Bank1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Services op = new Services();

        int ch;

        do {
            System.out.println("\n-------- MENU---------");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Mini Statement");
            System.out.println("6. Exit");

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
                    op.miniStatement();
                    break;

                case 6:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (ch != 6);
    }
}