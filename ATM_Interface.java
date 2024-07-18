import java.util.Scanner;
class UserBankAccount{
    private double bankBalance;
    public UserBankAccount(double initialAccountBalance){
        this.bankBalance = initialAccountBalance;
    }
    public double balanceEnquiry(){
        return bankBalance;
    }
    public void withdrawMoney(double amountToWithdraw){
        if(amountToWithdraw > 0 && bankBalance >= amountToWithdraw){
            bankBalance = bankBalance - amountToWithdraw;
            System.out.println(amountToWithdraw + " withdrawn from you bank account successfully.");
            System.out.println("Your current account balance: $" + bankBalance);
            System.out.println("-------------------------------------------");
        }
        else{
            System.out.println("Insufficient balance.");
            System.out.println("-------------------------------------------");
        }
    }
    public void depositMoney(double amountToDeposit){
        if(amountToDeposit > 0){
            bankBalance = bankBalance + amountToDeposit;
            System.out.println(amountToDeposit + " deposited successfully.");
            System.out.println("Your current account balance: $" + bankBalance);
            System.out.println("-------------------------------------------");
        }
    }
}
class ATM{
    private  UserBankAccount userBankAccount;
    public ATM(UserBankAccount userBankAccount){
        this.userBankAccount = userBankAccount;
    }
    public void displayTheChoices(){
        System.out.println("-------------------------------------------");
        System.out.println("    WELCOME TO THE ATM  ");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("    MENU    ");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("    1. Check your bank account balance.    ");
        System.out.println("    2. Deposit money in your bank account.     ");
        System.out.println("    3. Withdraw money from your bank account.    ");
        System.out.println("    4. Exit.    ");
    }
    public void performOperation(int yourChoice, Scanner sc){
        switch (yourChoice){
            case 1:
                System.out.println("-------------------------------------------");
                System.out.println("Your current bank account balance is: $" + userBankAccount.balanceEnquiry());
                break;
            case 2:
                System.out.println("-------------------------------------------");
                System.out.print("Enter the amount you want to deposit in your bank account: $");
                double DepositAmount = sc.nextDouble();
                userBankAccount.depositMoney(DepositAmount);
                break;
            case 3:
                System.out.println("-------------------------------------------");
                System.out.print("Enter the amount you want to withdraw from your bank account: $");
                double WithdrawAmount = sc.nextDouble();
                userBankAccount.withdrawMoney(WithdrawAmount);
                break;
            case 4:
                System.out.println("-------------------------------------------");
                System.out.println("Exiting ATM. Thank You! Visit Again.");
                System.exit(0);
            default:System.out.println("-------------------------------------------");
                System.out.println("Invalid choice. Please select a valid option.");
        }
        if(yourChoice != 1 && yourChoice != 4) {
            System.out.print("Do you want the receipt?(yes/no): ");
            String receipt = sc.next();
            if (receipt.equalsIgnoreCase("yes")) {
                System.out.println("Collect your receipt.");
                System.out.println("-------------------------------------------");
            }
            else{
                System.out.println("-------------------------------------------");
            }
        }
    }
}
public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the initial bank balance: $");
        double initialBankBalance = sc.nextDouble();
        UserBankAccount userBankAccount = new UserBankAccount(initialBankBalance);
        ATM atm = new ATM(userBankAccount);
        boolean continueToUse = true;
        while (continueToUse){
            atm.displayTheChoices();
            System.out.println("-------------------------------------------");
            System.out.print("Select the operation you want to perform by choosing the corresponding option: ");
            int option = sc.nextInt();
            atm.performOperation(option, sc);
            System.out.println("Do you want to continue? (yes/no)");
            String cont = sc.next();
            if(!cont.equalsIgnoreCase("yes")){
                continueToUse = false;
                System.out.println("Exiting ATM. Thank You! Visit Again.");
                System.out.println("-------------------------------------------");
            }
        }
    }
}
