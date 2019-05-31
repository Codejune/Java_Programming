public class Solve3to12 {
    public static void main(String args[]) {
        int total = 0;
        for(int i = 0; i < args.length; i++) {
            try {
                total += Integer.parseInt(args[i]);
            }catch (NumberFormatException e) {
            }
        }
        System.out.println(total);
    }
}
