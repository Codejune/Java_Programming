import java.util.InputMismatchException;
import java.util.Scanner;

public class Solve2to2 {
    public static void main(String args[]) {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.print("2자리수 정수 입력(10~99) >> ");
            int number = scanner.nextInt();
            scanner.close();
            if (number > 99 || number < 10) {
                System.out.println("범위를 벗어난 입력입니다.");
                main(args);
            } else if (number / 10 == number % 10) {
                System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
            } else {
                System.out.println("No! 10의 자리와 1의 자리가 같지 않습니다.");
            }
        }catch (InputMismatchException e) {
            System.out.println("정수를 입력해주세요.");
            System.exit(0);
        }
    }
}
