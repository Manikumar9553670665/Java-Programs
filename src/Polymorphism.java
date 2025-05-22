public class Polymorphism {
    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println("add(int, int): " + calc.add(5, 10));
        System.out.println("add(double, double): " + calc.add(5.5, 4.5));
        System.out.println("add(int, int, int): " + calc.add(1, 2, 3));

        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.makeSound();
        myCat.makeSound();
    }
}
class Calc{
    public int add(int a, int b){
        return a + b;
    }
    public double add(double a, double b){
        return a + b;
    }
    public int add(int a, int b, int c){
        return a + b + c;
    }
}
class Animal{
    public void makeSound(){
        System.out.println("Animal Sounds");
    }
}
class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Dog Barks");
    }
}
class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Cat Meows");
    }
}

