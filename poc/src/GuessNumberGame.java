import java.util.Random;
import java.util.Scanner;
public class GuessNumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int computerInput = random.nextInt(10);
        System.out.println("Enter '11' for exit the game");
        System.out.println("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        //int userInput= sc.nextInt();
        int userInput = 0;
            try {
                userInput = sc.nextInt();
                if (userInput < 0 || userInput > 10) {
                    System.out.println("Invalid entry");
                }
                    if (userInput == 11) {
                        System.exit(0);
                        System.out.println("Exit");
                }

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid entry. Please enter valid number");
            }

        boolean flag = true;
        int i = 0;
        while (userInput != computerInput) {
            System.out.println("Your number is not match.");
            System.out.println("Enter new number: ");

            while (flag && i < 5) {
                try {
                    userInput = sc.nextInt();
                    if (userInput < 0 || userInput > 10) {
                        System.out.println("Invalid entry");
                    }

                        if (userInput == 11) {
                            System.exit(0);
                            System.out.println("Exit");
                            break;
                        }
                    break;
                } catch (Exception e) {

                        if (userInput == 11) {
                            System.exit(0);
                            System.out.println("Exit");
                            break;
                        }
                    sc.nextLine();
                    System.out.println("Invalid entry. Please enter valid number");
                    i++;
                }
                if (i >= 5) {//max 10 retries
                    System.out.println("Error");
                    return;
                }
            }
        }
        System.out.println("Computer guess number is: " + computerInput);
        System.out.println("You Win!");

    }
    }
