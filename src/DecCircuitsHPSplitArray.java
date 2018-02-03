
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Ketan Mehta
 * @date 19-Dec-2017
 * @problem_link
 */
public class DecCircuitsHPSplitArray {
    public static void main(String[] args) throws IOException {
        
    	 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<Integer>(N);
			String[] toks = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr.add(Integer.parseInt(toks[j]));
			}
			for (int rotate = 1; rotate <= N; rotate++) {
				ArrayList<Integer> copyQ = new ArrayList<Integer>();
				copyQ.addAll(arr.subList(rotate, N));
				copyQ.addAll(arr.subList(0, rotate));
				
				long inCount = 0;
				for(int x=0; x<copyQ.size()-1; x++) {
					int baseEle = copyQ.get(x);
					for(int z=x+1; z<copyQ.size(); z++) {
						if (baseEle > copyQ.get(z)) {
							inCount++;
						}
					}
				}
				sb.append(inCount + " ");
			}
			System.out.println(sb);
		}
		br.close();
	
    }
}
