public class NumberPatterns {
    public static void main(String[] args){
        //increasing triangle
        int n=7;
        int i, j, k;
        /*
        rows = 1 2 3 4 5 6 7
        space = 1 2 3 4 5 6 7
        pattern = 7 6 5 4 3 2 1
        */

        for (i=1; i<=n; i++){
            for (j=1; j<i; j++){
                System.out.print(" ");
            }
            for (k=i;k<=n;k++){
                System.out.print(k+" ");
            }
            System.out.println();
        }

        for (i=n-1; i>=1; i--){
            for (j=1; j<i; j++){
                System.out.print(" ");
            }
            for (k=i; k<=n; k++){
                System.out.print(k+" ");
            }
            System.out.println();
        }

        //decreasing triangle

     /*       1
             1 2
            1 2 3
           1 2 3 4
          1 2 3 4 5
         1 2 3 4 5 6
        1 2 3 4 5 6 7
         1 2 3 4 5 6
          1 2 3 4 5
           1 2 3 4
            1 2 3
             1 2
              1   */
        //int n=7;
        //int i, j, k;
        /*for(i=1;i<n;i++){
            for (j=i;j<=n;j++){
                System.out.print(" ");
            }
            for(k=1;k<=i;k++){
                System.out.print(k+" ");
            }
            System.out.println();
        }
        for(i=n;i>0;i--){
            for (j=i;j<=n;j++){
                System.out.print(" ");
            }
            for(k=1;k<=i;k++){
                System.out.print(k+" ");
            }
            System.out.println();
        }*/

         /* 0 1 2 3 4 5 6
        1 2 3 4 5 6
        2 3 4 5 6
        3 4 5 6
        4 5 6
        5 6
        6*/
        /*for(i=0;i<n;i++){
            for (j=i;j<n;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }*/
      /*1
        2 2
        3 3 3
        4 4 4 4
        5 5 5 5 5
        6 6 6 6 6 6*/
        /*for(i=0;i<n;i++){
            for (j=0;j<i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }*/
    }
}
