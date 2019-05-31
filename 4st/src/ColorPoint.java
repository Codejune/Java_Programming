class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    protected void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ColorPoint extends Point{
    private String color = "BLACK";

    public static void main(String[] args) {
        // 5번
        ColorPoint cp1 = new ColorPoint(5, 5, "YELLOW");
        cp1.setXY(10, 20);
        cp1.setColor("RED");
        String str = cp1.toString();
        System.out.println(str + "입니다.");

        // 6번
        ColorPoint zeroPoint = new ColorPoint();
        System.out.println(zeroPoint.toString());

        ColorPoint cp2 = new ColorPoint(5, 5);
        cp2.setXY(5, 5);
        cp2.setColor("RED");
        System.out.println(cp2.toString() + "입니다.");
    }

    private ColorPoint() {
        super(0, 0);
    }

    private ColorPoint(int x, int y) {
        super(x, y);
    }

    private ColorPoint(int x, int y, String color) {
        super(x, y);
        this.color = color;
    }

    private void setXY(int x, int y) {
        move(x, y);
    }

    public String toString() {
        String string = "";
        string += color + "색의 (" + getX() + ", " + getY() + ")의 점";
        return string;
    }

    private void setColor(String color) {
        this.color = color;
    }
}
