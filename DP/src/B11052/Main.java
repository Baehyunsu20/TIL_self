package B11052;


/**
 * 카드구매하기
 * 카드팩의 종류 : 1부터 N개 들어있는 카드팩
 * 돈을 최대한 많ㅇ 지불해서 n개의 카드 구매.
 */

import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] dp  = new int[n+1]; 
		
		for(int i=1; i<=n; i++) arr[i] = sc.nextInt();
		int max = arr[n];
		
		for(int i=1; i<=n; i++) {
			dp[i] = arr[i]; //dp[i] : i장을 사기위한 최대 금액, 일단 자기 자신으로 초기화
			for(int k=0; k<=i; k++) {
				for(int l=0; l<=n; l++) {
					if((k+l) ==i) {//합이 i장일때
						dp[i] = Math.max(dp[i], dp[k]+dp[l]);
					}
				}
			}
		}
		System.out.println(dp[n]);
	}

}
