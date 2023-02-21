package org.example;

import javax.swing.*;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

interface Drawable{
    public void draw();
}
interface Sayable{
    public String say();
}
interface Sayable2{
    public String say(String name);
}
interface Addable{
    int add(int a, int b);
}

interface Sayable3{
    String say(String message);
}

@FunctionalInterface
interface Drawable2 {
    public void draw();
}

class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price){
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
public class Main {
    public static void main(String[] args) {
        int width = 10;

        //without lambda, Drawable implementataion using anonymous class
        Drawable d = new Drawable() {
            @Override
            public void draw() {

                System.out.println("Drawing: " + width);
            }
        };
        d.draw();

        // lambda
        Drawable2 d2 = () -> {
            System.out.println("Drawing2 : " + width);
        };
        d2.draw();

        // Lambda: No Parameter
        Sayable s=() -> {
            return "I have nothing to say.";
        };
        System.out.println(s.say());

        // Lambda Single Parameter
        Sayable2  s1 = (name) -> {
          return "Hello, " + name;
        };
        // 위의 것을 method로 변경
        Sayable2 javaS = new Sayable2() {
            @Override
            public String say(String name) {
                return "Hello, " + name;
            }
        };
        System.out.println(s1.say("heeya"));
        System.out.println(javaS.say("heeya"));
        //함수 괄호를 생략할 수 있습니다.
        //You can omit function parentheses.
        Sayable2 s2 = name -> {
            return "Hello, " + name;
        };
        System.out.println(s2.say("heeya"));

        //Multiple Parameters
        //Multiple parameters in lambda expression
        //람다 식의 여러 매개변수
        Addable ad1 = (a, b) -> (a + b);
        System.out.println(ad1.add(10, 20));

        //Multiple parameters with data type in lambda expression
        //람다 표현식의 데이터 유형이 있는 여러 매개변수
        Addable ad2 = (int a, int b) -> (a + b);
        // int to String
        Addable ad3 = (int a, int b) -> {
            String resultStr = Integer.toString(a) + Integer.toString(b);
            return Integer.parseInt(resultStr) ;
        };
        System.out.println(ad2.add(100, 200));
        System.out.println(ad3.add(3, 4));

        // with or without return keyword
        Addable ad4 = (a, b) -> a + b;
        System.out.println(ad4.add(5, 6));
        // Lambda expression with return keyword
        Addable ad6 = (int a, int b)->{
            return (a + b);
        };
        System.out.println(ad6.add(7, 8));

        //Foreach Loop
        List<String> list = new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(
                (n)->System.out.println(n)
        );

        //Multiple Statements
        //You can pass multiple statements in lambda expression
        Sayable3 person = (message) -> {
            String str1 = "I would like to say, ";
            String str2 = str1 + message;
            return str2;
        };
        Sayable3 anotherPerson = data -> {
            String str1 = data + " , what ????";
            return str1;
        };
        System.out.println(person.say("time is precious"));
        System.out.println(anotherPerson.say("I want to go hotplace"));

        //Creating Thread
        //람다 식을 사용하여 스레드를 실행할 수 있습니다. 다음 예제에서는 람다 식을 사용하여 run 메서드를 구현합니다.
        //You can use lambda expression to run thread. In the following example, we are implementing run method by using lambda expression.

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 is running");
            }
        };
        Thread t1 =  new Thread(r1);
        t1.start();
        //Thread Example with lambda
        Runnable r2=()->{
            System.out.println("Thread2 is running");
        };
        Thread t2 =  new Thread(r2);
        t2.start();

        //comparator
        List<Product> plist = new ArrayList<Product>();

        //adding products
        plist.add(new Product(1, "HP Laptop", 25000f));
        plist.add(new Product(3, "keyboard", 300f));
        plist.add(new Product(2, "Dell Mouse", 150f));

        System.out.println("Sorting on the basis of name...");

        //implementing lambda expression
        Collections.sort(plist,(p1,p2) -> {
            return p1.name.compareTo(p2.name); // compareTo 를 해야 mixing된다.
        });


        for(Product p:plist){
            System.out.println(p.id + " " + p.name + " " + p.price);
        }

        //filter Collection data
        List<Product> flist = new ArrayList<Product>();
        flist.add(new Product(1, "Samsung A5", 17000f));
        flist.add(new Product(3, "Iphone 6S", 65000f));
        flist.add(new Product(2, "Sony Xperia", 25000f));
        flist.add(new Product(4, "Nokia Lumia", 15000f));
        flist.add(new Product(5, "Redmi4", 26000f));
        flist.add(new Product(6, "Lenevo Vibe", 19000f));

        //using lambda to filter data
        Stream<Product> filtered_data = flist.stream().filter(p-> p.price > 20000);
        //using lambda to iterate through collection
        filtered_data.forEach(
                product -> System.out.println(product.name + ": " + product.price)
        );
        //Event Listener
        JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        JButton b = new JButton("click");
        b.setBounds(80,100,70,30);

        //lambda expression implementing here
        b.addActionListener(e-> {tf.setText("hello swing");});
        JFrame f = new JFrame();
        f.add(tf);f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(300,200);
        f.setVisible(true);














    }
}