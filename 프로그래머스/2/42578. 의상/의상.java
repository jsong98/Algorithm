import java.util.*;

class Solution {
    
    HashMap<String, Integer> hm;
    int answer;
    
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> kind = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (kind.containsKey(clothes[i][1])) {
                kind.replace(clothes[i][1], kind.get(clothes[i][1]) + 1);
            } else {
                kind.put(clothes[i][1], 1);
            }
        }
        for (String key : kind.keySet()) {
            answer *= kind.get(key) + 1;
        }
        
        return answer - 1;
//         answer = 0;
//         hm = new HashMap<String, Integer>();
        
//         for(int i = 0; i < clothes.length; i++) {
//             if(!hm.containsKey(clothes[i][1])) {
//                 hm.put(clothes[i][1], 1);
//                 continue;
//             }
//             hm.put(clothes[i][1], hm.get(clothes[i][1]) + 1);
//         }
        
//         int category = hm.size();
//         String[] clothArr = new String[category];
//         boolean[] visited = new boolean[category];
//         int idx = 0;
//         for(String cloth : hm.keySet()) {
//             clothArr[idx++] = cloth; 
//             answer += hm.get(cloth);
//         }
//         if(category == 1) return answer;
        
//         for(int i = 2; i <= category; i++) {
//             comb(clothArr, visited, 0, category, i);
            
//         }
        
//         return answer;
    }
    
    public void comb(String[] arr, boolean[] visited, int depth, int n, int r) {
        if(r == 0) {
            int temp = 1;
            for(int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    temp *= hm.get(arr[i]);
                }
            }
            answer += temp;
            return;
        }
        
        if(depth == n) return;
        
        visited[depth] = true;
        comb(arr, visited, depth+1, n, r-1);
        
        visited[depth] = false;
        comb(arr, visited, depth+1, n, r);
        
    }
}