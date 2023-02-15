package org.example;

import java.util.ArrayList;
import java.util.List;

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








    }
}