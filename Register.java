package ATM;
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Register {
    public static void reg() throws InterruptedException{
                
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = currentDateTime.format(formatter);
        String fullName = "";
        String age = "";
        String atmType = "";
        String atmChan = "";

        while(true){
            System.out.println("Type 4 to Exit.");
            System.out.print("Fullname: ");
            Scanner SCFullname = new Scanner(System.in);
            String varA = SCFullname.nextLine();
            if(varA.matches(" |[a-zA-Z\\s]*")){
                fullName += varA;
                break;
            }else if(varA.equals("4")){
                System.exit(0);
            }
            else{
                System.out.println("Please enter a valid name.");
                Thread.sleep(1000);
            }
        }
        while(true){
            System.out.print("Age: ");
            Scanner SCFage = new Scanner(System.in);
            String varB = SCFage.next();
            if(varB.matches("[0-9]*")){
                double ageLimit = Double.parseDouble(varB);
            if(ageLimit < 18){
                System.out.println("You are underage!");
                System.exit(0);
            }
            else if(ageLimit > 100){
                System.out.println("You are overage!");
                System.exit(0);
            }
                age += varB;
                break;
            }
            else if(varB.equals("4")){
                System.exit(0);
            }
            else{
                System.out.println("Please enter a valid age.");
                Thread.sleep(1000);
            }
        }
        
            //atm type
            while(true){
                System.out.print("\033[H\033[2J");
            System.out.println("Select Card type: ");
            System.out.println("1. MASTER");
            System.out.println("2. VISA");
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            String input4 = sc.next();
            if(input4.matches("1|2")){
                if(input4.equals("1")){
                    atmType = "MASTER";
                    break;
                }else if(input4.equals("2")){
                    atmType = "VISA";
                    break;
                }
            }else{
                System.out.println("Please enter a valid card type.");
                Thread.sleep(1000);
            }
            }
            //atm channel
            while(true){
                System.out.print("\033[H\033[2J");
            System.out.println("Select Card Channel: ");
            System.out.println("1. Credit");
            System.out.println("2. Debit");
            System.out.print("> ");
            Scanner sc = new Scanner(System.in);
            String input4 = sc.next();
            if(input4.matches("1|2")){
                if(input4.equals("1")){
                    atmChan = "Credit";
                    break;
                }else if(input4.equals("2")){
                    atmChan = "Debit";
                    break;
                }
            }else{
                System.out.println("Please enter a valid card type.");
                Thread.sleep(1000);
            }
            }
            


        //accountnumber
        System.out.print("\033[H\033[2J");
        Random ran = new Random();
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; 
        System.out.print("\033[H\033[2J");
        System.out.print("Generating Account Number");
        String num1 = number[ran.nextInt(number.length)];
        System.out.print(".");
        Thread.sleep(750);
        String num2 = number[ran.nextInt(number.length)];
        System.out.print(".");
        Thread.sleep(750);
        String num3 = number[ran.nextInt(number.length)];
        System.out.print(".");
        Thread.sleep(750);
        String num4 = number[ran.nextInt(number.length)];
        System.out.print(".");
        Thread.sleep(750);
        String num5 = number[ran.nextInt(number.length)];
        System.out.print(".");
        Thread.sleep(750);
        String num6 = number[ran.nextInt(number.length)];
        System.out.print(".");
        Thread.sleep(750);

        String accountNumber = num1 + num2 + num3 + num4 + num5 + num6;
        System.out.println();
        System.out.println("Your Account Number is: " + accountNumber);
        System.out.println("Press enter to proceed.");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        
        //pin
        String pin = "";
        String rPin = "";
        boolean auth = false;
        System.out.print("\033[H\033[2J");
        while(true){
            System.out.print("Enter your PIN: ");
            Scanner SCFpin = new Scanner(System.in);
            String varPIN = SCFpin.next();
            if(varPIN.matches("[0-9]+")){
                if(varPIN.length() == 4){
                    pin += varPIN;
                    break;
                }else{
                    System.out.println("Please enter 4 digit PIN.");
                }
            }
            else{
                System.out.println("Invalid PIN.");
            }
        }
        while(true){
            System.out.print("Re-enter your PIN: ");
        Scanner SCrpin = new Scanner(System.in);
        String varRPin= SCrpin.next();
        if(varRPin.matches("[0-9]+")){
            if(varRPin.length() == 4){
                rPin += varRPin;
                if(pin.equals(rPin)){
                    auth = true;
                    break;
                }else{
                    System.out.println("PIN does not match.");
                }
                break;
            }else{
                System.out.println("Please enter 4 digit PIN.");
            }
        }
        else{
            System.out.println("Invalid PIN.");
        }
        }

        if(auth == true){
            System.out.println("PIN successfully set!");
            System.out.println("Please enter to proceed.");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            while(true){
            System.out.println("Check your details: ");
            System.out.println("Card Type           : " + atmType);
            System.out.println("Card Channel        : " + atmChan);
            System.out.println("AccountNumber       : " + accountNumber);
            System.out.println("PIN                 : " + pin);
            System.out.println("Fullname            : " + fullName);
            System.out.println("Age                 : " + age);
            System.out.println("Please enter to proceed.");
            System.out.println("Type 1 if exit. (Data will not save.)");
            String input = sc.nextLine();
            while(true){
                if(input.isEmpty()){
                    try{
                        System.out.print("Saving your information");
                        BufferedWriter bw = new BufferedWriter(new FileWriter(accountNumber));
                        System.out.print(".");
                        Thread.sleep(750);
                        bw.write("Card Type: " + atmType);
                        bw.newLine();
                        System.out.print(".");
                        Thread.sleep(750);
                        bw.write("Card Channel: " + atmChan);
                        bw.newLine();
                        System.out.print(".");
                        Thread.sleep(750);
                        bw.write("Account Number: " + accountNumber);
                        bw.newLine();
                        System.out.print(".");
                        Thread.sleep(750);
                        bw.write("PIN: " + pin);
                        bw.newLine();
                        System.out.print(".");
                        Thread.sleep(750);
                        bw.write("FullName: " + fullName);
                        bw.newLine();
                        System.out.print(".");
                        Thread.sleep(750);
                        bw.write("Age: " + age);
                        bw.newLine();
                        System.out.print(".");
                        Thread.sleep(750);
                        bw.write("Balance: 0");
                        bw.newLine();
                        System.out.print(".");
                        Thread.sleep(750);
                        bw.write("Last updated: " + formattedDateTime);
                        System.out.println();
                        Thread.sleep(750);
                        bw.close();
                        System.out.println("Account successfully created.");
                        System.out.println("Do you want a transaction?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.print("> ");
                        String Userinput = sc.nextLine();
                        if(Userinput.matches("1|2")){
                            if(Userinput.equals("1")){
                                System.out.print("\033[H\033[2J");
                                semiLogin();
                                System.exit(0);
                            }
                            else if(Userinput.equals("2")){
                                System.out.println("Thank you! (Data saved!)");
                                System.exit(0);
                            }
                        }else{
                            System.out.println("Invalid input.");
                        }
                    }catch(IOException e){
                        System.out.println("Err");
                    }
                }
                else if(input.equals("1")){
                    System.out.println("Thank you for using our ATM. (Data not saved.)");
                    System.exit(0);
                }else{
                    System.out.println("Invalid input.");
                }
            }  
            }
        }
            
        }
        

    

public static void semiLogin() throws InterruptedException{
    Console console = System.console();
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
    }
}

