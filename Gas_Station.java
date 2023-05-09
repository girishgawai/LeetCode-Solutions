package greedy;

public class Gas_Station {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};

		Gas_Station obj = new Gas_Station();
		System.out.println(obj.canCompleteCircuit(gas, cost));
	}

	// Optimised
	public int canCompleteCircuit(int[] gas, int[] cost) {

		int fuel_contain = 0;		// station se niklte time fuel kitna hai
		int total_F_G = 0;				// fuel-cost kitna bnra total stations ka
		int start = 0;				// start station
		
		for (int i = start; i < cost.length; i++) {
			fuel_contain = fuel_contain+gas[i] - cost[i];				// uss station ka fuel kitna bhrke hua cost kaat kr
			total_F_G = total_F_G+gas[i] - cost[i];				// total gas-cost ab tk ke stations ka kitna hora
			
			if(fuel_contain<0)			// agr fuel-cost consumption iss sattion tk ke less than 0 uhe.. it means agle station se start krna tha
			{
				start = i+1;
				fuel_contain = 0;
			}
		}

		return total_F_G< 0 ? -1: start;			// agr total_F_G ye less than 0 hai.. mtlb kisi v station se start kro toh v -ve hi hoga
															 // means cant reach or complete the circuit
	}


	// TLE
	public int canCompleteCircuitTLE(int[] gas, int[] cost) {

		for (int i = 0; i < gas.length; i++) {
			int fuel = gas[i];
			int count = 0;
			for (int j = i; ; j++) {
				fuel = fuel-cost[(j)%gas.length];
				System.out.println(j+"->[gas] -> "+j+"   "+i+"  " + fuel+"------- " + count+"=== "+(j)%gas.length);
				if(fuel<0)
					break;
				System.out.println("hello");
				if(count==gas.length)
					return i;

				fuel = fuel+gas[(j+1)%gas.length];
				count++;
			}
		}

		return -1;
	}
}
