
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author Ketan Mehta
 * @date
 * @link https://www.hackerearth.com/challenges/hiring/vimeo-full-stack-developer-hiring-challenge-2020/problems/d824ac6ec06942f1a8b70a9248d7b852/
 */

class TheMaximumProfit implements Comparable<TheMaximumProfit> {

    public static long[] prefixSum = null;
    public int low;
    public int high;
    public long sum;

    public TheMaximumProfit(int low, int high) {
        this.low = low;
        this.high = high;
        sum = prefixSum[high] - (prefixSum[low - 1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] tokens = br.readLine().split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            tokens = br.readLine().split(" ");
            long[] cost = new long[n];
            int idx = 0;
            prefixSum = new long[n + 1];
            long[] shopVisitDiff = new long[n + 2];
            for (String tok : tokens) {
                cost[idx] = Long.parseLong(tok);
                // prepare prefixSum
                if (idx == 0) {
                    prefixSum[idx + 1] = cost[idx];
                } else {
                    prefixSum[idx + 1] = prefixSum[idx] + cost[idx];
                }
                idx++;
            }
            //System.out.println(Arrays.toString(prefixSum));
            List<TheMaximumProfit> profitList = new ArrayList<>();
            for (int x = 0; x < m; x++) {
                tokens = br.readLine().split(" ");
                int low = Integer.parseInt(tokens[0]);
                int high = Integer.parseInt(tokens[1]);

                profitList.add(new TheMaximumProfit(low, high));
                // Range update using diff array
                shopVisitDiff[low]++;
                shopVisitDiff[high + 1]--;
            }
            long[] mostVisitedShop = new long[n + 2];
            mostVisitedShop[0] = shopVisitDiff[0];
            // Update actual array using diff array
            for (int x = 1; x < mostVisitedShop.length; x++) {
                mostVisitedShop[x] = shopVisitDiff[x] + mostVisitedShop[x - 1];
            }

            int k = Integer.parseInt(br.readLine());
            // Sort by profit
            Collections.sort(profitList);
            int ansIdx = 0;
            long maxSoFar = 0;
            // find index of max visited shop
            for (int x = 1; x < mostVisitedShop.length; x++) {
                if (mostVisitedShop[x] > maxSoFar) {
                    ansIdx = x;
                    maxSoFar = mostVisitedShop[x];
                }
            }

            long sumAns = 0;
            for (int x = 0; x < k; x++) {
                sumAns = sumAns + profitList.get(x).sum;
            }
            System.out.println(sumAns);
            System.out.println(ansIdx);
        }
    }

    @Override
    public String toString() {
        return "sum :" + sum + ",[" + low + "," + high + "]";
    }

    @Override
    public int compareTo(TheMaximumProfit o) {
        return Long.valueOf(o.sum).compareTo(sum);
    }
}