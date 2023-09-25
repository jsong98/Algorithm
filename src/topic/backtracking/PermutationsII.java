package topic.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
//		int[] nums = {1,2,3};
		int[] nums = {1,1,2};
//		int[] nums = {1};
		
		permuteUnique(nums);
	}

	static List<List<Integer>> res;
	
	public static List<List<Integer>> permuteUnique(int[] nums) {
		res = new ArrayList<>();
		int n = nums.length;
		List<Integer> output = new ArrayList<>();
		boolean[] visited = new boolean[n];
		Arrays.sort(nums);
		
		per2(nums, output, visited, 0, n, n);
		for(List<Integer> test : res) {
			System.out.println(test.toString());
		}
		
		return res;
	}
	
	static void per2(int[] arr, List<Integer> output, boolean[] visited, int depth, int n, int r) {
		if(depth == r ) {
			List<Integer> temp = new ArrayList<>(output);
//			for(int i = 0; i < n; i++) {
//				temp.add(output[i]);
//			}
			if(!res.contains(temp)) res.add(temp);
			return ;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output.add(depth, arr[i]);
				per2(arr, output, visited, depth+1, n, r);
				visited[i] = false;
			}
		}
	}
}
