import java.io.BufferedReader;
import java.io.InputStreamReader;

class MonkAndRotation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int x = 0; x < t; x++) {
            String[] toks = br.readLine().split(" ");

            int n = Integer.parseInt(toks[0]);
            int k = Integer.parseInt(toks[1]);


            toks = br.readLine().split(" ");

            for (int i = n - (k % n); i < n; i++) {
                sb.append(toks[i] + " ");
            }

            for (int i = 0; i < n - (k % n); i++) {
                sb.append(toks[i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}