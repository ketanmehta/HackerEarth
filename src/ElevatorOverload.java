
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ketan Mehta
 * @date 
 * @problem_link
 */
class ElevatorOverload {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static String[] tokenize() throws IOException{
		return br.readLine().trim().split(" ");
	}
    public static void main(String args[] ) throws Exception {
		int T = Integer.parseInt(br.readLine().trim());
		int totFloors = 0;
		String[] inputTokens = null;
		for (int i = 0; i < T; i++) {
			totFloors = Integer.parseInt(br.readLine());
			int maxPersonLimit, maxWeightLimit;
			inputTokens = tokenize();
			maxPersonLimit = Integer.parseInt(inputTokens[0]);
			maxWeightLimit = Integer.parseInt(inputTokens[1]);
			int[] waitingPersons = new int[totFloors - 1];
			inputTokens = tokenize();
			int index = 0;
			for(String token : inputTokens){
				waitingPersons[index++] = Integer.parseInt(token);
			}
			Map<Integer, Integer> floorToReducingWeightMap = new TreeMap<Integer, Integer>();
			Map<Integer, Integer> currentFloorLoad = new TreeMap<Integer, Integer>();
			
			int output = 0;
			boolean isOverloaded = false;
			int personInLift = 0;
			Map<Integer, Integer> floorToNoOfPersonLeavingLiftMap = new TreeMap<Integer, Integer>();
			int currentWeightLoad = 0;
			for(int x=0; x<totFloors-1; x++){
				String[] floorToks = tokenize();
				String[] weightToks = tokenize();
				personInLift = personInLift + weightToks.length;
				for(int y=0; y<waitingPersons[x] && !isOverloaded; y++){
					int floor = Integer.parseInt(floorToks[y]);
					Integer totalWeight = floorToReducingWeightMap.get(floor);
					Integer leavingPersonCount = floorToNoOfPersonLeavingLiftMap.get(floor);
					if(leavingPersonCount == null){
						floorToNoOfPersonLeavingLiftMap.put(floor, 1);
					}
					else{
						floorToNoOfPersonLeavingLiftMap.put(floor, leavingPersonCount + 1);
					}
					if(totalWeight == null){
						totalWeight = Integer.parseInt(weightToks[y]);
						floorToReducingWeightMap.put(floor, totalWeight);
					}
					else{
						floorToReducingWeightMap.put(floor, totalWeight + Integer.parseInt(weightToks[y]));
					}
					currentWeightLoad += Integer.parseInt(weightToks[y]) ;
				}
				//System.out.println("Floor increased weight " + currentWeightLoad + " at Floor " + (x+1));
				if(!isOverloaded){
					currentWeightLoad = currentWeightLoad - (floorToReducingWeightMap.get(x + 1) == null ? 0 : floorToReducingWeightMap.get( x + 1));
					personInLift = personInLift - (floorToNoOfPersonLeavingLiftMap.get(x + 1) == null ? 0 : floorToNoOfPersonLeavingLiftMap.get(x + 1));
					if(!isOverloaded && (currentWeightLoad > maxWeightLimit || personInLift > maxPersonLimit)){
						isOverloaded = true;
						output = x + 1;
					}
					currentFloorLoad.put(x+1, currentWeightLoad);
				}
			}
			//System.out.println(floorToReducingWeightMap);
			//System.out.println(currentFloorLoad);
			if(isOverloaded){
				System.out.println(output);
			}
			else{
				System.out.println(totFloors);
			}
		}
		br.close();
    }
}


