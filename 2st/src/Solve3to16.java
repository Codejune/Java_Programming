import java.util.Scanner;

public class Solve3to16 {
    public static void main(String args[]) {
        String rule[] = {"가위", "바위", "보"};
        String input = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
        while(!(input.equals("그만"))) {
            int computer = (int)(Math.random()*3);
            System.out.print("가위 바위 보! >> ");
            input = scanner.next();
            switch (input) {
                default:
                    System.out.println("가위, 바위, 보, 그만 중에 하나를 입력하여 주세요.");
                    break;
                case "가위" :
                    if(rule[computer].equals("가위")) {
                        System.out.println("사용자 = " + input + " , 컴퓨터 = " + rule[computer] + " , 비겼습니다.");
                    } else if(rule[computer].equals("바위")) {
                        System.out.println("사용자 = " + input + " , 컴퓨터 = " + rule[computer] + " , 컴퓨터가 이겼습니다.");
                    } else {
                        System.out.println("사용자 = " + input + " , 컴퓨터 = " + rule[computer] + " , 사용자가 이겼습니다.");
                    }
                    break;
                case "바위" :
                    if(rule[computer].equals("바위")) {
                        System.out.println("사용자 = " + input + " , 컴퓨터 = " + rule[computer] + " , 비겼습니다.");
                    } else if(rule[computer].equals("보")) {
                        System.out.println("사용자 = " + input + " , 컴퓨터 = " + rule[computer] + " , 컴퓨터가 이겼습니다.");
                    } else {
                        System.out.println("사용자 = " + input + " , 컴퓨터 = " + rule[computer] + " , 사용자가 이겼습니다.");
                    }
                    break;
                case "보" :
                    if(rule[computer].equals("보")) {
                        System.out.println("사용자 = " + input + " , 컴퓨터 = " + rule[computer] + " , 비겼습니다.");
                    } else if(rule[computer].equals("가위")) {
                        System.out.println("사용자 = " + input + " , 컴퓨터 = " + rule[computer] + " , 컴퓨터가 이겼습니다.");
                    } else {
                        System.out.println("사용자 = " + input + " , 컴퓨터 = " + rule[computer] + " , 사용자가 이겼습니다.");
                    }
                    break;
                case "그만":
                    System.exit(0);
            }
        }
    }
}
