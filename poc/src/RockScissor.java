import java.util.Random;
import java.util.Scanner;

public class RockScissor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 0 for Rock, 1 for Paper, 2 for Scissor");
        int userInput = sc.nextInt();
        Random random = new Random();
        int computerInput = random.nextInt(3);
        if (userInput == computerInput){
            System.out.println("Draw");
        }
        else if(userInput == 0 && computerInput == 2 || userInput == 1 && computerInput == 0 || userInput == 2 && computerInput == 1){
            System.out.println("You win!");
        }
        else {
            System.out.println("Computer win!");
        }
        //For computer choise
        System.out.println("Computer choise = " +computerInput);
        if(computerInput == 0){
            System.out.println("Computer choise Rock");
        }
        else if(computerInput == 1){
            System.out.println("Computer choise Paper");
        }
        if(computerInput == 2){
            System.out.println("Comp1uter choise Scissor");
        }
    }
}
