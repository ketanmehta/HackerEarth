import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class PrasunTheDetective {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] received = br.readLine().toCharArray();
        char[] decoded = br.readLine().toCharArray();

        Arrays.sort(received);
        Arrays.sort(decoded);

        int[] freq = new int[256];
        for (char c : received) {
            if (Character.isLetter(c)) {
                freq[Character.toLowerCase(c)]++;
            }
        }
        for (char c : decoded) {
            if (Character.isLetter(c)) {
                freq[Character.toLowerCase(c)]--;
            }
        }
        boolean valid = true;
        for (int f : freq) {
            if (f != 0) {
                valid = false;
                break;
            }
        }
        System.out.println(valid ? "YES" : "NO");


    }
}