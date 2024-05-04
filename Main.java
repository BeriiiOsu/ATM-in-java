package ATM;
import java.io.Console;
import java.util.*;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Console console = System.console();
        System.out.print("\033[H\033[2J");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("> ");
        int choice = sc.nextInt();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        switch(choice){
            case 1:
                Register.reg();
                break;
            case 2:
        while(true){
            Scanner accNumSC = new Scanner(System.in);
            Scanner accPINSC = new Scanner(System.in);
            System.out.print("Account Number  : ");
            String accountNumber = accNumSC.next();
            if(accountNumber.length() != 6){
                System.out.println("Please enter the 6 digit of your Account Number.");
                break;
            }
            if(accountNumber.matches("[0-9]*")){
                
        if (console == null) {
            System.out.println("Console is not available.");
            System.exit(1);
        }
        System.out.print("PIN             : ");
        char[] passwordChars = console.readPassword();
        if(passwordChars.length != 4){
            
            System.exit(1);
        }
        String accountPIN = new String(passwordChars);
                if(accountPIN.length() != 4){
                    System.out.println("Password must be 4 characters long");
                    break;
                }
                if(accountPIN.matches("[0-9]*")){
                    Login l = new Login();
                    l.accountLogin(accountNumber, accountPIN);
                    break;
                }else{
                    System.out.println("Invalid PIN");
                }
            }else{
                System.out.println("Invalid Account Number");
            }
            break;
        }
        break;
        case 3:
        System.out.println("Thank you for using our ATM");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
