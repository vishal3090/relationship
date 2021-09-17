class A{
    public int math1(){
        return 7;
    }
    public void math2(){
        System.out.println("I am a method 2 class A");
    }
}
class B extends A{
    @Override
    public void math2(){
        System.out.println("I am a method 2 class B");
    }
    public void math3(){
        System.out.println("I am a method 3 class B");
    }
}
public class MethodOverriding {
    public static void main(String[] args){
        A a = new A();
        a.math2();

        B b = new B();
        b.math2();
    }
}
