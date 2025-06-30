import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account{
	private String accountNo;
	private String accountName;
	private double balance;
	private List<String> transactionhistory;
	
	public Account(String accountNo, String accountName, double initialBalance) {
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.balance = initialBalance;
		this.transactionhistory = new ArrayList<>();
	}
	
	public void deposite(double amount) {
		if(amount > 0) {
			balance += amount;
			transactionhistory.add("Deposited : rs "+ amount + " | New Balance : rs " + balance);
		}else
			System.out.println("Invalid deposite amount.");
	}
	
	public void withdraw(double amount) {
		if(amount > 0 && amount <= balance) {
			balance -= amount;
			transactionhistory.add("Withdraw : rs " + amount + "| New balance : rs " + balance);
		}else
			System.out.println("Insufficient balance or invalid amount");
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void printTransactionHistory() {
		System.out.println("\nTransaction History : ");
		for(String transaction : transactionhistory) {
			System.out.println(transaction);
		}
	}
}
public class BankSimulation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter account number : ");
		String accountno = sc.nextLine();
		System.out.print("Enter account holder name : ");
		String name = sc.nextLine();
		System.out.print("Enter intial deposit : Rs ");
		double initialBalance = sc.nextDouble();
		
		Account account = new Account(accountno, name, initialBalance);
		
		int choice;
		do {
			System.out.println("\n--- Bank Menu ---");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. View Transaction History");
			System.out.println("5. Exit");
			System.out.print("Choose an option : ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.print("Enter deposit amount : Rs ");
				double depositAmt = sc.nextDouble();
				account.deposite(depositAmt);
				break;
			case 2:
				System.out.print("Enter withdraw amount : Rs ");
				double withdrawAmt = sc.nextDouble();
				account.withdraw(withdrawAmt);
				break;
			case 3:
				System.out.println("Current Balance : Rs "+ account.getBalance());
				break;
			case 4:
				account.printTransactionHistory();
				break;
			case 5:
				System.out.println("Thankyou for using Bank simulation....");
				break;
			default:
				System.out.println("Invalid option. Try again.");
			}
		}while(choice != 5);
		sc.close();
	}
}

