

    //Problem 1 Get salary, Get name
    /*class Employee {
        int salary;
        String name;

        public int getSalary() {
            return salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String n) {
            name = n;
        }
    }*/

    //Problem 2 Cellphone class with metohds ringing, vibraring etc.
    /*class Cellphone{
        public  void ring(){
            System.out.println("Ringing...");
        }
        public void vibrate(){
            System.out.println("Vibrating...");
        }
        public void callFriend(){
            System.out.println("Calling Dev...");
        }
            }*/

    //Problem 3 class Square, initialize its side, calculating area, perimeters etc
    /*class Square{
        int side;
        public int area(){
            return side*side;
        }
        public int peremeter(){
            return side*4;
        }
    }*/

    //Problem 4 class Rectangle, initialize its side, calculating area, perimeters etc
    /*class Rectangle{
        int height;
        int breadth;
        public int recArea(){
            return height * breadth;
        }
        public int recPeremeter(){
            return 2 * height + 2 * breadth;
        }
    }*/

    //Problem 6 class Circle, initialize its radius, calculating area, perimeters etc
    class Circle{
        int radius;
        float pie = 3.14f;
        public float circleArea(){
            return pie * radius * radius;
        }
        public float circlePeremeter(){
            return 2 * pie * radius;
        }
    }

    public class POC {
    public static void main(String[] args){
        //problem 1 Get salary, Get name
        /*Employee john = new Employee();
        john.setName("hello John");
        john.getName();
        john.salary = 244;
        System.out.println(john.getSalary());
        System.out.println(john.getName());*/

        //Problem 2 Cellphone class with metohds ringing, vibraring etc.
        //Output : Calling Dev.../n Vibrating.../n Ringing...
        /*Cellphone GalaxyS1 = new Cellphone();
        GalaxyS1.callFriend();
        GalaxyS1.vibrate();
        GalaxyS1.ring();*/

        //Problem 3 class Square, initialize its side, calculating area, perimeters etc
        /*Square sq = new Square();
        sq.side = 5;
        System.out.println(sq.area());
        System.out.println(sq.peremeter());*/

        //Problem 4 class Rectangle, initialize its side, calculating area, perimeters etc
        /*Rectangle rec = new Rectangle();
        rec.height = 4;
        rec.breadth = 5;
        System.out.println(rec.recArea());
        System.out.println(rec.recPeremeter());*/

        //Problem 6 class Circle, initialize its radius, calculating area, perimeters etc
        Circle cir = new Circle();
        cir.radius = 7;
        System.out.println(cir.circleArea());
        System.out.println(cir.circlePeremeter());
    }
}
