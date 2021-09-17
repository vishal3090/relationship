import java.util.Scanner;
import java.util.Random;
public class GuessNumberGameDoWhile {
    public static void main(String[] args){
        Random random = new Random();
        int computerInput = random.nextInt(100);
        System.out.println("Enter '111' for exit the game");
        System.out.println("Enter a number in between 0-100: ");
        Scanner sc = new Scanner(System.in);
        int i = 0;
        do {
            try {
                int userInput = sc.nextInt();

                if (userInput > computerInput) {
                    System.out.println("Your Guess number is greater than computer number");
                }
                else if(userInput < computerInput){
                    System.out.println("Your Guess number is less than computer number");
                }
                else {
                    System.out.println("Computer guess number is: " + computerInput);
                    System.out.println("You Win!");
                }
                /*if(userInput < 0 && userInput > 11){
                    System.out.println("Wrong input. Please enter in between 1-10");
                }*/
                if (userInput == 111) {
                    System.exit(0);
                    System.out.println("Exit");
                }

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Invalid entry. Please enter valid number");
            }

            i++;

        }while(true);
        //System.out.println("Exit");
    }
}
