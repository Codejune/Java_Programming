import java.util.InputMismatchException;
import java.util.Scanner;

public class Solve3to6 {
    public static void main(String args[]) {
        int unit[] = {50000, 10000, 1000, 500, 100, 50, 10, 1};
        int refuse[] = {0, 0, 0, 0, 0, 0, 0, 0};
        int money = 0;
        System.out.print("금액을 입력하시오 >> ");
        Scanner scanner = new Scanner(System.in);
        try {
            money = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("정수를 입력하여 주세요.");
            System.exit(0);
        }
        if(money < 0) {
            System.out.println("양수를 입력하여 주세요");
            System.exit(0);
        }
        int remain = money;

        for(int i = 0; i < unit.length; i++) {
            refuse[i] = remain / unit[i];
            remain = remain % unit[i];
            if(refuse[i] == 0) {
                continue;
            }
            System.out.println(unit[i] + "원 짜리 : " + refuse[i]);
        }
    }
}
