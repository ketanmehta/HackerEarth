import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Ketan Mehta
 * @date 18-Feb-2018
 * @problem_link 
 *               https://www.hackerearth.com/challenge/competitive/february-circuits
 *               -18/approximate/competition-in-hackerland-ec730844/
 *
 **/
public class CompetitionsinHackerland {

	public static void main(String args[]) throws Exception {
		test();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] toks = br.readLine().split(" ");
		double[] force = new double[N];
		for (int i = 0; i < N; i++) {
			force[i] = Double.parseDouble(toks[i]);
		}
		br.close();
	}
	int test1(){
		return 1;
	}
	public static void test(){
		double trophyPos = 2.053769562;
		trophyPos = 2;
		double a = trophyPos - 2;
		double base2 = Math.log(2);
		double answer = 35 / ( Math.log(2+a) / base2);
		System.out.println(answer);
		
		double b = 3 - trophyPos;
		answer = 25 / ( Math.log(2+b) / base2);
		System.out.println(answer);
		
		double c = 4 - trophyPos;
		answer = 35 / ( Math.log(2+c) / base2);
		System.out.println(answer);
		

	}
}
class child extends CompetitionsinHackerland{
	@Override
	int test1(){
		return 2;
	}
}