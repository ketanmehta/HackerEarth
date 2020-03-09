import java.io.BufferedReader;
import java.io.InputStreamReader;

class Ridiculus {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] toks = br.readLine().split(" ");

        int n = Integer.parseInt(toks[0]);
        int d = Integer.parseInt(toks[1]);

        StringBuilder sb = new StringBuilder();

        int[] ip = new int[n];
        toks = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            ip[i] = Integer.parseInt(toks[i]);
        }

        for (int i = d % n; i < n; i++) {
            sb.append(ip[i] + " ");
        }

        for (int i = 0; i < (d % n); i++) {
            sb.append(ip[i] + " ");
        }
        System.out.println(sb);

    }
}