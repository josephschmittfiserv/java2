import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // ex1();
        // ex2();
        // ex3();
        // ex4();
        ex5();
    }

    static class Person extends Animal{
        private String firstName;
        private String lastName;
        private int social;
        private static int count;

        public Person(){
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
            }
            else if (getFirstName() != "" && getLastName() != "" && getAge() != 0 && getSocial() == 0) {
                introduction = "My name is " + getFirstName() + " " + getLastName() + 
                " and I am " + getAge() + " years old.";
            }
            else if (getFirstName() != "" && getLastName() != "" && getAge() == 0 && getSocial() == 0) {
                introduction = "My name is " + getFirstName() + " " + getLastName() + ".";
            }
            else if (getFirstName() != "" && getLastName() == "" && getAge() == 0 && getSocial() == 0) {
                introduction = "My name is " + getFirstName();
            }
            else if (getFirstName() == "" && getLastName() == "" && getAge() == 0 && getSocial() == 0) {
                introduction = "I dont have a name.";
            }
            else if (getFirstName() != "" && getLastName() != "" && getAge() == 0 && getSocial() != 0) {
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
            }
            else if (getFirstName() != "" && getLastName() != "" && getAge() == 0 && getSocial() == 0) {
                return result = "My name is " + getFirstName() + " " + getLastName() + ".";
            }
            else if (getFirstName() != "" && getLastName() != "" && getAge() != 0 && getSocial() != 0) {
                return result = "My name is " + getFirstName() + " " + getLastName() + " " + getSocial()%10000;
            }

            return result;
        }
    }

    public static class Animal {
        private byte age;
    }

    public static class Dog extends Animal {
        public Dog(byte n) {
            super.age = n;
        }
    }

    public static class Cat extends Animal {}

    public static class AwesomeNumber {
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

    public interface Calculatable {

        Integer add(Integer number1, Integer number2);
        Integer subtract(Integer number1, Integer number2);
        Integer multiply(Integer number1, Integer number2);
        Integer divide(Integer number1, Integer number2);
    
        String getHistory();
    }

    public static class Calculator implements Calculatable {
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

    public static class ShoppingCart extends Item{
        private static List<Item> cartItems = new ArrayList<>();
        private static double total;

        public static void addItem(Item item) {
            cartItems.add(item);
        }

        public static void calculateTotal() {

            for (Item item : cartItems) {
                total += item.getPrice() * item.getAmount();
            }
        }

        public static String getTotal() {
            return "$" + String.format("%.2f", total);
        }
    }

    public static class Item {
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
            return price;
        }

        public int getAmount() {
            return amount;
        }

        public String getName() {
            return name;
        }
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
        var calculator =  new Calculator();
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
        System.out.println(shoppingCart.getTotal());
    }
}
