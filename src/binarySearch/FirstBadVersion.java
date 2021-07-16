package binarySearch;

public class FirstBadVersion {

	public static void main(String[] args) {
		FirstBadVersion first = new FirstBadVersion();
		System.out.println(" result " + first.firstBadVersion(5555));
	}

	public int firstBadVersion(int n) {
		int badVersion = binarySearch(n, 0, n);
		return badVersion;
	}

	private int binarySearch(int target, int low, int high) {
		System.out.println("target=" + target + " low=" + low  + ", high=" + high );
		int result;
        if (high - low == 1) { // I got the final two elements
            if (isBadVersion(low)) return low;
            else return high;
        }
        int mid = low + (high - low)/2;
        System.out.println("mid=" + mid);
        if (isBadVersion(mid)) 
        	result = binarySearch(target, low, mid);
         else 
        	result= binarySearch(target, mid, high);
        
        return result;
    }

	private boolean isBadVersion(int version) {
		if (version >= 7)
			return true;
		return false;
	}

}
