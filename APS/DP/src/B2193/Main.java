package B2193;

/*
 * 1부터 시작해서 idx=n까지 채워감. idx = 0은 비워두자
 * long으로 안하면 틀림.
 * 
 */

import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] arr =new long[n+1][2]; //0또는 1만 가능 = 2
		
		//초기값 : 무조건 1만 가능
		arr[1][0] =0;
		arr[1][1] =1;
		
		for(int i=2; i<=n; i++) {
				//1을 넣고싶으면 직전값이 0만 가능.
				arr[i][1] = arr[i-1][0];
				//0을 넣고 싶으면 상관없음
				arr[i][0] = arr[i-1][0]+arr[i-1][1];
		}
		
		System.out.println(arr[n][0]+arr[n][1]);

	}

}
