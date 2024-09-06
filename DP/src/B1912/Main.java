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
		
		int max=arr[1];
//		dp[1] = arr[1];
		for(int i=1; i<=n; i++) {//1번째 숫자를 포함했을 때 그 전까지 요소의 최댓값
			int sum=arr[i];
			for(int j=i-1; j>=0; j--) {//연속을 어떻게 고려해야지...?
				sum += arr[j];
				dp[i] = Math.max(sum, dp[i]); //계속되는 연속합과 비교
//				System.out.println("i : "+ arr[i]+" dp[i]" +dp[i]);
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);

	}

}
