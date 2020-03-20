import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class BalancedBrackets {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Stack<Character> stack = new Stack<>();
            boolean valid = true;
            for (char c : br.readLine().toCharArray()) {
                if (c == '{') {
                    stack.push('}');
                } else if (c == '(') {
                    stack.push(')');
                } else if (c == '[') {
                    stack.push(']');
                } else if (!stack.isEmpty()) {
                    if (stack.pop() == c) {
                        // Do nothing
                    } else {
                        valid = false;
                        break;
                    }
                } else {
                    valid = false;
                }
            }
            System.out.println(valid && stack.isEmpty() ? "YES" : "NO");
        }


    }
}