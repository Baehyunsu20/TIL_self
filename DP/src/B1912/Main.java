package B1912;


import java.util.Arrays;

/**
 * 연속합 -> 슈밤 시간 초과.
 */

import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1; i<=n; i++) arr[i] = sc.nextInt();
		dp[0]=0;
		int max =arr[1];
		for(int i=1; i<=n; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			if(dp[i]>max)max=dp[i];
		}
		System.out.println(max);
	}

}
