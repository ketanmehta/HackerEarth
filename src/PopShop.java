import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class S implements Comparable<S> {

    public Integer index;
    public Integer v;

    public S(int index, int v) {
        super();
        this.index = index;
        this.v = v;
    }

    @Override
    public int compareTo(S shop) {
        if (this.v.compareTo(shop.v) == 0)
            return (this.index.compareTo(shop.index));
        else
            return shop.v.compareTo(this.v);
    }
}

class PopShop {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int j = 0; j < t; j++) {

            String[] tok = br.readLine().split(" ");
            int n = Integer.parseInt(tok[0]), m = Integer.parseInt(tok[1]);
            int[] diff = new int[n + 2];
            for (int k = 0; k < m; k++) {
                String[] tok1 = br.readLine().split(" ");
                int l = Integer.parseInt(tok1[0]), r = Integer.parseInt(tok1[1]);
                diff[l]++;
                diff[r + 1]--;
            }
            int val = 0;
            S[] shop = new S[n];
            PriorityQueue<S> pqueue = new PriorityQueue<>(3);
            for (int i = 1; i < n + 1; i++) {
                val += diff[i];
                shop[i - 1] = new S(i, val);
                pqueue.add(shop[i - 1]);
            }
            Set<Integer> set = new HashSet<>();
            while (set.size() < 3) {
                set.add(pqueue.poll().index);
            }
            for (int id : set) {
                System.out.print(id + " ");
            }
            System.out.println();
        }
    }
}