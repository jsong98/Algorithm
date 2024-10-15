import java.util.*;
/*
[2, 2, 2, 2, 2, 2]
1
*/
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int end = citations[citations.length-1];
        
        int h = end;
        while(true) {
            int over = 0;
            int under = 0;
            
            for(int i = 0; i < citations.length; i++) {
                if(citations[i] < h) {
                    under++;
                }
                if(citations[i] >= h) {
                    over++;
                }
            }
            if(under <= h && over >= h) break;
            h--;
        }
        return h;
    }
}