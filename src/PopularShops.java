import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class FairShop implements Comparable<FairShop> {

    public int id;
    public Integer visits;

    public FairShop(int id) {
        this.id = id;
        this.visits = 0;
    }

    @Override
    public int compareTo(FairShop fairShop) {
        int val = fairShop.visits.compareTo(this.visits);
        if (val == 0) {
            return Integer.valueOf(this.id).compareTo(fairShop.id);
        }
        return val;
    }
}

class TestClass {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int ix = 0; ix < t; ix++) {
            String[] tok = br.readLine().split(" ");
            int popShop = Integer.parseInt(tok[0]);
            int people = Integer.parseInt(tok[1]);
            int[] diff = new int[popShop];
            Map<Integer, FairShop> map = new HashMap<>();
            for (int x = 0; x < popShop; x++) {
                map.put(x, new FairShop(x));
            }
            for (int x = 0; x < people; x++) {
                tok = br.readLine().split(" ");
                int left = Integer.parseInt(tok[0]) - 1;
                int right = Integer.parseInt(tok[1]) - 1;
                diff[left] += 1;
                if (right != popShop - 1) {
                    diff[right + 1] -= 1;
                }

            }
            for (int x = 1; x < popShop; x++) {
                diff[x] += diff[x - 1];
            }
            for (FairShop s : map.values()) {
                s.visits = diff[s.id];
            }
            PriorityQueue<FairShop> pq = new PriorityQueue<>();
            pq.addAll(map.values());
            int print = 3;
            Set<Integer> set = new TreeSet<>();
            while (print > 0) {
                print--;
                FairShop s = pq.poll();
                set.add(s.id + 1);
            }
            for (int id : set) {
                sb.append(id + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}