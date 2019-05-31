import java.util.InputMismatchException;
import java.util.Scanner;

public class Solve3to8 {
    public static void main(String args[]) {
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 몇개? ");
        try {
            num = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력하세요");
        }
        if(num < 0) {
            System.out.println("양수를 입력하여 주세요");
            System.exit(0);
        } else if (num >= 100) {
            System.out.println("100보다 작은 정수를 입력하여 주세요.");
            System.exit(0);
        }

        int array[] = new int[num];
        for(int i = 0; i < num; i++) {
            array[i] = (int) (Math.random() * 100);
            for(int j = 0; j < i; j++) {
                if(array[i] == array[j]) {
                    i--;
                }
            }
        }
        for(int i = 0; i < num; i++) {
            System.out.print(array[i] + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }

    }
}
