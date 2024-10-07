import java.util.*;
import java.util.Map.Entry;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
        for(int i = 0; i < completion.length; i++) {
            if(hm1.containsKey(completion[i])) {
                hm1.replace(completion[i], hm1.get(completion[i]) + 1);
                continue;
            }
            hm1.put(completion[i], 1);
        }
        HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
        for(int i = 0; i < participant.length; i++) {
            if(!hm1.containsKey(participant[i])) {
                return participant[i];
            }
            if(hm2.containsKey(participant[i])) {
                hm2.replace(participant[i], hm2.get(participant[i]) + 1);
                continue;
            }
            hm2.put(participant[i], 1);
        }

        for(Entry<String, Integer> entry : hm1.entrySet()) {
            if(!entry.getValue().equals(hm2.get(entry.getKey()))) {
                return entry.getKey();
            }
        }
        return answer;
    }
}