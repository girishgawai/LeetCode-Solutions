package queues;
import java.util.*;

public class Number_of_Recent_Calls {
	
	class RecentCounter {

	    Queue<Integer> q = new LinkedList<>();
	    public RecentCounter() {
	        
	    }
	    
	    public int ping(int t) {
	        q.add(t);					// q.enQueue(t);

	        while(q.peek()<(t-3000))
	        {
	            q.poll();				// q.deQueue();
	        }
	        
	        return q.size();
	    }
	}

	/**
	 * Your RecentCounter object will be instantiated and called as such:
	 * RecentCounter obj = new RecentCounter();
	 * int param_1 = obj.ping(t);
	 */
	
}
