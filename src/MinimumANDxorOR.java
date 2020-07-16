
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author Ketan Mehta
 * @date
 * @link https://www.hackerearth.com/challenges/competitive/march-circuits-20/algorithm/minimum-and-xor-or-6a05bbd4/
 * @status NOT_SOLVED
 */

class MinimumANDxorOR {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String[] toks = br.readLine().split(" ");

            toks = br.readLine().split(" ");
            long[] nums = new long[toks.length];

            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;

            Set<Long> set = new TreeSet<>();
            for (int idx = 0; idx < nums.length; idx++) {
                nums[idx] = Long.valueOf(toks[idx]);
                min = Math.min(min, nums[idx]);
                max = Math.max(max, nums[idx]);
                set.add(nums[idx]);
            }

            long minVal = -1;
            long maxVal = -1;
            long ans = Long.MAX_VALUE;
            for (int x = 1; Math.pow(2, x) <= max; x++) {
                long val1 = (long) Math.pow(2, x);
                long val2 = (long) Math.pow(2, x + 1) - 1;
                if (set.contains(val1) && set.contains(val2)) {
                    ans = Math.min(ans, val2 - val1);
                } else if (set.contains(val1) && set.contains(val2 + 1)) {
                    val2++;
                    ans = Math.min(ans, (val1 & val2) ^ (val1 | val2));
                }
            }
            sb.append(ans);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}