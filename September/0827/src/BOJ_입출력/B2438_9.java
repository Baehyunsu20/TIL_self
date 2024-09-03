package BOJ_입출력;

import java.util.Scanner;

public class B2438_9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		int snum = 1;
		for(int i=1; i<=n; i++) {
			//별의 갯수가 홀수개씩 늘어날 경우
			//공백은 4,3,2,1
			
				for(int blank=0; blank<n-i; blank++) {
					System.out.print("-");
				}
				
				for(int k=0; k<snum; k++) {
					System.out.print("*");
					
				}
				snum += 2;
				System.out.println();
		}
		
	}

}
