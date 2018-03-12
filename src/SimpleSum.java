
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ketan Mehta
 * @date 24-Feb-2018
 * @problem_link https://www.hackerearth.com/challenge/competitive/february-circuits-18/algorithm/simple-sum-3-f1585a25/
 */
class SimpleSum {

    public static void main(String[] args) throws Throwable, IOException 
    {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] arr = new long[N];
        String[] toks = br.readLine().trim().split(" ");
        for(int i=0; i<N; i++){
        	arr[i]=Integer.parseInt(toks[i]);
        }
        long sum = 0;
        for(int i=0; i<N; i++){
        	for(int j=i; j<N; j++){
        		long bitWise = (arr[i]|arr[j]);
        		sum += (bitWise * Math.max(arr[i], arr[j]));
        		//System.out.print( maxSoFar[i] + "x" + bitWise + "=" + sum + " ");
        	}
        }
        System.out.print(sum);
        br.close();
    }
}
/*

5
4 2 3 3 3 


i = 0 | 4x4 + 4x6 + 4x7 + 4x7 + 4x7 
i = 1 | 2x2 + 3x3 + 3x3 + 3x3 
i = 2 | 3x3 + 3x3 + 3x3 
i = 3 | 3x3 + 3x3
i = 4 | 3x3
TOTAL SUM = 209
*/