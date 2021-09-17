class Phone{
    public void greet(){
        System.out.println("Hello");
    }
    public void name(){
        System.out.println("My name is Phone");
    }
}
class SmartPhone extends Phone{
    public void greet1(){
        System.out.println("Hi");
    }
    public void name(){
        System.out.println("My name is Smartphone");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args){
        //Phone a = new Phone();
        //SmartPhone b = new SmartPhone();
        //a.name();

        Phone a = new SmartPhone();
        a.greet();
        a.name();
    }
}
