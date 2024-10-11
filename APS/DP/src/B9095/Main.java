package B9095;


/**
 * DP문제
 * 1, 2, 3 더하기 (실버 3)
 * 풀이방법 : 3중 for문을 이용해서 1, 2, 3의 각 갯수를 고려하고 합이 입력값인 k인 경우, 
 * 중복요소가 있는 순열의 경우의 수를 팩토리얼을 이용하여 연산.
 * 
 * 
3
4
7
10 
 
 */

import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			//1,2,3으로 k합을 구하는 것.
			int k = sc.nextInt();
			int[] cnt  = new int[3];
			int ans = 0;
			
			for(int one=0; one<=k; one++) {
				for(int two=0; two<=(k/2); two++) {
					for(int three=0; three<=(k/3); three++) {
						cnt[0] = one;
						cnt[1] = two;
						cnt[2] = three;
						if((cnt[0] + cnt[1]*2 + cnt[2]*3) == k) {
							//합이 k일때, 배열의 중복 순열의 갯수를 구함.
							//배열할 숫자들의 갯수 = num개의 숫자를 정렬
							int num = cnt[0]+cnt[1]+cnt[2];
							ans += fac(num)/(fac(cnt[0]) * fac(cnt[1]) * fac(cnt[2]));
						}

					}
				}
			}
			
			System.out.println(ans);

		}
		
	}
	private static int fac(int n) {
		//기저조건
		if(n==0) return 1;
		//재귀조건
		return n*fac(n-1);
	}

}
