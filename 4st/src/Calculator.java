import java.util.Scanner;

abstract class Calc {
    int a, b;
    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    abstract int calculate();
}

class Add extends  Calc {
    @Override
    int calculate() {
        return a + b;
    }
}
class Sub extends Calc {
    @Override
    int calculate() {
        return a - b;
    }
}
class Mul extends Calc {
    @Override
    int calculate() {
        return a * b;
    }
}
class Div extends Calc {
    @Override
    int calculate() {
        return a / b;
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("두 정수와 연산자를 입력하세요 >> ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String op = scanner.next();
        switch (op) {
            case "+":
                Add add = new Add();
                add.setValue(a, b);
                System.out.println(add.calculate());
                break;
            case "-":
                Sub sub = new Sub();
                sub.setValue(a, b);
                System.out.println(sub.calculate());
                break;
            case "*":
                Mul mul = new Mul();
                mul.setValue(a, b);
                System.out.println(mul.calculate());
                break;
            case "/":
                Div div = new Div();
                div.setValue(a, b);
                System.out.println(div.calculate());
                break;
        }
    }
}
