import java.util.Scanner;
public class WhileDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Regular expression for string

        /*boolean flag;
        Scanner sc = new Scanner(System.in);
        do {
            // must be a digit from 0 - 9
            String digit = "\\d";
            System.out.print("Input an integer: ");
            String input = sc.next();
            flag = input.matches(digit);
            if (!flag) System.out.println("You must enter a number!");
        } while (!flag);
        System.out.println("Valid data");*/

        /*for(int i=100; i>0; i-=2){
            //System.out.print(i+" ");
        }
        int i = 1;
        while (i<=100){
            if (i%2==0){
                System.out.println(i+" ");
            }
            i++;
        }*/


        /*int i=1;
        int sum = 0;
        while (i<=100){
            if(sum<100){
                sum = sum + i;
                System.out.print(sum+", ");
                //break;
            }
            i++;
        }*/
        //Scanner sc = new Scanner(System.in);
        //Total input sum not exceed 100
        /*int sum = 0;
        while (true){
            System.out.println("Enter a number");
            sum += sc.nextInt();
            if (sum>100){
                break;
            }
        }
        System.out.println("Done: "+sum);*/
//////USer can add values but when enter minus value program stop and display max and min value
        /*int n = sc.nextInt();
        int max = n;
        int min = n;
        while (true){
            n = sc.nextInt();
            if(n<0)
                break;
            if(n>max);{
                max = n;
            }
            if (n<min){
                min = n;
            }
        }
        System.out.println("Max = "+max+" Min = "+min);
*/
///////////Display the sum of digits of an integer read from the user
        ////Ex : 152 = 1+5+2=8
        /*int n = sc.nextInt();
        int sum = 0;
        while (n > 0){
            sum += n % 10; //ABC fro C, for the last number
            sum /= 10; //AB
        }
        System.out.println("sum = "+sum);*/
///////////Fibonacci numbers : 1, 1, 2, 3, 5, 8, 13, 21...
        //display nth positioin number
        /*System.out.println("Enter an integer: ");
        int n = sc.nextInt();
        int result = 0;
        int v1 = 1;
        int v2 = 1;
        for (int i = 1; i <= n-2; i++) {
            result = v1 + v2;
            v1 = v2;
            v2 = result;
        }
        System.out.println("Result = " + (result == 0 ? 1 : result));
*/
////////Adding space after each character in string
        String str = "Hello Java!";
        for (int i=0; i<str.length()-1; i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
        //Reverse string
        for (int i = str.length()-1; i>=0; i--){
            System.out.print(str.charAt(i));
        }




    }
}
/*int k = 0;
        while (k < number.length) {
            number[k] = sc.nextInt();
            k++;
        }*/