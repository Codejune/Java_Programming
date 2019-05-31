import java.util.Scanner;
abstract class Converter {
    abstract protected double convert(double src); // 추상 메소드
    abstract protected String getSrcString();
    abstract protected String getDestString();
    protected double ratio;
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getSrcString() + "을 " + getDestString() + "로 바꿉니다.");
        System.out.print(getSrcString() + "을 입력하세요 >> ");
        Double val = scanner.nextDouble();
        Double res = convert(val);
        System.out.println("변환 결과 : " + res + getDestString() + "입니다");
        scanner.close();
    }
}
public class Won2Dollar extends Converter{
    String src = "원";
    String dest = "달러";
    public Won2Dollar(double ratio) {
        this.ratio = ratio;
    }
    public static void main(String[] args) {
        Won2Dollar toDollar = new Won2Dollar(1200); // 1달러 = 1200원
        toDollar.run();
    }
    protected double convert(double src) {
        return src / ratio;
    }

    protected String getSrcString() {
        return src;
    }
    protected String getDestString() {
        return dest;
    }
}
