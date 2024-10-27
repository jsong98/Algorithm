import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int height = -1;
        int width = -1;
        for(int[] arr : sizes) {
            int a = arr[0];
            int b = arr[1];
            if(a < b) {
                if(b > height) height = b;
                if(a > width) width = a;
            } else {
                if(a > height) height = a;
                if(b > width) width = b;
            }
        }
        return height * width;
    }
}