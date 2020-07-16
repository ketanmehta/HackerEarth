
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;


/**
 * @author Ketan Mehta
 * @date
 * @link https://www.hackerearth.com/challenges/competitive/march-circuits-20/algorithm/dislikes-and-party-567b9605/
 */

public final class DislikesAndParty implements Comparable<DislikesAndParty> {

    public long low;
    public long high;

    public DislikesAndParty(long a, long b) {
        low = a;
        high = b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long grandTotal = N * N;

        TreeSet<DislikesAndParty> set = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            String[] tok = br.readLine().split(" ");
            long first = Long.parseLong(tok[0]);
            for (int x = 1; x < tok.length; x++) {
                set.add(new DislikesAndParty(first, Long.parseLong(tok[x])));
                set.add(new DislikesAndParty(Long.parseLong(tok[x]), first));
            }
        }
        long len = grandTotal - set.size() - N;
        len = len / 2;
        System.out.println(len);

    }

    public boolean equals(Object ox) {
        DislikesAndParty o = (DislikesAndParty) ox;
        return o.low == this.low && o.high == this.high;
    }

    @Override
    public int compareTo(DislikesAndParty o2) {
        DislikesAndParty o1 = this;
        int ret = Long.valueOf(o1.low).compareTo(o2.low);
        if (ret == 0) {
            ret = Long.valueOf(o1.high).compareTo(o2.high);
        }
        return ret;
    }
}