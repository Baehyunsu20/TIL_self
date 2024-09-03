package BOJ_입출력;

import java.util.Scanner;

public class B11721 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input =sc.next();
		input.charAt(0);
		int idx = 0;
		while(idx < input.length()) {
			for(int i=0; i<10; i++) {
				if(idx == input.length()) break;
				System.out.print(input.charAt(idx));
				idx++;
			}
			System.out.println();
			
		}
		
		
		
		
	}

}
