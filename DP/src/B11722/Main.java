package B11722;
/**
 * 가장 긴 감소하는 수열 : 아까 똑같은거 풀었는데 못 풀면 난 등신이다 현수야.
 */

import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int [n+1];
		
		for(int i=1; i<=n; i++) arr[i]=sc.nextInt();
		
		int maxlen =1;
		
		for(int i=1; i<=n; i++) {
			dp[i] =1;
			for(int j=1; j<i; j++) {
				if(arr[i] < arr[j]) {// 직전보다 작다면 감소하는 수열의 조건 완성
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}//dp[i] : i요소를 포함하는 가장 긴 감소하는 수열
			maxlen = Math.max(maxlen, dp[i]);
		}
		
		System.out.println(maxlen);
		
		
	}

}
