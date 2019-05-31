import java.util.Scanner;

abstract class Shape {
    private Shape next;
    public Shape() {next = null;}
    public void setNext(Shape obj) {next = obj;}
    public Shape getNext() { return next;}
    public abstract void draw();
}

class Line extends Shape {
    Line() {
        super();
    }
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}
public class GraphEditor {
    private Shape start;
    private GraphEditor() {
        this.start = null;
    }
    public static void main(String[] args) {
        int input;
        GraphEditor graphEditor = new GraphEditor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("그래픽 에디터 beauty를 실행합니다.");
        while (true) {
            int select;
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3) >> ");
                    select = scanner.nextInt();
                    graphEditor.Insert(select);
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치(1~) >> ");
                    select = scanner.nextInt();
                    if(select <= 0) {
                        System.out.println("삭제할 수 없습니다.");
                        break;
                    }
                    graphEditor.Delete(select);
                    break;
                case 3:
                    graphEditor.Print();
                    break;
                case 4:
                    System.out.println("beauty를 종료합니다.");
                    System.exit(-1);
                    break;
            }
        }
    }

    private void Insert(int select) {
        Shape temp = start;
        switch (select) {
            case 1:
                if(start != null) {
                    while (temp.getNext() != null) {
                        temp = temp.getNext();
                    }
                    temp.setNext(new Line());
                } else
                    start = new Line();
                break;
            case 2:
                if(start != null) {
                    while (temp.getNext() != null) {
                        temp = temp.getNext();
                    }
                    temp.setNext(new Rect());
                } else
                    start = new Rect();
                break;
            case 3:
                if(start != null) {
                    while (temp.getNext() != null) {
                        temp = temp.getNext();
                    }
                    temp.setNext(new Circle());
                } else
                    start = new Circle();
                break;
        }
    }

    private void Delete(int select) {
            Shape temp = start;
            if(Check(select)) {
                if(select == 1) {
                    start = temp.getNext();
                } else {
                    for (int i = 1; i < select - 1; i++) {
                        temp = temp.getNext();
                    }
                    temp.setNext(temp.getNext().getNext());
                }
            }
    }

    private boolean Check(int select) {
        Shape temp = start;
        for(int i = 1; i < select; i++) {
            temp = temp.getNext();
        }
        if(temp == null) {
            System.out.println("삭제할 수 없습니다.");
            return false;
        }
        return true;
    }

    private void Print() {
        Shape temp = start;
        if(temp == null) {
            System.out.println("삽입한 도형이 없습니다");
        } else {
            while (temp != null) {
                temp.draw();
                temp = temp.getNext();
            }
        }
    }
}
