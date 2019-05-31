import java.util.Scanner;

interface Stack {
    int length(); // 스택에 저장된 개수 리턴
    int capacity(); //스택에 전체 저장 가능한 개수 리턴
    String pop(); //스택의 top에 실수 저장
    boolean push(String val); //스택의 top에 저장된 실수 리
}

public class StringStack implements Stack {
    private String[] stack;
    private int top = -1;

    public static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("총 스택 저장 공간 입력 >> ");
        StringStack stringstack = new StringStack(scanner.nextInt());
        while (!input.equals("그만")) {
            System.out.print("문자열 입력 >> ");
            input = scanner.next();
            if (stringstack.capacity() == stringstack.length() + 1) {
                System.out.println("스택이 꽉 차서 푸시 불가!");
            } else {
                stringstack.push(input);
            }
        }

        System.out.print("스택에 저장된 모든 문자열 pop : ");
        for(int i = -1; i < stringstack.length(); ) {
            System.out.print(stringstack.pop() + " ");
        }
    }

    private StringStack(int capacity) {
        stack = new String[capacity];
    }

    @Override
    public int length() {
        return top;
    }

    @Override
    public int capacity() {
        return stack.length;
    }

    @Override
    public String pop() {
        try {
            return stack[top--];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public boolean push(String val) {
        try {
            stack[++top] = val;
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
