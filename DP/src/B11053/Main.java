package B11053;

import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
//		Arrays.sort(arr); //수열의 순서를 고려해ㅎ야함.
		int cnt =1;
//		System.out.println(Arrays.toString(arr));
		for(int i=1; i<n; i++) if(arr[i]>arr[i-1])cnt++;
		
		System.out.println(cnt);
	}

}
