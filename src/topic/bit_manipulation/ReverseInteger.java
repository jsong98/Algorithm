package topic.bit_manipulation;

public class ReverseInteger {

	public static void main(String[] args) {
//		int x = 463847412;
		int x = 123456789;
//		int x = 1534236469;
//		int x = 1234567890;
		
		System.out.println("limit : " + Integer.MIN_VALUE);
		
		System.out.println(reverse(x));
	}

	public static int reverse(int x) {
		if(x==0||x==Integer.MIN_VALUE) return 0;
		int temp = 0;
		if(x<0) {
			temp = (-1) * x;
		} else {
			temp = x;
		}
		
        int res = 0;
        while(temp!=0){
            int lastDig = temp%10;
            res += lastDig;
            res = res*10;
            temp= temp/10;
            if(res>=10000000 && temp>=10) {
            	res += temp%10;
            	temp /= 10;
            	res *= 10;
            	res += temp%10;
            	return res;
            }
        }
        
        res /= 10;
        if(x<0){
            return -1*res;
        }
        return res;
    }
}
