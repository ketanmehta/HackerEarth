
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Ketan Mehta
 * @date
 * @link
 */

class PlayfulStrings {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            String ip = br.readLine();
            int distance = 1;
            char[] arr = ip.toCharArray();
            boolean flag = true;
            for (int x = 1; x < arr.length; x++) {
                distance = arr[x - 1] - arr[x];
                if (distance == 1 || distance == -1 || (arr[x - 1] == 'z' && arr[x] == 'a') || (arr[x - 1] == 'a' && arr[x] == 'z')) {

                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}