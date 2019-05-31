interface Shape {
    final double PI = 3.14;
    void draw();
    double getArea();
    default public void redraw() {
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape {
    private double radius;
    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름이 " + radius + "인 원입니다.");
    }

    @Override
    public double getArea() {
        return radius * radius * PI;
    }
}

class Oval implements Shape {
    double x, y;
    Oval(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw() {
        System.out.println(x + "*" + y + "에 내접하는 원입니다.");
    }

    @Override
    public double getArea() {
        return x * y * PI;
    }
}

class Rect implements Shape {
    double x, y;
    Rect(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw() {
        System.out.println(x + "*" + y + "크기의 사각형입니다.");
    }

    @Override
    public double getArea() {
        return x * y;
    }
}

public class Figure {
    public static void main(String[] args) {
        // 13번
        Shape donut = new Circle(10);
        donut.redraw();
        System.out.println("면적은 " + donut.getArea());

        //14번
        Shape[] list  = new Shape[3];
        list[0] = new Circle(10);
        list[1] = new Oval(20, 30);
        list[2] = new Rect(10, 40);

        for(int i = 0; i < list.length; i++)
            list[i].redraw();
        for(int i = 0; i < list.length; i++)
            System.out.println("면적은 " + list[i].getArea());
    }
}
