import java.util.Scanner;

public class StringCycle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력하세요. 빈칸이 있어도 되고, 영어 한글 모두 됩니다.");
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++)
            input = StringCycle.Cycling(input);

    }

    private static String mergeString(String[] array) {
        StringBuilder result = new StringBuilder();
        for (String s : array)
            result.append(s);
        return result.toString();
    }


    private static String Cycling(String obj) {
        String[] input = obj.split("");
        String temp = input[0];
        for (int i = 0; i < obj.length(); i++) {
            try {
                input[i] = input[i + 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                input[i] = temp;
                temp = mergeString(input);
            }
        }
        System.out.println(temp);
        return temp;
    }
}
