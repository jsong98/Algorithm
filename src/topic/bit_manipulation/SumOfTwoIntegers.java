package topic.bit_manipulation;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
//		int a = 38;
//		int b = 50;
		
		int a = 18;	
		int b = 16;		

		System.out.println(getSum(a, b));
	}

	public static int getSum(int a, int b) {
		int carry = (a & b) << 1;
		int res = a ^ b;
		if (carry == 0)
			return res;
		else
			return getSum(carry, res);
	}
}
