package B11726;
/**
 * 2xN 타일 채우기
 * 세로 타일 고정 + 가로 고정;
 */

import java.util.*;

public class Main {
	
	static long[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new long[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%10007;
		}
		
		System.out.println(dp[n]%10007);
	}
}
