import java.util.Scanner;

class Person {
    private String name;
    Person(String name) { this.name = name; }
    String getName() { return this.name; }
}

public class GamblingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean result = false;
        System.out.print("겜블링 게임에 참여할 선수 숫자 >> ");
        int num = scanner.nextInt();
        Person[] player = new Person[num];
        for (int i = 0; i < num; i++) {
            System.out.print((i+1) + "번째 선수 이름 >> ");
            String name = scanner.next();
            player[i] = new Person(name);
        }
        while (!result) result = Gambling(player);
    }

    private static boolean Gambling(Person[] player) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("[" + player[i].getName() + "] : <Enter> ");
            scanner.nextLine();
            int first = (int) (Math.random() * 3) + 1;
            int second = (int) (Math.random() * 3) + 1;
            int third = (int) (Math.random() * 3) + 1;
            if (first == second && second == third) {
                System.out.println(first + " " + second + " " + third + " " + player[i].getName() + "님이 이겼습니다.");
                return true;
            } else System.out.println(first + " " + second + " " + third + " 아쉽군요!");
        }
        return false;
    }
}
