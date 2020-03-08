import java.util.Scanner;

class ModifySequence {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        if (n == 1) {
            System.out.println("NO");
            return;
        }
        long prev = arr[arr.length - 1];
        boolean cant = false;
        long cur = arr[arr.length - 2];
        int index = arr.length - 2;
        while (index > -1) {
            arr[index] = arr[index] - prev;
            prev = arr[index];
            index--;
            if (prev < 0) {
                cant = true;
                break;
            }
        }
        if (arr[0] != 0) {
            cant = true;
        }

        System.out.println(cant ? "NO" : "YES");
    }
}