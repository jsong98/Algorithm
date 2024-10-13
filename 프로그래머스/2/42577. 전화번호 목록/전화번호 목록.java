import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i < phone_book.length; i++) {
            if(hs.isEmpty()) {
                hs.add(phone_book[i]);
                continue;
            }
            String s = phone_book[i];
            for(int j = 1; j <= s.length(); j++) {
                if(hs.contains(s.substring(0, j))) {
                    answer = false;
                    return answer;
                }
            }
            hs.add(s);
        }
        return answer;
    }
}