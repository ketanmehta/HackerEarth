
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Ketan Mehta
 * @date
 * @link https://www.hackerearth.com/challenges/hiring/arista-networks-developer-hiring-challenge-2020/problems/2933a2cbde2d41d3b7c0b9cec4f1610c/
 */

class NumberOfDays {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split("0");
            int len = 0;
            for (String tok : input) {
                len = Math.max(tok.length(), len);
            }
            if (len == 0) {
                System.out.println(len);
            } else {
                System.out.println(len + 1);
            }
        }
    }
}