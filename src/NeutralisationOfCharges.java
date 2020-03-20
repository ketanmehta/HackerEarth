import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class NeutralisationOfCharges {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // ignore
        char[] ip = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        stack.push(ip[0]);
        for (int i = 1; i < ip.length; i++) {
            char cur = ip[i];
            if (!stack.isEmpty()) {
                char prev = stack.peek();
                if (prev == cur) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }
            }
        }
        while (possible(stack)) {

        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.reverse());
    }

    static boolean possible(Stack<Character> stack) {
        boolean flag = false;
        char[] ip = new char[stack.size()];
        if (ip.length < 2) {
            return false;
        }
        for (int i = 0; i < ip.length; i++) {
            ip[i] = stack.get(i);
        }

        stack.push(ip[0]);
        for (int i = 1; i < ip.length; i++) {
            char cur = ip[i];
            if (!stack.isEmpty()) {
                char prev = stack.peek();
                if (prev == cur) {
                    stack.pop();
                    flag = true;
                } else {
                    stack.push(cur);
                }
            }
        }
        return flag;
    }
}