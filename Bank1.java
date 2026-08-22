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
}
class Services {
    TreeMap<Integer, Account> accounts = new TreeMap<>();
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
}
public class Bank1 {
    public static void main(String[] args) {
        Services op = new Services();
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.print("--------MENU--------");
            System.out.println("\n1. Create Account");
            System.out.println("2. Exit");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    op.createAccount();
                    break;
                case 2:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (ch != 2);
    }
}