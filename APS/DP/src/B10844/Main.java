package B10844;


/*
 * 쉬운 계단 수 : 문제가 무슨 소리니..?
 * 
 */

import java.util.*;
public class Main {
	static int n;
	static long cnt;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//이따가 나눌  10억이라는 수
		int div = 1000000000;
		int n = sc.nextInt(); //숫자의 길이
		arr = new int[n]; //0- n-1까지 n개의 자릿수를 가짐.
		cnt = 0;
		for(int i=1; i<=9; i++) {
			arr[0] = i;
			recurr(0);
			
		}
		System.out.println(cnt);

	}
	private static void recurr(int idx) { // idx = 직전 요소의 인덱스.
		//idx =1부터 채우기 시작함.
		
		//기저조건
		if(idx == n-2) {
			//n-1 인덱스까지 다 채웠을 경우.
			cnt++;
			return;
		}
		
		//재귀조건
		for(int i=arr[idx]-1; i<=arr[idx]+1; i++) {
			//자기 자신이 아닌 경우 : 차가 0이 아닐 경우에만
			if(i == arr[idx]) continue; 
			arr[idx+1] = i;
			recurr(idx+1);
			
		}
		
		
		
	}
	

}
