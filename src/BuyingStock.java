
import java.util.Scanner;

/**
 * @author Ketan Mehta
 * @date 
 * @problem_link
 */
class BuyingStock {
    public static void main(String args[] ) throws Exception {
    	Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] profitArray = new int[n];
        for(int i=0; i<n; i++){
            profitArray[i] = s.nextInt();
        }
        System.out.println(maximumProfit(profitArray));
        s.close();
    }
     static int maximumProfit(int profiltArray[])
    {
        int maxProfitTillNow = Integer.MIN_VALUE;
        int maxProfitUptoPoint = 0;
 
        for (int i = 0; i <  profiltArray.length; i++)
        {
            maxProfitUptoPoint = maxProfitUptoPoint + profiltArray[i];
            if (maxProfitTillNow < maxProfitUptoPoint)
                maxProfitTillNow = maxProfitUptoPoint;
            if (maxProfitUptoPoint < 0)
                maxProfitUptoPoint = 0;
        }
        return maxProfitTillNow < 0 ? 0 : maxProfitTillNow;
    }
}
