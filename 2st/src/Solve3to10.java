public class Solve3to10 {
    public static void main(String args[]) {
        int array[][] = new int[4][4];
        for(int i  = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                array[i][j] = (int)(Math.random() * 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
