class MyThread1 extends Thread{
    @Override
    public void run(){
        int i = 0;
        while (i<20000){
            System.out.println("Hello");
            System.out.println("hi");
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run(){
        int i = 0;
        while (i<20000){
            System.out.println("Good mornig people");
            System.out.println("Good afternoon, This is java");
        }
    }
}
public class ThreadWhile {
    public static void main(String[] args){
        MyThread1 a1 = new MyThread1();
        MyThread2 a2 = new MyThread2();
        a1.start();
        a2.start();
        //a1.run();
        //a2.run();
    }
}
