package ATM;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TransactionReciept {
    public void receipt(String cardNumber, String trans, String amount){
        if(trans.equals("WITHDRAW")){
            try{
                BufferedReader br = new BufferedReader(new FileReader(cardNumber));
                String line;
                String cc = "";
                String ct = "";
                String date = "";
                String bal = "";
    
                while((line = br.readLine()) != null){
                    if(line.startsWith("Balance: ")){
                        bal = line.substring(9);
                    }
                    if(line.startsWith("Card Type: ")){
                        ct = line.substring(11);
                    }
                    if(line.startsWith("Card Channel: ")){
                        cc = line.substring(14);
                    }
                    if(line.startsWith("Last updated: ")){
                     date = line.substring(14);
                    }
                }
                String cardNo = cardNumber.replaceAll("\\d(?=\\d{2})", "*");
            // System.out.print("\033[H\033[2J");
            Random ran = new Random();
            String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; 
            String num1 = number[ran.nextInt(number.length)];
            String num2 = number[ran.nextInt(number.length)];
            String num3 = number[ran.nextInt(number.length)];
            String num4 = number[ran.nextInt(number.length)];
            String num5 = number[ran.nextInt(number.length)];
            String num6 = number[ran.nextInt(number.length)];
            String num7 = number[ran.nextInt(number.length)];
            String num8 = number[ran.nextInt(number.length)];
            String TerminalID = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8;
    
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("|                                        |");
            System.out.println("|                                        |");
            System.out.println("- - - - -Automated Teller Machine- - - - -");
            System.out.println("            Balayan, Batangas");
            System.out.println("|                                        |");
            System.out.println("TERMINAL ID                    " + TerminalID);
            System.out.println("|                                        |");
            System.out.println("Card Type                       " + ct);
            System.out.println("Payment Channel                 " + cc);
            System.out.println("CARD NO.                        " + cardNo);
            System.out.println("TRANS TYPE                  " + trans);
            System.out.println("DATE/TIME           " + date);
            System.out.println("|                                        |");
            System.out.println("            -----APPROVED-----            ");
            System.out.println("|                                        |");
            System.out.println("AMOUNT WITHDRAW               " + "PHP" + amount);
            System.out.println("BALANCE                         " +"PHP "+ bal);
            System.out.println("APP LABEL            " + cc + " " + ct+ "CARD");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

            File file = new File(TerminalID);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("- - - - -Automated Teller Machine- - - - -" + "\n");
            bw.write("            Balayan, Batangas" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("TERMINAL ID                    " + TerminalID + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("Card Type                       " + ct + "\n");
            bw.write("Payment Channel                 " + cc + "\n");
            bw.write("CARD NO.                        " + cardNo + "\n");
            bw.write("TRANS TYPE                      " + trans + "\n");
            bw.write("DATE/TIME           " + date + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("            -----APPROVED-----            " + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("AMOUNT WITHDRAW               " + "PHP" + amount + "\n");
            bw.write("BALANCE                         " +"PHP "+ bal + "\n");
            bw.write("APP LABEL             " + cc + " " + ct + "CARD" + "\n");
            bw.write("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            bw.close();
            br.close();
            System.exit(0);
            }catch(IOException e){
                System.out.println("Err");
            }
        }


        else if(trans.equals("DEPOSIT")){
            try{
                BufferedReader br = new BufferedReader(new FileReader(cardNumber));
                String line;
                String cc = "";
                String ct = "";
                String date = "";
                String bal = "";
    
                while((line = br.readLine()) != null){
                    if(line.startsWith("Balance: ")){
                        bal = line.substring(9);
                    }
                    if(line.startsWith("Card Type: ")){
                        ct = line.substring(11);
                    }
                    if(line.startsWith("Card Channel: ")){
                        cc = line.substring(14);
                    }
                    if(line.startsWith("Last updated: ")){
                     date = line.substring(14);
                    }
                }
                String cardNo = cardNumber.replaceAll("\\d(?=\\d{2})", "*");
            // System.out.print("\033[H\033[2J");
            Random ran = new Random();
            String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; 
            String num1 = number[ran.nextInt(number.length)];
            String num2 = number[ran.nextInt(number.length)];
            String num3 = number[ran.nextInt(number.length)];
            String num4 = number[ran.nextInt(number.length)];
            String num5 = number[ran.nextInt(number.length)];
            String num6 = number[ran.nextInt(number.length)];
            String num7 = number[ran.nextInt(number.length)];
            String num8 = number[ran.nextInt(number.length)];
            String TerminalID = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8;
    
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("|                                        |");
            System.out.println("|                                        |");
            System.out.println("- - - - -Automated Teller Machine- - - - -");
            System.out.println("            Balayan, Batangas");
            System.out.println("|                                        |");
            System.out.println("TERMINAL ID                    " + TerminalID);
            System.out.println("|                                        |");
            System.out.println("Card Type                       " + ct);
            System.out.println("Payment Channel                 " + cc);
            System.out.println("CARD NO.                        " + cardNo);
            System.out.println("TRANS TYPE                      " + trans);
            System.out.println("DATE/TIME           " + date);
            System.out.println("|                                        |");
            System.out.println("            -----APPROVED-----            ");
            System.out.println("|                                        |");
            System.out.println("AMOUNT DEPOSIT                 " + "PHP " + amount);
            System.out.println("BALANCE                         " +"PHP "+ bal);
            System.out.println("APP LABEL                " + cc + " " + ct + "CARD");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");


            File file = new File(TerminalID);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("- - - - -Automated Teller Machine- - - - -" + "\n");
            bw.write("            Balayan, Batangas" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("TERMINAL ID                    " + TerminalID + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("Card Type                       " + ct + "\n");
            bw.write("Payment Channel                 " + cc + "\n");
            bw.write("CARD NO.                        " + cardNo + "\n");
            bw.write("TRANS TYPE                      " + trans + "\n");
            bw.write("DATE/TIME           " + date + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("            -----APPROVED-----            " + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("AMOUNT DEPOSIT                 " + "PHP " + amount + "\n");
            bw.write("BALANCE                         " +"PHP "+ bal + "\n");
            bw.write("APP LABEL                " + cc + " " + ct + "CARD" + "\n");
            bw.write("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            bw.close();
                br.close();
                System.exit(0);
            }catch(IOException e){
                System.out.println("Err");
            }
        }
        else{
            try{
                BufferedReader br = new BufferedReader(new FileReader(cardNumber));
                String line;
                String cc = "";
                String ct = "";
                String date = "";
                String bal = "";
    
                while((line = br.readLine()) != null){
                    if(line.startsWith("Balance: ")){
                        bal = line.substring(9);
                    }
                    if(line.startsWith("Card Type: ")){
                        ct = line.substring(11);
                    }
                    if(line.startsWith("Card Channel: ")){
                        cc = line.substring(14);
                    }
                    if(line.startsWith("Last updated: ")){
                     date = line.substring(14);
                    }
                }
                String cardNo = cardNumber.replaceAll("\\d(?=\\d{2})", "*");
            // System.out.print("\033[H\033[2J");
            Random ran = new Random();
            String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; 
            String num1 = number[ran.nextInt(number.length)];
            String num2 = number[ran.nextInt(number.length)];
            String num3 = number[ran.nextInt(number.length)];
            String num4 = number[ran.nextInt(number.length)];
            String num5 = number[ran.nextInt(number.length)];
            String num6 = number[ran.nextInt(number.length)];
            String num7 = number[ran.nextInt(number.length)];
            String num8 = number[ran.nextInt(number.length)];
            String TerminalID = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8;
    
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("|                                        |");
            System.out.println("|                                        |");
            System.out.println("- - - - -Automated Teller Machine- - - - -");
            System.out.println("            Balayan, Batangas");
            System.out.println("|                                        |");
            System.out.println("TERMINAL ID                    " + TerminalID);
            System.out.println("|                                        |");
            System.out.println("Card Type                       " + ct);
            System.out.println("Payment Channel                 " + cc);
            System.out.println("CARD NO.                        " + cardNo);
            System.out.println("TRANS TYPE                      " + trans);
            System.out.println("DATE/TIME           " + date + "\n");
            System.out.println("|                                        |");
            System.out.println("            -----APPROVED-----            ");
            System.out.println("|                                        |");
            System.out.println("|                                        |");
            System.out.println("BALANCE                         " +"PHP "+ bal);
            System.out.println("APP LABEL                " + cc + " " + ct + "CARD");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            
                File file = new File(TerminalID);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("- - - - -Automated Teller Machine- - - - -" + "\n");
            bw.write("            Balayan, Batangas" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("TERMINAL ID                    " + TerminalID + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("Card Type                       " + ct + "\n");
            bw.write("Payment Channel                 " + cc + "\n");
            bw.write("CARD NO.                        " + cardNo + "\n");
            bw.write("TRANS TYPE                      " + trans + "\n");
            bw.write("DATE/TIME           " + date);
            bw.write("|                                        |" + "\n");
            bw.write("            -----APPROVED-----            " + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("|                                        |" + "\n");
            bw.write("BALANCE                         " +"PHP "+ bal + "\n");
            bw.write("APP LABEL                " + cc + " " + ct + "CARD" + "\n");
            bw.write("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            bw.close();
            br.close();
            System.exit(0);
            }catch(IOException e){
                System.out.println("Err");
            }
        }
        

    }
}
