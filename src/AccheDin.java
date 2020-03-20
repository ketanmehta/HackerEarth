import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class AccheDin {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] toks = br.readLine().split(" ");
        int t = Integer.parseInt(toks[0]);
        for (int i = 0; i < t; i++) {
            toks = br.readLine().split(" ");
            int n = Integer.parseInt(toks[0]);

            toks = br.readLine().split(" ");
            int[] ip = new int[n];
            Map<String, Integer> freqMap = new TreeMap<>();
            for (int x = 0; x < n; x++) {
                freqMap.put(toks[x], freqMap.getOrDefault(toks[x], 0) + 1);
            }
            System.out.println(freqMap.entrySet().stream().filter((entry -> {
                return freqMap.get(entry.getKey()).equals(1);
            })).collect(Collectors.toList()).get(0).getKey());
        }


    }
}