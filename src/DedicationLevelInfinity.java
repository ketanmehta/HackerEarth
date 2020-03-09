import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeMap;

class DedicationLevelInfinity {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] toks = br.readLine().split(" ");
        int t = Integer.parseInt(toks[0]);
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < t; i++) {
            toks = br.readLine().split(" ");
            String name = toks[0];
            int time = Integer.parseInt(toks[1]);
            map.put(time, name);
        }
        int i = 0;
        for (String name : map.values()) {
            System.out.println(name);
            i++;
            if (i == 3) {
                break;
            }
        }
    }
}