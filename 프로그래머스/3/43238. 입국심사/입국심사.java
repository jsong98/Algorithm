import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        System.out.println(Long.MAX_VALUE);
        long low = 0;
        long high = Long.MAX_VALUE;
        
        long result = binarySearch(times, n, low, high);
        while(getMax(times, result) == n) result-=1;
        
        return result+1;
    }
    
    public long binarySearch(int[] times, int target, long low, long high) {
        if(low <= high) {
            long mid = (low + high) / 2;
            
            if(getMax(times, mid) == target) {
                return mid;
            } else if(getMax(times, mid) < target) {
                return binarySearch(times, target, mid+1, high);
            } else if(getMax(times, mid) > target) {
                return binarySearch(times, target, low, mid-1);
            }    
        }
        
        
        return -1;
    }
    
    public long getMax(int[] times, long time) {
        long cnt = 0;
        for(int i = 0; i < times.length; i++) {
            cnt += time/times[i];
        }
        return cnt;
    }
}