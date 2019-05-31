import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @precondition
 * @postcondition
 *      두 원이 충돌할 경우
 *      한 원이 다른 한원을 포함 할 경우
 *      두 원이 서로 충돌하지 않을 경우
 */
public class Solve2to10 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x1 = 0, y1 = 0, radius1 = 0, x2 = 0, y2 = 0, radius2 = 0;
        try {
            System.out.print("첫번째 원의 중심과 반지름 입력 >> ");
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            radius1 = scanner.nextInt();
            System.out.print("두번째 원의 중심과 반지름 입력 >> ");
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
            radius2 = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("정수를 입력하여 주세요.");
            System.exit(0);
        }
        scanner.close();
        if (x1 > x2 && y1 > y2) {
            SwapLocation(x1, y1, radius1, x2, y2, radius2);
        }
        if(CheckCircleCrash(x1, y1, radius1, x2, y2, radius2) == true) {
            System.out.print("두 원은 서로 겹친다");
        } else {
            System.out.print("두 원은 서로 겹치지 않는다.");
        }
    }
    public static boolean CheckCircleCrash(int x1, int y1, int radius1, int x2, int y2, int radius2) {
        if(Math.sqrt(Math.pow((x2 - x1),2) + Math.pow((y2 - y1),2)) > radius1 + radius2) {
            return false;
        }
        return true;
    }
    public static void SwapLocation(int x1, int y1, int radius1, int x2, int y2, int radius2) {
        int temp = 0;
        temp = x1;
        x1 = x2;
        x2 = temp;
        temp = y1;
        y1 = y2;
        y2 = temp;
        temp = radius1;
        radius1 = radius2;
        radius2 = temp;
    }
}
