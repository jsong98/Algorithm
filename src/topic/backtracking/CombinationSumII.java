package topic.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		
		combinationSum2(candidates, target);
	}
	
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		System.out.println(Arrays.toString(candidates));
		backtrack(res, new ArrayList<Integer>(), candidates, target, 0);
//		for(List<Integer> list: res) {
//			System.out.println(list.toString());
//		}
		return res;
	}
	
	public static void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int idx) {
		if(target<0) return;
		else if(target==0) res.add(new ArrayList<>(temp));
		else {
			System.out.println();
			for(int i = idx; i < candidates.length; i++) {
				System.out.println(i + ", " + idx);
				if(i > 1 && candidates[i] == candidates[i-1]) continue;	// 중복 방지
				System.out.println(temp.toString() + ", " + target);
				temp.add(candidates[i]);
				backtrack(res, temp, candidates, target-candidates[i], i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
}
