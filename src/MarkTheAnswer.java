import java.io.BufferedReader;
import java.io.InputStreamReader;

class MarkTheAnswer {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] toks = br.readLine().split(" ");
        int n = Integer.parseInt(toks[0]);
        long k = Long.parseLong(toks[1]);

        StringBuilder sb = new StringBuilder();

        long[] ip = new long[n];
        toks = br.readLine().split(" ");

        long runningSum = 0;
        boolean skipped = false;
        for (int i = 0; i < n; i++) {
            ip[i] = Long.parseLong(toks[i]);
            if (ip[i] <= k) {
                runningSum++;
            } else {
                if (!skipped) {
                    skipped = true;
                } else {
                    break;
                }
            }
        }
        System.out.println(runningSum);


    }
}