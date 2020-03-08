import java.util.Scanner;

class MicroAndArrayUpdate {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int min = Integer.MAX_VALUE;
            for (int x = 0; x < n; x++) {
                min = Math.min(min, sc.nextInt());
            }

            System.out.println(Math.max(0, k - min));
        }
    }
}