import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int total = people.length;
        Arrays.sort(people);
        int lightest = people[0];
        int heaviest = people[people.length-1];
        int[] weights = new int[241];
        for(int i = 0; i < total; i++) {
            weights[people[i]]++;
        }

        while(total!=0) {
            for(int i = lightest; i < heaviest+1; i++) {
                if(weights[i] != 0) {
                    int first = i;
                    weights[i]--;
                    total--;
                    answer++;
                    int remain = limit - first;
                    for(int j = remain; j >= lightest; j--) {
                        if(weights[j] != 0) {
                            int second = j;
                            weights[j]--;
                            total--;
                            break;
                        }
                    }
                    break;
                }
            }    
        }
        
        
        return answer;
    }
}