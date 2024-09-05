package B11053;

import java.util.*;
public class Main {
//	static int[] dp;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		//dp에는 현재 인덱스까지의 증가하는 수열의 최대 길이
//		dp = new int[n+1];
		
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int cnt =1;
//		System.out.println(Arrays.toString(arr));
		for(int i=1; i<n; i++) if(arr[i]>arr[i-1])cnt++;
		
		System.out.println(cnt);

		
	}

}
