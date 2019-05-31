import java.util.InputMismatchException;
import java.util.Scanner;
class Person {
    private String name;
    Person() { this(null); }
    Person(String name) { this.name = name; }
    String getName() { return this.name; }
    void setName(String name) { this.name = name; }
}

public class ReservationProgram {
    private static Person[][] seat = new Person[3][10];
    private static Scanner scanner = new Scanner(System.in);
    private static int reservation_count = 0;
    public static void main(String args[]) {
        int menu_input;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                seat[i][j] = new Person();
            }
        }
        while (true) {
            System.out.println("명품콘서트홀 예약 시스템입니다.");
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
            try {
                menu_input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴 선택입니다. 다시입력하여 주세요.");
                scanner.nextLine();
                continue;
            }
            switch (menu_input) {
                default:
                    System.out.println("잘못된 메뉴 선택입니다. 다시입력하여 주세요.");
                    break;
                case 1:
                    ReservationProgram.Reservation();
                    break;
                case 2:
                    ReservationProgram.PrintSeat();
                    break;
                case 3:
                    ReservationProgram.RemoveReservation();
                    break;
                case 4:
                    System.exit(-1);
            }
        }
    }

    private static void Reservation() {
        int layer;
        int seat_num;
        String name;
        boolean condition = false;
        while (!condition) {
            layer = ReservationProgram.selectLayer();
            System.out.print("이름 >> ");
            name = scanner.next();
            seat_num = ReservationProgram.selectSeat();
            if (ReservationProgram.isExist(seat[layer - 1][seat_num - 1])) {
                System.out.println("이미 예약된 좌석입니다. 다른 좌석을 선택하여주세요.");
                condition = false;
            } else {
                condition = true;
                seat[layer - 1][seat_num - 1] = new Person(name);
                reservation_count++;
            }
        }
    }

    private static void RemoveReservation() {
        int layer;
        String name;
        boolean condition = false;
        if (reservation_count == 0) return;
        layer = ReservationProgram.selectLayer();
        System.out.print("이름 >> ");
        name = scanner.next();
        for (int i = 0; i < 10; i++) {
            if (name.equals(seat[layer - 1][i].getName())) {
                seat[layer - 1][i].setName(null);
                reservation_count--;
                condition = true;
            }
        }
        if (!condition) System.out.println("해당 이름으로 등록된 좌석을 찾을 수 없습니다.");
    }

    private static boolean isExist(Person seat) { return (seat.getName() != null); }
    private static int selectLayer() {
        int layer;
        while (true) {
            System.out.print("좌석구분 S(1), A(2), B(3) >> ");
            try {
                layer = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴 선택입니다. 다시입력하여 주세요.");
                scanner.nextLine();
                continue;
            }
            if (layer < 1 || layer > 3) {
                System.out.println("잘못된 메뉴 선택입니다. 다시입력하여 주세요.");
            } else {
                break;
            }
        }
        return layer;
    }

    private static int selectSeat() {
        int seat_num;
        while (true) {
            System.out.print("번호 >> ");
            try {
                seat_num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴 선택입니다. 다시입력하여 주세요.");
                scanner.nextLine();
                continue;
            }
            if (seat_num < 1 || seat_num > 10) System.out.println("잘못된 좌석 선택입니다. 다시입력하여 주세요.");
            else break;
        }
        return seat_num;
    }

    private static void PrintSeat() {
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    System.out.print("S >> ");
                    break;
                case 1:
                    System.out.print("A >> ");
                    break;
                case 2:
                    System.out.print("B >> ");
                    break;
            }
            for (int j = 0; j < 10; j++) {
                if (seat[i][j].getName() == null) System.out.print("___ ");
                else System.out.print(seat[i][j].getName() + " ");
            }
            System.out.println();
        }
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }
}
