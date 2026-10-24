
/*Question 4
 Write a Java Program that does the following
a. Create a super class called Car. The Car class has the following fields and methods.
   int speed; double regularPrice; String color; double getSalePrice();
b. Create a sub class of Car class and name it as Truck. The Truck class has the following fields and methods.
   int weight; double getSalePrice();
   If weight > 2000, 10% discount. Otherwise, 20% discount.
c. Create a subclass of Car class and name it as Ford. The Ford class has the following fields and methods.
   int year; int manufacturerDiscount; double getSalePrice();
   From the sale price computed from Car class, subtract the manufacturer discount.
d. Create a subclass of Car class and name it as Sedan. The Sedan class has the following fields and methods.
   int length; double getSalePrice();
   If length > 20 feet, 5% discount. Otherwise, 10% discount.
e. Create MyOwnAutoShop class which contains the main() method. Perform the following within the main() method.
   * Create an instance of Sedan class and initialize all the fields with appropriate values.
   *Use super(...) method in the constructor for initializing the fields of the superclass.
   *Create an instance of the Ford class and initialize all the fields with appropriate values.
   *Use super(...) method in the constructor for initializing the fields of the superclass.
   *Create an instance of Car class and initialize all the fields with appropriate values. Display the sale prices of all instances.
*/

class Car {
    int speed;
    double regularPrice;
    String color;

    Car(int speed, double regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    double getSalePrice() {
        return regularPrice;
    }
}

class Truck extends Car {
    int weight;

    Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    double getSalePrice() {
        if (weight > 2000) {
            return regularPrice * 0.90;
        }
        return regularPrice * 0.80;
    }
}

class Ford extends Car {
    int year;
    int manufacturerDiscount;

    Ford(int speed, double regularPrice, String color,
         int year, int manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    double getSalePrice() {
        return regularPrice - manufacturerDiscount;
    }
}

class Sedan extends Car {
    int length;

    Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    double getSalePrice() {
        if (length > 20) {
            return regularPrice * 0.95;
        }
        return regularPrice * 0.90;
    }
}

public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan sedan = new Sedan(180, 1500000, "White", 18);
        Ford ford = new Ford(200, 2500000, "Black", 2025, 100000);
        Car car = new Car(160, 1000000, "Red");
        Truck truck = new Truck(120, 3000000, "Blue", 2500);

        System.out.println("Sedan sale price: " + sedan.getSalePrice());
        System.out.println("Ford sale price: " + ford.getSalePrice());
        System.out.println("Car sale price: " + car.getSalePrice());
        System.out.println("Truck sale price: " + truck.getSalePrice());
    }
}
