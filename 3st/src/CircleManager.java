import java.util.InputMismatchException;
import java.util.Scanner;
class Circle {
    private double x, y;
    private int radius;
    Circle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    int area() {
        return this.radius * this.radius;
    }
    void show() {
        System.out.println("(" + x + ", " + y + ")" + radius);
    }
}
public class CircleManager {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double x;
        double y;
        int radius;
        Circle[] c = new Circle[3];
        for(int i = 0; i < c.length; i++) {
            System.out.print("x, y, radius >> ");
            try {
                x = scanner.nextDouble();
                y = scanner.nextDouble();
                radius = scanner.nextInt();
                c[i] = new Circle(x, y, radius);
            } catch (InputMismatchException e) {
                System.out.println("x, y는 실수로, radius는 정수로 입력하여 주세요.");
                scanner.nextLine();
                i--;
            }
        }
        CompareArea(c[0], c[1], c[2]);
    }
    private static void CompareArea(Circle a, Circle b, Circle c) {
        if (a.area() == b.area() && b.area() == c.area()) {
            System.out.println("세 원의 면적이 모두 같습니다.");
        } else if (a.area() == b.area() || b.area() == c.area() || a.area() == c.area()) {
            System.out.println("같은 면적을 가진 두개의 원이 있습니다");
        } else {
            if (a.area() > b.area()) {
                System.out.print("가장 면적이 큰 원은 ");
                a.show();
            } else if (b.area() > c.area()) {
                System.out.print("가장 면적이 큰 원은 ");
                b.show();
            } else if (c.area() > a.area()) {
                System.out.print("가장 면적이 큰 원은 ");
                c.show();
            }
        }
    }
}
