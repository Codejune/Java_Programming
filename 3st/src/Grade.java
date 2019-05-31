import java.util.InputMismatchException;
import java.util.Scanner;
public class Grade {
    private static int math;
    private static int science;
    private static int english;
    private Grade(int math, int science, int english) {
        Grade.math = math;
        Grade.science = science;
        Grade.english = english;
    }
    private int average() {
        return (math + science + english) / 3;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력 >> ");
        try {
            Grade.math = scanner.nextInt();
            Grade.science = scanner.nextInt();
            Grade.english = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("숫자만 입력하여 주세요.");
            System.exit(-1);
        }
        Grade me = new Grade(math, science, english);
        System.out.println("평균은 " + me.average());
        scanner.close();
    }
}