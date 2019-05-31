public class Circle {
    private int x, y, radius;

    private Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public static void main(String[] args) {
        Circle a = new Circle(2, 3, 5);
        Circle b = new Circle(2, 3, 30);
        System.out.println("원 a : " + a);
        System.out.println("원 b : " + b);
        if (a.equals(b))
            System.out.println("같은 원");
        else
            System.out.println("서로 다른 원");
    }

    public String toString() {
        String information = "";
        information += "Circle(" + this.x + ", " + this.y + ") 반지름 " + this.radius;
        return information;
    }

    private boolean equals(Circle obj) {
        return this.x == obj.x && this.y == obj.y;
    }
}
