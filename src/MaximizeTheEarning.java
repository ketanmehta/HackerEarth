import java.io.BufferedReader;
import java.io.InputStreamReader;

class MaximizeTheEarning {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] toks = br.readLine().split(" ");
            int n = Integer.parseInt(toks[0]);
            int k = Integer.parseInt(toks[1]);
            int[] ip = new int[n];
            int max = Integer.MIN_VALUE;
            int ans = 0;
            toks = br.readLine().split(" ");
            for (int x = 0; x < n; x++) {
                int val = Integer.parseInt(toks[x]);
                if (val > max) {
                    ans++;
                }
                max = Math.max(max, val);
            }
            sb.append(ans * k);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}