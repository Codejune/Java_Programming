import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class Player {
    private String name;
    private int time;

    Player(String name) {
        this.name = name;
    }

    void setTime(int time) {
        this.time = time;
    }

    String getName() {
        return this.name;
    }

    int getTime() {
        return this.time;
    }

    public String toString() {
        return this.name + "의 결과 " + this.time;
    }
}

public class TimeMatchGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] player = new Player[2];
        String[] name = {"황기태", "이재문"};
        for (int i = 0; i < 2; i++) {
            player[i] = new Player(name[i]);
        }
        System.out.println("10초에 가까운 사람이 이기는 게임입니다.");
        int count = 0;
        int firsttime = 0;
        int secondtime;
        for (int i = 1; i <= 4; i++) {
            if (i % 2 == 1) {
                System.out.print(player[count].getName() + " 시작 <Enter> >>");
                scanner.nextLine();
                firsttime = Integer.parseInt(TimeMatchGame.getSecond());
                System.out.println("현재 초 시간 = " + firsttime);
            }
            if (i % 2 == 0) {
                System.out.print("10초 예상 후 <Enter>키 >>");
                scanner.nextLine();
                secondtime = Integer.parseInt(TimeMatchGame.getSecond());
                System.out.println("현재 초 시간 = " + secondtime);
                if (secondtime < firsttime) {
                    secondtime += 60;
                }
                int result = secondtime - firsttime;
                player[count].setTime(result);
                count++;
            }
        }
        compareTime(player);
    }

    private static String getSecond() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat timeout = new SimpleDateFormat("ss");
        return timeout.format(cal.getTime());
    }

    private static void compareTime(Player[] player) {
        int firstplayer = Math.abs(10 - player[0].getTime());
        int secondplayer = Math.abs(10 - player[1].getTime());

        if (firstplayer == secondplayer)
            System.out.println(player[0] + ", " + player[1] + ", 무승부입니다.");
        else if (firstplayer < secondplayer)
            System.out.println(player[0] + ", " + player[1] + ", 승자는 " + player[0].getName());
        else
            System.out.println(player[0] + ", " + player[1] + ", 승자는 " + player[1].getName());
    }
}
