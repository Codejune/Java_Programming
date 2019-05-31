import java.util.Scanner;

public class Solve3to14 {
    public static void main(String args[]) {
        String course[] = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
        int score[] = {95, 88, 76, 62, 55};
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!(input.equals("그만"))) {
            System.out.print("과목 이름 >> ");
            input = scanner.next();
            switch (input) {
                default:
                    System.out.println("없는 과목입니다.");
                    break;
                case "Java":
                    System.out.println(course[0] + "의 점수는 " + score[0]);
                    break;
                case "C++":
                    System.out.println(course[1] + "의 점수는 " + score[1]);
                    break;
                case "HTML5":
                    System.out.println(course[2] + "의 점수는 " + score[2]);
                    break;
                case "컴퓨터구조":
                    System.out.println(course[3] + "의 점수는 " + score[3]);
                    break;
                case "안드로이드":
                    System.out.println(course[4] + "의 점수는 " + score[4]);
                    break;
                case "그만":
                    System.exit(0);
            }
        }
    }
}
