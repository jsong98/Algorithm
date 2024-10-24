import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        if(puddles.length != 0) {
            for(int[] puddle : puddles) {
                map[puddle[1]-1][puddle[0]-1] = -1;
            }
        }
        for(int i = 1; i < m; i++) {
            if(map[0][i] == -1) break;
            map[0][i] = 1;
        }
        for(int i = 1; i < n; i++) {
            if(map[i][0] == -1) break;
            map[i][0] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(map[i][j] == -1) continue;
                if(map[i-1][j] == -1 && map[i][j-1] == -1) continue;
                if(map[i-1][j] == -1 && map[i][j-1] != -1) map[i][j] = map[i][j-1];
                else if(map[i-1][j] != -1 && map[i][j-1] == -1) map[i][j] = map[i-1][j];
                else map[i][j] = (map[i-1][j] + map[i][j-1]) % 1000000007;
            }
        }
        // for(int[] arr : map) System.out.println(Arrays.toString(arr));
        return map[n-1][m-1];
    }
}