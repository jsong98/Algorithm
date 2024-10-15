import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int srt = command[0];
            int end = command[1];
            int target = command[2];
            int[] temp = new int[end-srt+1];
            int idx = command[0]-1;
            for(int j = 0; j < temp.length; j++) {
                temp[j] = array[idx++];
            }
            Arrays.sort(temp);
            answer[i] = temp[target-1];
        }
        return answer;
    }
}