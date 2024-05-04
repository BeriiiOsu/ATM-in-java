package ATM;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Login {
    public void accountLogin(String accountNumber, String PIN) throws InterruptedException{
        LocalDateTime currentDateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String formattedDateTime = currentDateTime.format(formatter);
        File dataBase = new File(accountNumber);
        if(!dataBase.exists()){
            System.out.println("Account does not exist");
        }else{
            try{
                String data;
                boolean auth = false;
                String dataPIN = "";
                String strBalance = "";
                String name = "";
                BufferedReader br = new BufferedReader(new FileReader(dataBase));
                while((data = br.readLine()) != null){
                    if(data.startsWith("PIN: ")){
                        dataPIN = data.substring(5);
                    }
                    if(data.startsWith("Balance: ")){
                        strBalance = data.substring(9);
                    }
                    if(data.startsWith("FullName: ")){
                        name = data.substring(10);
                    }
                }
                br.close();
                double dBalance = Double.parseDouble(strBalance);
                if(dataPIN.equals(PIN)){
                    auth = true;
                }else{
                    System.out.println("PIN does not match.");
                    System.out.println("Please Try Again.");
                    System.exit(0);
                }
                if(auth){
                    while(true){
                    try{
                            // System.out.print("\033[H\033[2J");
                            System.out.println("Welcome " + name);
                            System.out.println("1. Withdraw");
                            System.out.println("2. Deposit");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Exit");
                            System.out.print("> ");
                            Scanner sc = new Scanner(System.in);
                            int choice = sc.nextInt();
                        switch(choice){
                            case 1:
                            System.out.print("\033[H\033[2J");
                            System.out.print("Enter amount to withdraw: ");
                            double amount = sc.nextDouble();
                            if(amount <=0){
                                System.out.println("Please Enter a Valid Amount.");
                                System.out.println("Please Try Again.");
                                System.exit(0);
                            }
                            if(amount > dBalance){
                                System.out.println("Insufficient Balance.");
                                System.out.println("Please Try Again.");
                            }else{
                                try{
                                    BufferedReader br1 = new BufferedReader(new FileReader(dataBase));
                                    String line;
                            String data1 = "";
                            String balanceLine = "";
                            String datetimeLine = "";
                                while ((line = br1.readLine()) != null) {
                                    data1 += line + "\n";
                                    if (line.startsWith("Balance: ")) {
                                        balanceLine = line;
                                    }
                                    if(line.startsWith("Last updated: ")){
                                        datetimeLine = line;
                                    }
                                }
                           
                            String[] balanceParts = balanceLine.split(":");
                            double balance = Double.parseDouble(balanceParts[1].trim());

                            balance -= amount;

                            String newData = data1.replace(balanceLine, "Balance: " + balance);
                            newData = newData.replace(datetimeLine, "Last updated: " + formattedDateTime);
                            FileWriter writer = new FileWriter(dataBase);
                            writer.write(newData);
                            writer.close();
                            br1.close();

                                }catch(IOException e){
                                    System.out.println("Err Message code: 101");
                                }
                        System.out.print("\033[H\033[2J");
                        System.out.println("Sucess!");
                        System.out.println("Do you want another transaction?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.print("> ");
                        int choice1 = sc.nextInt();
                        if(choice1 == 1){
                            System.out.print("\033[H\033[2J");
                            continue;
                        }else if(choice1 == 2){
                            System.out.println("Your Reciept");
                            Thread.sleep(2000);
                            System.out.print("\033[H\033[2J");
                            String cardFile = dataBase.toString();
                            String type = "WITHDRAW";
                            TransactionReciept tr = new TransactionReciept();
                            String strAmount = String.valueOf(amount);
                            tr.receipt(cardFile, type, strAmount);
                            break;
                        }else{
                            break;
                        }
                            }//else
                            break;
                            
                            case 2:
                            System.out.print("\033[H\033[2J");
                            System.out.print("Enter amount to deposit: ");
                            double amount1 = sc.nextDouble();
                            if(amount1 <=0){
                                System.out.println("Please Enter a Valid Amount.");
                                System.out.println("Please Try Again.");
                                System.exit(0);
                            }
                                try{
                                    BufferedReader br1 = new BufferedReader(new FileReader(dataBase));
                                    String line;
                            String data1 = "";
                            String balanceLine = "";
                            String datetimeLine = "";
                                while ((line = br1.readLine()) != null) {
                                    data1 += line + "\n";
                                    if (line.startsWith("Balance: ")) {
                                        balanceLine = line;
                                    }
                                    if(line.startsWith("Last updated: ")){
                                        datetimeLine = line;
                                    }
                                }
                            String[] balanceParts = balanceLine.split(":");
                            double balance = Double.parseDouble(balanceParts[1].trim());

                            balance += amount1;

                            String newData = data1.replace(balanceLine, "Balance: " + balance);
                            newData = newData.replace(datetimeLine, "Last updated: " + formattedDateTime);
                            FileWriter writer = new FileWriter(dataBase);
                            writer.write(newData);
                            writer.close();
                            br1.close();

                                }catch(IOException e){
                                    System.out.println("Err Message code: 101");
                                }
                        System.out.print("\033[H\033[2J");
                        System.out.println("Sucess!");
                        System.out.println("Do you want another transaction?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.print("> ");
                        int choice1 = sc.nextInt();
                        if(choice1 == 1){
                            System.out.print("\033[H\033[2J");
                            continue;
                        }else if(choice1 == 2){
                            System.out.println("Your Reciept");
                            Thread.sleep(2000);
                            System.out.print("\033[H\033[2J");
                            String cardFile = dataBase.toString();
                            String type = "DEPOSIT";
                            TransactionReciept tr = new TransactionReciept();
                            String strAmount = String.valueOf(amount1);
                            tr.receipt(cardFile, type, strAmount);
                            break;
                        }else{
                            System.out.println("Invalid input");
                            System.exit(0);
                        }

                            case 3:
                            System.out.print("\033[H\033[2J");
                            try{
                                BufferedReader br1 = new BufferedReader(new FileReader(dataBase));
                                String line;
                        String balance = "";
                            while ((line = br1.readLine()) != null) {
                                if (line.startsWith("Balance: ")) {
                                    balance = line.substring(9);
                                }
                            }
                            System.out.print("\033[H\033[2J");
                        System.out.println("Your current balance is: " + balance);
                        br1.close();
                        System.out.println("Do you want another transaction?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.print("> ");
                        int choice2 = sc.nextInt();
                        if(choice2 == 1){
                            System.out.print("\033[H\033[2J");
                            continue;
                        }else if(choice2 == 2){
                            System.out.println("Your Reciept");
                            Thread.sleep(2000);
                            System.out.print("\033[H\033[2J");
                            String cardFile = dataBase.toString();
                            String type = "CHECKBAL";
                            TransactionReciept tr = new TransactionReciept();
                            tr.receipt(cardFile, type, balance);
                        }
                        else{
                            System.out.println("Invalid Input!");
                            break;
                        }
                            
                        }catch(IOException e){
                            System.out.println("Err Message code: 101");
                        }
                            break;

                            case 4:
                            System.exit(0);
                            break;

                            default:
                            System.out.println("Please enter a valid choice.");
                            break;
                        }
                    }catch(InputMismatchException e){
                        System.out.println("Invalid choice");
                    }
                }
                }
            }catch(IOException e){
                System.out.println("Err Message code: 61239");
            }
        }

    }
}
