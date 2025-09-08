// We have all come across ATMs in our cities and it is built on Java. This complex project consists of
// five different classes and is a console-based application. When the system starts the user is
// prompted with user id and user pin. On entering the details successfully, then ATM functionalities
// are unlocked. The project allows to perform following operations:
// 1.Transactions History
// 2.Withdraw
// 3.Deposit
// 4.Transfer
// 5.Quit

import java.util.ArrayList;
import java.util.Scanner;

public class ATM_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Dhruv Bank");
        System.out.println("*---------------------*");

        String[] nameOfUser = { "dhruv", "nirbhay", "saumya" };
        String[] pinOfUser = { "1234", "5678", "9012" };

        boolean userFound = false;

        System.out.print("Enter User Name:");
        String name = sc.next();

        // Loop to check for a valid user
        for (int i = 0; i < nameOfUser.length; i++) {
            if (name.equals(nameOfUser[i])) {
                userFound = true;

                System.out.print("Enter User PIN:");
                String pin = sc.next();

                // Add PIN validation
                if (pin.equals(pinOfUser[i])) {
                    System.out.println("*---------------------*");
                    System.out.println("Welcome " + name + " Choose Any One Option That Shows to The Screen.");

                    // Your ATM menu loop starts here
                    ArrayList<String> history = new ArrayList<>();
                    int balance = 20000;
                    boolean isRunning = true;
                    int withAmount = 0, depositAmount = 0, transferAmount = 0;

                    while (isRunning) {
                        System.out.println("1.Transection-History\n2.Widhraw\n3.Doposit\n4.Transfer\n5.Quit");
                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                System.out.println("\nBelow's data shows today's entry\n");
                                System.out.println("-----------------------------------");
                                if (history.isEmpty()) {
                                    System.out.println("\nYou did not make any transection today");
                                } else {
                                    System.out.println(history);
                                    System.out.println("-----------------------------------");
                                }
                                break;
                            case 2:
                                System.out.println("-------------------------------------------");
                                System.out.print("How Much Money Do You Want To Widhraw It? ");
                                withAmount = sc.nextInt();
                                if (withAmount > balance) {
                                    System.out.println("\nYou Dont Have Enough Money");
                                } else {
                                    System.out.println(
                                            "Amount $" + withAmount + " Withrawn Successfully.Now Your Balance Is $"
                                                    + (balance - withAmount));
                                    history.add("withrawl :" + withAmount);
                                    System.out.println("---------------------------------------------------------");
                                    balance = (balance - withAmount);
                                }
                                break;
                            case 3:
                                System.out.println("--------------------------------------");
                                System.out.print("Enter Amount And Then Enter Cash to AIM ");
                                depositAmount = sc.nextInt();
                                System.out.println("\n-----Please Wait-----");
                                System.out.println("\nNow Your Total Balance Is:$" + (balance + depositAmount));
                                history.add("Deposit :" + depositAmount);
                                System.out.println("-----------------------------------");
                                balance = balance + depositAmount;
                                break;
                            case 4:
                                System.out.println("--------------------------------");
                                System.out.print("Enter Amount TO Transfer It:");
                                transferAmount = sc.nextInt();

                                if (transferAmount > balance) {
                                    System.out.println("Insufficient balance for this transfer.");
                                } else {
                                    System.out.print("Enter Reciver's User Name:");
                                    String reciverName = sc.next();
                                    System.out.print("Enter Reciver's Id:");
                                    String reciverId = sc.next();

                                    boolean receiverFound = false;
                                    for (int j = 0; j < nameOfUser.length; j++) {
                                        // Check if the receiver's name and ID are correct
                                        if (reciverName.equals(nameOfUser[j]) && reciverId.equals(pinOfUser[j])) {
                                            receiverFound = true;

                                            // If they are correct, perform the transfer
                                            System.out.println("---------------------------------");
                                            System.out.println("$" + transferAmount + " Successfully Transferd To "
                                                    + reciverName
                                                    + " Now Your Available Balance Is $" + (balance - transferAmount));
                                            history.add("Transfer :" + transferAmount);
                                            balance = balance - transferAmount;
                                            break; // Exit the loop since we found the user
                                        }
                                    }

                                    // If the loop finishes and the receiver was not found
                                    if (!receiverFound) {
                                        System.out.println("---------------------------------");
                                        System.out.println("Transfer Failed: Receiver's User Name or ID is incorrect.");
                                        System.out.println("---------------------------------");
                                    }
                                }
                                break;
                            case 5:
                                isRunning = false;
                                break;
                            default:
                                System.out.println("Just Knock It Off");
                                break;
                        }
                    }
                } else {
                    System.out.println("Invalid PIN. Access Denied.");
                }
                break; // Crucial: Exit the loop once a user is found
            }
        }

        // If the loop finishes without finding a user
        if (!userFound) {
            System.out.println("Your Account Has not registered in our bank");
        }

        sc.close();
    }
}