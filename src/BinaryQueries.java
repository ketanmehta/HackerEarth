import java.util.BitSet;
import java.util.Scanner;

class BinaryQueries {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        BitSet bitSet = new BitSet(n);
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            if (pos == 1) {
                bitSet.set(i);
            } else {
                bitSet.clear(i);
            }
        }
        for (int i = 0; i < q; i++) {
            int qType = sc.nextInt();
            switch (qType) {
                case 1:
                    int pos = sc.nextInt();
                    bitSet.flip(pos - 1);
                    break;
                case 0:
                    int fromIndex = sc.nextInt();
                    int toIndex = sc.nextInt();
                    if (bitSet.get(toIndex - 1)) {
                        System.out.println("ODD");
                    } else {
                        System.out.println("EVEN");
                    }
            }
        }
    }
}