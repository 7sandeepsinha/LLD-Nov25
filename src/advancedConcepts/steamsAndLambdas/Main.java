package advancedConcepts.steamsAndLambdas;

public class Main {
    public static void main(String[] args) {
        Vehicle fourWheeler = new FourWheeler();
        fourWheeler.start();
        fourWheeler.run();
        fourWheeler.brake();

        Vehicle twoWheeler = new Vehicle() {
            public void run() {
                System.out.println("Run Two wheeler");
            }

            public void start(){
                System.out.println("Start Two wheeler");
            }

            public void brake(){
                System.out.println("Brake Two wheeler");
            }
        };

        twoWheeler.start();
        twoWheeler.run();
        twoWheeler.brake();

        Demo anonymousAbsObj = new Demo() { // anonymous class will also work with abstract classes if we implement the abstract method
            public void absDoSomething(){
                System.out.println("Abstract do something");
            }
        };

        anonymousAbsObj.absDoSomething();
        anonymousAbsObj.doSomething();

        //print helloworld from a different thread
        //version1
        HelloWorldPrinter hwpObj = new HelloWorldPrinter();
        Thread t1 = new Thread(hwpObj);
        t1.start();

        Thread t = new Thread(new HelloWorldPrinter());
        t.start();

        //version2 -> anonymous class
        Runnable hwp = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world, " + Thread.currentThread().getName());
            }
        };
        Thread t2 = new Thread(hwp);
        t2.start();

        //version3 -> FI and anonymous class -> Lambdas
        Runnable hwp1 = () -> {
                System.out.println("Hello world, " + Thread.currentThread().getName());
            };
        Thread t3 = new Thread(hwp1);
        t3.start();

        //version 4 ->
        Thread t4 = new Thread( () ->  System.out.println("Hello world, " + Thread.currentThread().getName()));
        t4.start();

        //Instructor implementation with Anonymous class
        Instructor<String> i1 = new Instructor<String>() {
            @Override
            public void teach(int numberOfStudents, String topic) {
                System.out.println("Teaching " + numberOfStudents + " students of " + topic);
            }
        };
        i1.teach(100, "LLD");

        //Instructor implementation with Lambda
        Instructor<String> i2 = (int numberOfStudents, String topic) -> {
            System.out.println("Teaching " + numberOfStudents + " students of " + topic);
        };
        i2.teach(100, "LLD");

        //Instructor implementation with Lambda, with lesser code
        Instructor<String> i3 = (x, y) -> // ideally keep the variable names same here as in the interface - (numberOfStudents, topic)
            System.out.println("Teaching " + x + " students of " + y);
        i3.teach(100, "LLD");
        // i3.teach("LLD", 100); // need to maintain the order of the parameters during input

        //Instructor with multi-line implementation
        //Instructor implementation with Anonymous class
        Instructor<String> i4 = new Instructor<String>() {
            public void teach(int numberOfStudents, String topic) {
                System.out.println("Instructor will take a test");
                System.out.println("Instructor will take a viva");
                System.out.println("Teaching " + numberOfStudents + " students of " + topic);
            }
        };
        i4.teach(100, "LLD");

        //Instructor implementation with Lambda
        Instructor<String> i5 = (numberOfStudents, topic) -> {
            System.out.println("Instructor will take a test");
            System.out.println("Instructor will take a viva");
            System.out.println("Teaching " + numberOfStudents + " students of " + topic);
        };
        i5.teach(100, "LLD");

        //Calculator with multi-line implementation with anonymous class
        Calculator multiplier = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                int result = a * b;
                System.out.println(result);
                return result;
            };
        };
        int result = multiplier.calculate(10,15);

        //Calculator with multi-line implementation with lambda
        Calculator multiplier2 = (a, b) -> {
            int r = a * b;
            System.out.println(r);
            return r;
        };
        multiplier2.calculate(10,15);

        //Calculator with single-line implementation with anonymous class
        Calculator adder = new Calculator() {
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Answer " + adder.calculate(10,15));

        //Calculator with single-line implementation with lambda
        Calculator adder2 = (a,b) -> a+b;
        System.out.println("Answer " + adder2.calculate(10,15));

    }
}
/*
if(true){
            System.out.println("Line 1");
            System.out.println("Line 2");
            System.out.println("Line 3");
}

if(true)
    System.out.println("Line 4"); // if single line, no need for curly braces
 */