package B11728;
/**
 * 종이의 갯수
 * 시간초과 : 어떻게 해결할까?
 * answer 배열을 따로 만들지 않고 바로 출력 -> 그래도 시간 초과.
 * StringBuilder를 사용하는 방법  -> 해결됨. 잰장
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] narr = new int[n];
		int[] marr = new int[m];
		
//		int[] answer = new int[n+m];
		
		for(int i=0; i<n; i++) narr[i] = sc.nextInt();
		for(int i=0; i<m; i++) marr[i] = sc.nextInt();
		
		int nstart=0;
		int mstart=0;
//		int idx=0;
		
		//마지막 인덱스까지
		while(nstart<n && mstart<m) {
			if(narr[nstart] <= marr[mstart]) sb.append(narr[nstart++]).append(" ");
			else sb.append(marr[mstart++]).append(" ");
		}
		
		if(nstart<n) {
			for(int i=nstart; i<n; i++) sb.append(narr[nstart++]).append(" ");
		}
		else {
			for(int i=mstart; i<m; i++)  sb.append(marr[mstart++]).append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
