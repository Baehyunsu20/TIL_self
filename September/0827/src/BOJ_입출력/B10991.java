package BOJ_입출력;

import java.util.Scanner;

public class B10991 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int snum=1;
		int blank=n-1;
		
		for(int i=1; i<=n; i++) {
			//공백 출력
			for(int b=0; b<blank; b++) {
				System.out.print(" ");
			}
			for(int star=0; star<snum; star++) {
				System.out.print("* ");
			}
			snum++;
			blank--;
			System.out.println();
			
			
			
		}
		
		
	}

}
