import java.util.InputMismatchException;
import java.util.Scanner;
public class Solve2to12B {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        double num1 = 0, num2 = 0;
        String op = null;
        char operator = 0;
        System.out.print("연산 >> ");
        try {
            num1 = scanner.nextDouble();
            op = scanner.next();
            num2 = scanner.nextDouble();
            operator = op.charAt(0);
        } catch (InputMismatchException e) {
            System.out.println("수식이 잘못되었습니다.");
            System.exit(0);
        }
        scanner.close();
        switch (operator) {
            default:
                System.out.println("잘못된 연산자입니다.");
                System.exit(0);
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                // double형은 0으로 나누면 Arithmetic Exception 대신 infinity가 도출.
                // 따라서 예외처리를 try-catch 대신 조건문 활용
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    System.exit(0);
                }
                else result = num1 / num2;
                break;
        }
        System.out.println(num1 + "" + operator + "" + num2 + "의 계산결과는 " + result);
    }
}
