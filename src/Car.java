public class Car {
    private final String brand;
    private final String model;
    private final int year;
    private int speed;

    public Car(String brand, String model, int year){
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.speed = 0;
    }
    public void start(){
        System.out.println(brand + " " + model + "Started");
    }
    public void accelerate() {
        speed += 10;
        System.out.println(brand + " " + model + " accelerated to " + speed + " km/h.");
    }
    public void brake() {
        speed = Math.max(0, speed - 10);
        System.out.println(brand + " " + model + " slowed to " + speed + " km/h.");
    }

    public void displayInfo() {
        System.out.println("Car Info - Brand: " + brand + ", Model: " + model + ", Year: " + year + ", Speed: " + speed + " km/h.");
    }
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020);
        Car car2 = new Car("Tesla", "Model 3", 2023);

        car1.start();
        car1.accelerate();
        car1.accelerate();
        car1.brake();
        car1.displayInfo();

        System.out.println();

        car2.start();
        car2.accelerate();
        car2.brake();
        car2.displayInfo();
    }
}
