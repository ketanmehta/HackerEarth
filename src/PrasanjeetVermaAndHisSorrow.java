import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class PrasanjeetVermaAndHisSorrow {
    public static void main(String args[]) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        PrasanjeetVermaAndHisSorrow root = new PrasanjeetVermaAndHisSorrow();
        List<String[]> queries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            queries.add(bufferedReader.readLine().split(" "));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] s : queries) {
            String val = s[1];
            if (s[0].equals("add")) {
                root.add(val);
            } else {
                stringBuilder.append(root.find(val));
                stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder);


    }

    public int childCount = 0;
    public char c;
    public PrasanjeetVermaAndHisSorrow childNodes[] = new PrasanjeetVermaAndHisSorrow[26];

    public PrasanjeetVermaAndHisSorrow() {

    }

    public void add(String word) {
        PrasanjeetVermaAndHisSorrow current = this;
        for (char c : word.toCharArray()) {
            PrasanjeetVermaAndHisSorrow node = current.childNodes[c - 'a'];
            if (node == null) {
                node = new PrasanjeetVermaAndHisSorrow();
                node.c = c;
                node.childCount++;
                current.childNodes[c - 'a'] = node;
            } else {
                node.childCount++;
            }
            current = node;
        }
    }

    public int find(String prefix) {
        PrasanjeetVermaAndHisSorrow current = this;
        for (char c : prefix.toCharArray()) {
            PrasanjeetVermaAndHisSorrow node = current.childNodes[c - 'a'];
            if (node == null) {
                return 0;
            }
            current = node;
        }
        return current.childCount;
    }
}
