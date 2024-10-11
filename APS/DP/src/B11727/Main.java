package B11727;


import java.util.*;
public class Main {
	
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[1001]; // n+1로 하면 인덱스아웃 에러.
		dp[0]=0;
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2]*2; //dp[i-2]는 2가지 방법이 있음.
		}
		
		System.out.println(dp[n]);
	}

}
