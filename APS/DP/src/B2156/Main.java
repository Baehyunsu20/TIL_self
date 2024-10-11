package B2156;
/**
 * 포도주 시식.
 * 포도잔의 갯수 = n : 1부터 만까지 가능
 * 포도주의 양=1000이하
 * int 가능.
 * 
 */

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] grape = new int[n+1];//1번째부터 시작
		grape[0] =0;
		for(int i=1; i<=n; i++) grape[i] =sc.nextInt();

		//dp[i][0 또는 1] = i에서 0(포도주 마시지 않기) 1=포도주 마시기.  
		int[][] dp = new int[n+1][2];
		
		//값초기화
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = 0; //1일차에 안마시는 것을 선택
		dp[1][1] = grape[1]; //첫번째 요소의 값으로 초기화.
		
		
		for(int i=2; i<=n; i++) {
			//해당위치에서 먹지 않을 것을 선택을 경우
			//직전의 합 중 큰 것을 선택
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = Math.max( (dp[i-2][0] + grape[i-1]) , dp[i-2][1]) + grape[i];

		}
		System.out.println(Math.max(dp[n][0], dp[n][1]));
		
	}
	
}
