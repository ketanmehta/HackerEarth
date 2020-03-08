import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class HamiltonianAndLagrangian {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] ip = new int[t];
        for (int i = 0; i < t; i++) {
            ip[i] = sc.nextInt();
        }
        List<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = t - 1; i > -1; i--) {
            max = Math.max(max, ip[i]);
            if (!list.contains(max)) {
                list.add(max);
            }

        }
        Stack<Integer> stack = new Stack<>();
        for (int ele : list) {
            stack.push(ele);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}