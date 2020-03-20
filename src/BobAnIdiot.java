import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class BobAnIdiot {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] toks = br.readLine().split(" ");

        int n = Integer.parseInt(toks[0]);

        Map<Character, Character> kb = new HashMap<>();

        for (int i = 0; i < 256; i++) {
            char c = Character.toLowerCase((char) i);
            kb.put(c, c);
        }

        for (int i = 0; i < n; i++) {
            toks = br.readLine().split(" ");
            char src = Character.toLowerCase(toks[0].charAt(0));
            char dest = Character.toLowerCase(toks[1].charAt(0));
            kb.put(src, dest);
            kb.put(dest, src);
        }

        String ip = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (char c : ip.toCharArray()) {
            char replacement = kb.get(Character.toLowerCase(c));
            if (replacement == 0) {
                replacement = c;
            }
            if (Character.isUpperCase(c)) {
                replacement = Character.toUpperCase(replacement);
            }
            if (Character.isLowerCase(c)) {
                replacement = Character.toLowerCase(replacement);
            }
            sb.append(replacement);
        }
        System.out.println(sb);
    }
}