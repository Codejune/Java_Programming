import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @precondition
 * @postcondition
 *      직사각형이 Square과 충돌할 경우
 *      직사각형이 Square을 포함할 경우
 *      Square이 직사각형을 포함할 경우
 *      직사각형과 Square이 서로 떨어져 있을 경우
 *
 * Square (100, 100), (200, 200)
 */
public class Solve2to8 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Boolean check = false;
        System.out.print("두 점 (x1, y1), (x2, y2)를 빈칸으로 구분지어 입력하세요 >> ");
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        try {
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("정수를 입력하여 주세요.");
            System.exit(0);
        }
        scanner.close();
        if(x1 > x2 && y1 > y2) {
            SwapLocation(x1, y1, x2, y2);
        }
        for (int i = x1; i <= x2; i++) {
            if(check == true) break;
            if(y1 > y2) {
                for(int j = y2; j <= y1; j++) {
                    check =intRect(i, j, 100, 100, 200, 200);
                    if(check == true) break;
                }
            } else {
                for (int j = y1; j <= y2; j++) {
                    check = intRect(i, j, 100, 100, 200, 200);
                    if (check == true) break;
                }
            }
        }

        if(check == null) {
            System.out.println("검증이 이루어지지 않았습니다.");
        } else if (check == true){
            System.out.println("해당 사각형은 충돌합니다.");
        } else {
            System.out.println("해당 사각형은 충돌하지 않습니다.");
        }
    }

    public static boolean intRect(int x, int y, int rectx1, int recty1, int rectx2, int recty2) {
        if ((x >= rectx1 && x <= rectx2) && (y >= recty1 && y <= recty2))
            return true;
        return false;
    }

    public static void SwapLocation(int x1, int y1, int x2, int y2) {
        int temp = 0;
        temp = x1;
        x1 = x2;
        x2 = temp;

        temp = y1;
        y1 = y2;
        y2 = temp;
    }
}
