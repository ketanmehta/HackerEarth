import java.io.BufferedReader;
import java.io.InputStreamReader;

class MaximumOfKDeque {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] toks = br.readLine().split(" ");

        int n = Integer.parseInt(toks[0]);
        int k = Integer.parseInt(toks[1]);

        StringBuilder sb = new StringBuilder();

        int[] ip = new int[n];
        toks = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            ip[i] = Integer.parseInt(toks[i]);
        }

        int max = ip[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < k; i++) {
            max = Math.max(max, ip[i]);
            secondMax = Math.min(max, ip[i]);
        }

        sb.append(max + " ");

        for (int i = k; i < n; i++) {
            int eleToDiscard = ip[i - k];
            if (eleToDiscard < max) {
                sb.append(max + " ");
            } else if (eleToDiscard == max) {
                max = secondMax;
                secondMax = Math.max(secondMax, ip[i]);
            } else {
                max = Math.max(max, ip[i]);
            }

        }
        System.out.println(sb);

    }
}