
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Ketan Mehta
 * @date
 * @link
 */

class UndertakerStreak {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String ip = br.readLine();
            if ((ip.contains("21") || Integer.parseInt(ip) % 21 == 0)) {
                System.out.println("The streak is broken!");
            } else {
                System.out.println("The streak lives still in our heart!");
            }

        }
    }
}