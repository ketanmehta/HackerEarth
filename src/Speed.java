import java.io.BufferedReader;
import java.io.InputStreamReader;

class Speed {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] toks = br.readLine().split(" ");
        int t = Integer.parseInt(toks[0]);
        for (int i = 0; i < t; i++) {
            toks = br.readLine().split(" ");
            int n = Integer.parseInt(toks[0]);
            toks = br.readLine().split(" ");
            int min = Integer.MAX_VALUE;
            int ans = 0;
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(toks[j]);
                if (num <= min) {
                    ans++;
                    min = num;
                }
            }
            System.out.println(ans);
        }
    }
}