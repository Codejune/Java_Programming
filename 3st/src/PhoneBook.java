import java.util.InputMismatchException;
import java.util.Scanner;

class Phone {
    private String name;
    private String phone_num;
    Phone(String name, String phone_num) {
        this.name = name;
        this.phone_num = phone_num;
    }
    String getName() {
        return name;
    }
    String getPhoneNum() {
        return phone_num;
    }
}
public class PhoneBook {
    public static void main(String args[]) {
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.print("인원수 >> ");
        try {
            num = scanner.nextInt();
            Phone[] phone = new Phone[num];
            for(int i = 0; i < num; i++) {
                System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력) >> ");
                String name = scanner.next();
                String phone_num = scanner.next();
                phone[i] = new Phone(name, phone_num);
            }
            while(true) {
                boolean check = false;
                System.out.print("검색할 이름 >> ");
                String input = scanner.next();
                for (int i = 0; i < phone.length; i++) {
                    if (phone[i].getName().equals(input)) {
                        System.out.println(input + "의 번호는 " + phone[i].getPhoneNum());
                        check = true;
                        break;
                    }
                }
                if(input.equals("그만"))
                    break;
                else if(!check)
                    System.out.println(input + " 이 없습니다.");

            }
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력하여주세요");
            System.exit(-1);
        }
    }
}
