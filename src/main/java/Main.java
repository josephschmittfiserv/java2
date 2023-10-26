import java.util.ArrayList;
import java.util.List;

class Person extends Animal {
    private String firstName;
    private String lastName;
    private int social;
    private static int count;

    public Person() {
        this.firstName = "";
        this.lastName = "";
        super.age = 0;
        this.social = 0;
        count++;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        super.age = 0;
        this.social = 0;
        count++;
    }

    public Person(String firstName, String lastName, byte age, int social) {
        this.firstName = firstName;
        this.lastName = lastName;
        super.age = age;
        this.social = social;
        count++;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return super.age;
    }

    public int getSocial() {
        return this.social;
    }

    public static int getPersonCount() {
        return count;
    }

    public String speak() {
        String introduction = "";

        if (getFirstName() != "" && getLastName() != "" && getAge() != 0 && getSocial() != 0) {
            introduction = "My name is " + getFirstName() + " " + getLastName() +
                    " and I am " + getAge() + " years old. " + getSocial();
        } else if (getFirstName() != "" && getLastName() != "" && getAge() != 0 && getSocial() == 0) {
            introduction = "My name is " + getFirstName() + " " + getLastName() +
                    " and I am " + getAge() + " years old.";
        } else if (getFirstName() != "" && getLastName() != "" && getAge() == 0 && getSocial() == 0) {
            introduction = "My name is " + getFirstName() + " " + getLastName() + ".";
        } else if (getFirstName() != "" && getLastName() == "" && getAge() == 0 && getSocial() == 0) {
            introduction = "My name is " + getFirstName();
        } else if (getFirstName() == "" && getLastName() == "" && getAge() == 0 && getSocial() == 0) {
            introduction = "I dont have a name.";
        } else if (getFirstName() != "" && getLastName() != "" && getAge() == 0 && getSocial() != 0) {
            introduction = "My name is " + getFirstName() + " " + getLastName() +
                    getSocial();
        }

        return introduction;
    }

    @Override
    public String toString() {
        String result = "";
        if (getFirstName() == "") {
            return result = "N/A";
        } else if (getFirstName() != "" && getLastName() != "" && getAge() == 0 && getSocial() == 0) {
            return result = "My name is " + getFirstName() + " " + getLastName() + ".";
        } else if (getFirstName() != "" && getLastName() != "" && getAge() != 0 && getSocial() != 0) {
            return result = "My name is " + getFirstName() + " " + getLastName() + " " + getSocial() % 10000;
        }

        return result;
    }
}

class Animal {
    public byte age;
}

class Dog extends Animal {
    public Dog(byte n) {
        super.age = n;
    }
}

class Cat extends Animal {
}

class AwesomeNumber {
    private int num;

    public AwesomeNumber(int number) {
        this.num = number;
    }

    public AwesomeNumber() {
        this.num = 0;
    }

    public int getAwesomeNumber() {
        return this.num;
    }

    public static int add(AwesomeNumber num1, AwesomeNumber num2) {
        return num1.getAwesomeNumber() + num2.getAwesomeNumber();
    }

    public static int subtract(AwesomeNumber num1, AwesomeNumber num2) {
        return num1.getAwesomeNumber() - num2.getAwesomeNumber();
    }
}

interface Calculatable {

    Integer add(Integer number1, Integer number2);

    Integer subtract(Integer number1, Integer number2);

    Integer multiply(Integer number1, Integer number2);

    Integer divide(Integer number1, Integer number2);

    String getHistory();
}

class Calculator implements Calculatable {
    private String history = "";

    public Integer add(Integer num1, Integer num2) {
        history += num1 + " + " + num2 + " = " + (num1 + num2) + ", ";
        return num1 + num2;
    }

    public Integer subtract(Integer num1, Integer num2) {
        history += num1 + " - " + num2 + " = " + (num1 - num2) + ", ";
        return num1 - num2;
    }

    public Integer divide(Integer num1, Integer num2) {
        history += num1 + " / " + num2 + " = " + (num1 / num2) + ", ";
        return num1 / num2;
    }

    public Integer multiply(Integer num1, Integer num2) {
        history += num1 + " * " + num2 + " = " + (num1 * num2);
        return num1 * num2;
    }

    public String getHistory() {
        return history;
    }
}

class ShoppingCart extends Item {
    private List<Item> cartItems = new ArrayList<>();
    private double total;
    public double shippingCharge;

    public ShoppingCart() {
        this.total = 0;
        this.shippingCharge = 0;
    }

    public ShoppingCart(double shippingCharge) {
        if (this.total > 10.00) {
            this.shippingCharge += shippingCharge;
        } else {
            this.shippingCharge += 0;
        }

        total += total * 0.10;
    }

    public void addItem(Item item) {
        cartItems.add(item);
    }

    public void calculateTotal() {
        for (Item item : cartItems) {
            total += item.getPrice() * item.getAmount();
        }
    }

    public List<Item> getItems() {
        return this.cartItems;
    }

    public String getTotal() {
        return "$" + String.format("%.2f", this.total);
    }

    public Invoice shipOrder(String name, String address, String city, String state, int zip) {

        return new Invoice(name, address, city, state, zip, this.cartItems);
    }

}

class Invoice extends ShoppingCart {
    private String name, streetAddress, city, state;
    private int zip;
    private List<Item> cartItems;

    public Invoice(String name, String streetAddress, String city, String state, int zip, List<Item> cartItems) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        String invoice = " ";
        double total = 0;

        invoice = "\t" + this.name + "\n" + "\t" + this.streetAddress + "\n" + "\t" 
        + this.city + ", " + this.state + " " + this.zip + "\nItems\n-----\n";

        for (Item item : this.cartItems) {
            invoice += String.format(item.getName() + " " + item.getPrice() + " (" + item.getAmount() + ") " + "%.2f" + "\n", (item.getAmount() * item.getPrice()));
            total += (item.getAmount() * item.getPrice());
        }

        if (shippingCharge > 0) {
            invoice += "\nShipping: " + shippingCharge + "\n";
        } else {
            invoice += "\nShipping: " + "Free\n";
        }

        invoice += String.format("Total cost" + "\n-----\n" + "$%.2f", total);

        return invoice;
    }

}
class Item {
    private double price;
    private String name;
    private int amount;

    public Item() {
        this.price = 0;
        this.amount = 0;
        this.name = "";
    }

    public Item(double price, int amount, String name) {
        this.price = price;
        this.amount = amount;
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getName() {
        return this.name;
    }
}

abstract class Shape {
    public int length;
    public int width;

    public String draw() {
        String shape = "";
        int m = this.length;
        int n = this.width;

        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (i == 1 || i == n || 
                    j == 1 || j == m)            
                    shape += "*";
                else
                    shape += " ";            
            }
            shape += "\n";
        }
        return shape;
    }

}

class Square extends Shape {

    public Square(int area) {
        super.length = area;
        super.width = area;
    }

}

class Rectangle extends Shape {

    public Rectangle(int length, int width) {
        super.length = length;
        super.width = width;
    }

}

public class Main {
    public static void main(String[] args) {
        // ex1();
        // ex2();
        // ex3();
        // ex4();
        // ex5();
        ex6();
    }

    private static void ex1() {
        var p1 = new Person();
        var p2 = new Person("Jon", "Smith");
        var p3 = new Person("Mary", "Jane", (byte) 12, 123456789);

        System.out.println(p1.speak());
        System.out.println(p2.speak());
        System.out.println(p3.speak());

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        System.out.println("Person count: " + Person.getPersonCount());
    }

    private static void ex2() {
        System.out.println("DONE");
    }

    private static void ex3() {
        var n1 = new AwesomeNumber(4);
        var n2 = new AwesomeNumber(2);
        var result1 = AwesomeNumber.add(n1, n2);
        var result2 = AwesomeNumber.subtract(n1, n2);
        System.out.println(result1);
        System.out.println(result2);
    }

    private static void ex4() {
        var calculator = new Calculator();
        var result1 = calculator.add(1, 2);
        var result2 = calculator.subtract(4, 2);
        var result3 = calculator.divide(10, 5);
        var result4 = calculator.multiply(2, 2);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(calculator.getHistory());
    }

    private static void ex5() {
        var shoppingCart = new ShoppingCart();
        shoppingCart.addItem(new Item(2.00F, 4, "Socks"));
        shoppingCart.addItem(new Item(10.00F, 2, "Shirts"));
        shoppingCart.calculateTotal();
        var invoice = shoppingCart.shipOrder("Jon Smith", "123 Green Street", "Austin", "TX", 78737);
        System.out.println(invoice);
    }

    public static void ex6() {
        var shapes = new ArrayList<Shape>();
        shapes.add(new Square(3));
        shapes.add(new Rectangle(10,3));
        for (Shape s : shapes) {
            System.out.println(s.draw());
        }
    }
}
