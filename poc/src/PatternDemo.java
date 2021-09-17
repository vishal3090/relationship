public class PatternDemo {
    public static void main(String[] args){
        int n = 5;
        int i, j, k;
        for(i=1; i<=n; i++){
            System.out.print("");
            for (j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            for (k=1; k<=i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
