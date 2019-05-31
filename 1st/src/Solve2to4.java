import java.util.InputMismatchException;
import java.util.Scanner;
public class Solve2to4 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        System.out.print("정수 3개 입력 >> ");
        try {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력하여 주세요.");
            System.exit(0);
        }
        scanner.close();
        int min = 0, mid = 0, max = 0;
        if (a == b && b == c) {
            System.out.println("세 정수의 값이 모두 같습니다.");
            System.exit(0);
        } else if (a == b || b == c || a == c) {
            System.out.println("같은 값을 가진 두 정수가 있습니다");
            System.exit(0);
        } else {
            if (a > b) {
                max = a;
                if (b > c) {    // a > b > c
                    mid = b;
                    min = c;
                } else {        // a > c > b
                    mid = c;
                    min = b;
                }
            } else if (b > c) {
                max = b;
                if (c > a) {    // b > c > a
                    mid = c;
                    min = a;
                } else {        // b > a > c
                    mid = a;
                    min = c;
                }
            } else if (c > a) {
                max = c;
                if (a > b) {    // c > a > b
                    mid = a;
                    min = b;
                } else {        //c > b > a
                    mid = b;
                    min = a;
                }
            }
        }
        System.out.println("중간값은 " + mid);
    }
}
