import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;


class TestClass implements Comparable<TestClass>, Comparator<TestClass> {
    public long start;
    public long end;

    public TestClass(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public String toString() {
        return this.start + "," + this.end;
    }

    @Override
    public int compare(TestClass i1, TestClass i2) {
        if (i1 == null || i2 == null) {
            return 0;
        }
        return (int) ((int) i1.start - i2.start);
    }

    @Override
    public int compareTo(TestClass o) {
        return this.compare(this, o);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[] L = new int[n];
        int[] R = new int[n];
        for (int i_L = 0; i_L < n; i_L++) {
            String[] tmp = br.readLine().trim().split(" ");
            L[i_L] = Integer.parseInt(tmp[0]);
            R[i_L] = Integer.parseInt(tmp[1]);

        }

        long out_ = new TestClass(0, 0).NotinRange(R, L, n);
        System.out.println(out_);

        wr.close();
        br.close();
    }


    long NotinRange(int[] R, int[] L, int n) {
        long len = 1000000l;
        long sum = (len * (len + 1)) / 2;

        TestClass[] arr = new TestClass[n];
        for (int i = 0; i < n; i++) {
            long min = Math.min(L[i], R[i]);
            long max = Math.max(L[i], R[i]);
            arr[i] = new TestClass(min, max);
        }
        if (n == 0) {
            return sum;
        }
        // Sort TestClasss in decreasing order of
        // start time

        //System.out.println("after");
        Arrays.sort(arr);

        int index = 0; // Stores index of last element
        // in output array (modified arr[])

        // Traverse all input TestClasss
        //System.out.println("I will run " + (arr.length - 1) + " times");
        for (int i = 1; i < arr.length && index < arr.length; i++) {
            // If this is not first TestClass and overlaps
            // with the previous one
            if (arr[index].end >= arr[i].start) {
                // Merge previous and current TestClasss
                // System.out.println("Merging " + arr[i].start + " and " + arr[index].end);
                arr[index].end = Math.max(arr[index].end, arr[i].end);
                arr[index].start = Math.min(arr[index].start, arr[i].start);
                arr[i] = arr[index];
            } else {

                //System.out.println("Cant Merge " + arr[i].start + " and " + arr[index].end);
                //arr[index] = arr[i];
                index++;
            }
        }
        //System.out.println("I have merged " + index + " TestClasss");
        Map<String, TestClass> map = new LinkedHashMap<>();
        for (TestClass nir : arr) {
            String key = nir.start + "#" + nir.end;
            if (map.containsKey(key)) {
                continue;
            } else {
                map.put(key, nir);
            }
        }
        // Now arr[0..index-1] stores the merged TestClasss
        //System.out.print("The Merged TestClasss are: ");

        long subtract = 0;
        for (TestClass nir : map.values()) {
            long left = nir.start - 1;
            long right = nir.end;
            //System.out.println("range [" + nir.start + "," + right + "]");

            long first = (right * (right + 1l)) / 2l;
            long second = (left * (left + 1l)) / 2l;
            //System.out.println("Sum first" + first + " second" + second);
            subtract += (first - second);
        }


        return sum - subtract;

    }
}