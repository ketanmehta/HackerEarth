
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * @author Ketan Mehta
 * @date
 */

class LoneIntegers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] tokens = br.readLine().split(" ");
            HashMap<String, Boolean> map = new HashMap<>();
            for (int x = 0; x < n; x++) {
                if (map.containsKey(tokens[x].trim())) {
                    map.remove(tokens[x].trim());
                } else {
                    map.put(tokens[x].trim(), true);
                }
            }
            if (map.isEmpty()) {
                System.out.println("-1");
            } else {
                System.out.println(map.keySet().toArray()[0]);
            }
        }
    }
}