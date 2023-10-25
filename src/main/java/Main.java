public class Main {
    public static void main(String[] args) {
        ex1();
        // ex2();
        // ex3();
        // ex4();
        // ex5();
    }

    static class Person {
        private String firstName;
        private String lastName;
        private byte age;
        private int social;
        private static int count;

        public Person(){
            this.firstName = "";
            this.lastName = "";
            this.age = 0;
            this.social = 0;
            count++;
        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = 0;
            this.social = 0;
            count++;
        }

        public Person(String firstName, String lastName, byte age, int social) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
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
            return this.age;
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
        System.out.println("Todo...");
    }

    private static void ex3() {
        System.out.println("Todo...");
    }

    private static void ex4() {
        System.out.println("Todo...");
    }

    private static void ex5() {
        System.out.println("Todo....");
    }
}
