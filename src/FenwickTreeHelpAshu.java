import java.util.Arrays;
import java.util.Scanner;

class SolutionFenwick {
    public static void main(String args[]) throws Exception {
        //createFenwickTree(new int[]{1,2,3,4,5,6});
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ip = new int[t];
        for (int x = 0; x < t; x++) {
            ip[x] = sc.nextInt();
        }
        createFenwickTree(ip);
        System.out.println(fenwickRangeQuery(1, 2, true));
        System.out.println(fenwickRangeQuery(1, 3, true));
        System.out.println(fenwickRangeQuery(1, 4, true));
        System.out.println(fenwickRangeQuery(1, 5, true));
        System.out.println(fenwickRangeQuery(1, 6, true));
        System.out.println(fenwickRangeQuery(2, 6, true));
        System.out.println(fenwickRangeQuery(2, 4, true));
        System.out.println(fenwickRangeQuery(2, 5, true));

        System.out.println("update");
        fenwickPointUpdate(4, 1);

        System.out.println(fenwickRangeQuery(1, 2, true));
        System.out.println(fenwickRangeQuery(1, 3, true));
        System.out.println(fenwickRangeQuery(1, 4, true));
        System.out.println(fenwickRangeQuery(1, 5, true));
        System.out.println(fenwickRangeQuery(1, 6, true));
        System.out.println(fenwickRangeQuery(2, 6, true));
        System.out.println(fenwickRangeQuery(2, 4, true));
        System.out.println(fenwickRangeQuery(2, 5, true));
        System.out.println("OK");
        //System.out.println(Arrays.toString(tree));
        int q = sc.nextInt();
        for (int x = 0; x < q; x++) {
            int queryType = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();

            switch (queryType) {
                case 0:
                    fenwickPointUpdate(left, right);
                    //System.out.println(Arrays.toString(tree));
                    break;
                case 1:
                    System.out.println(fenwickRangeQuery(left, right, true));
                    break;
                case 2:
                    System.out.println(fenwickRangeQuery(left, right, false));
                    break;
            }
        }

    }

    static int lsb(int num) {
        return num & -num;
    }

    static int N = 0;

    static int[] tree = null;
    static int[] input = null;

    static void createFenwickTree(int[] ip) {
        input = ip;
        N = ip.length + 1;
        tree = new int[N];

        for (int i = 1; i < N; i++) {
            if (ip[i - 1] % 2 == 0) {
                tree[i]++;
            }
        }

        for (int i = 1; i < N; i++) {
            int parent = i + lsb(i);
            if (parent < N) {
                tree[parent] = tree[parent] + tree[i];
            }
        }
        //System.out.println(Arrays.toString(tree));
    }

    static int fenwickRange(int i) {
        int sum = 0;
        while (i != 0) {
            sum += tree[i];
            i = i - lsb(i);
        }
        //System.out.println("Tree is " + Arrays.toString(tree));
        return sum;
    }

    static int fenwickRangeQuery(int left, int right, boolean countEven) {
        int totalEven = fenwickRange(right) - fenwickRange(left-1);
        //System.out.println("Range right till 0 " + fenwickRange(right));
        //System.out.println("Range left till 0 " + fenwickRange(left-1));
        //System.out.println("From " + left + "-" + right);
        //System.out.println("Total Even " + totalEven + ", Range " + (right-left));
        return countEven ? totalEven : (right - left - totalEven + 1);
    }

    static void fenwickPointUpdate(int index, int value) {

        //System.out.println("Before update input is : " + Arrays.toString(input));
        if (value % 2 == 0 && input[index-1] % 2 == 0) {
            // do nothing;
            //System.out.println("1 did nothing");
            return;
        } else if (value % 2 != 0 && input[index-1] % 2 != 0) {
            // do nothing
            //System.out.println("2 did nothing");
            return;
        }
        boolean existingWasEven = input[index-1] % 2 == 0;
        boolean existingWasOdd = !existingWasEven;
        boolean newIsOdd = value % 2 == 1;
        boolean newIsEven = value % 2 == 0;
        input[index-1] = value;

        //System.out.println("After update input is : " + Arrays.toString(input));
        while (index < N) {
            //System.out.println("im in updating " + index);
            if (existingWasOdd && newIsEven) {
                tree[index]++;
            }
            else if(existingWasEven && newIsOdd){
                tree[index]--;
            }
            index = index + lsb(index);
        }

    }
}