class TV {
    private int size;
    TV(int size) { this.size = size; }
    protected int getSize() { return size; }
}

class ColorTV extends TV{
    private int color;
    ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }
    private void printProperty() {
        System.out.println(super.getSize() + "인치 " + color + "컬러");
    }
    public static void main(String[] args) {
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();
    }
    public int getColor() { return color; }
}

public class IPTV extends ColorTV{
    String ip;
    private IPTV(String ip, int size, int color) {
        super(size, color);
        this.ip = ip;
    }

    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048); // "192.1.1.2" 주소에 32인치, 2048컬러
        iptv.printProperty();
    }
    private void printProperty() {
        System.out.println("나의 IPTV는 " + ip + " 주소의 " + super.getSize() + "인치 " + super.getColor() + "컬러" );
    }
}
