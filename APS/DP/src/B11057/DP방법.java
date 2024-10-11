package B11057;

import java.util.Scanner;

/**
 직전값들의 합으로,,,
 모듈러 연산을 두번,,,
 */

public class DP방법 {
	
	//(해당 인덱스  i, 해당인덱스에서 j값을 가질 수 있는 경우의 수)
	static long[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new long[n+1][10]; //j=0부터 9까지 가능
		
		 //(초기화)첫번째 자리(idx=0)에서 0,1,..9가 나올 수 있는 경우의 수
		for(int i=0; i<10; i++) arr[1][i] = 1;
		
		//점화식 계산-> n까지의 값을 채워나가야함
		for(int i=2; i<=n; i++) {//arr i의 최대인덱스 = n-1.
			for(int j=0; j<10; j++) {
				for(int k=0; k<=j; k++) {
					//아니 각 자리를 10007로 나눠줘야해?
					arr[i][j] += arr[i-1][k]%10007;
//					arr[i][j] = (arr[i][j] + arr[i - 1][k]) % 10007; // 
				}
			}
		}
		
		//끝자리는 0-9까지 가능 -> 반복문
		long result=0;
		for(int i=0; i<10; i++) {
			result += arr[n][i];
		}
		System.out.println(result % 10007);

	}

}
