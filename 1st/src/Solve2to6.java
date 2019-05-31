import java.util.InputMismatchException;
import java.util.Scanner;
public class Solve2to6 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1~99 사이의 정수를 입력하세요 >> ");
        int num = 0;
        try {
            num = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("정수를 입력하여 주세요.");
            System.exit(0);
        }
        scanner.close();
        int count = 0;
        if (num < 0 || num > 99) {
            System.out.println("입력한 값이 범위를 초과하였습니다.");
            System.exit(0);
        } else if (num < 10) {
            if(num == 3 || num == 6 || num == 9) count++;
        } else {
            int tenposition = num / 10;
            int oneposition = num % 10;
            if (tenposition == 3 || tenposition == 6 || tenposition == 9) count++;
            if (oneposition == 3 || oneposition == 6 || oneposition == 9) count++;
        }
        System.out.print("박수");
        for(int i = 0; i < count; i++) {
            System.out.print("짝");
        }
    }
}
