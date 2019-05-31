import java.util.InputMismatchException;
import java.util.Scanner;

public class Solve3to4 {
    public static void main(String args[]) {
        char character = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("소문자 알파벳 하나를 입력하시오 >> ");
        character = scanner.next().charAt(0);
        if(97 <= character && character <= 122) {
            int count = (int)character;
            for(int i = 'a'; i <= character; i++) {
                for(int j = 'a'; j <= count; j++) {
                    System.out.print((char)j +" ");
                }
                count--;
                System.out.println();
            }
        } else {
            System.out.println("소문자를 입력하여 주세요.");
        }
    }
}
