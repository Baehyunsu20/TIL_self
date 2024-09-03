package BOJ_DP;
/**
 * 역 생각하기 : 1부터 숫자를 만들 수 있는 연산 횟수를 기록하는 방법 사용
 */

import java.util.Arrays;
import java.util.Scanner;

public class B1463 {
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//연산횟수를 담을 배열
		int[] dp = new int[n+1];
		
		for(int i=2; i<n+1; i++) {
			//i를 만들기 위한 횟수
			
			//앞의 조건문에 걸리지 않는 경우: 1만 가능할 경우.
			dp[i] = dp[i-1] +1;
			//1만 더한 값과 나눈 값 중에 무엇이 더 큰지 비교부터!
			if(i%2 ==0 && dp[i]>dp[i/2]+1) dp[i] = dp[i/2]+1;
			if(i%3 ==0 && dp[i]>dp[i/3]+1) dp[i] = dp[i/3]+1;

		}
		
		System.out.println(dp[n]);
		
		
		
		

	}

}
