import java.util.Scanner;

public class Pattern {
    public static void main(String[] args){
        /*
          *
         * *
        * * *
       * * * *
      * * * * *
       Logic:
       rows = 1 2 3 4 5
       spaces = 4 3 2 1 0(rows-1)
       pattern '*' = 1 2 3 4 5
        */
        int n=5;
        for (int i=n; i>=n; i++){
            for (int j=0; j<=n-i; j++){
                System.out.print(" ");
            }
            for (int k=0; k<=i; k++){
                System.out.print("* ");
            }
            System.out.println();
            //System.out.print("\n");
        }

         /*
      * * * * *
       * * * *
        * * *
         * *
          *
       Logic:
       rows = 1 2 3 4 5
       spaces = 0 1 2 3 4
       pattern '*' = 1 2 3 4 5
        */
        for (int i=n; i>0; i--){
            for (int j=0; j<n-i; j++){
                System.out.print(" ");
            }
            for (int k=0; k<i; k++){
                System.out.print("* ");
            }
            System.out.println();
            //System.out.print("\n");
        }
        /*
          *
         ***
        *****
       *******
      *********
       Logic:
       rows = 1 2 3 4 5
       spaces = 4 3 2 1 0(rows-1)
       pattern '*' = 1 3 5 7 9(rows*2-1)
        */

        /*int m=9;
        int x, y, z;
        for(x=0; x<m;x++){
            for (y=0;y<m-x;y++){
                System.out.print(" ");
            }
            for (z=0;z<x*2-m;z++){
                System.out.print("*");
            }
            System.out.println();
        }
        int n=5;
        int i, j, k;
        for (i=0; i<n; i++){
            for (j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for (k=0;k<i;k++){
                System.out.print("*");
            }
            System.out.println();
        }*/


    }
}
