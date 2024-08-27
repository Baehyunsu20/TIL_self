package array;
import java.util.Scanner;
/**
 * 0729 장표에 있음. 
 */

public class gravity {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] board = new int[8][9];
		
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 9; c++) {
				board[r][c] = sc.nextInt();
			}
		}
		
		int max = 0;
		
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 9; c++) {
				int count = 0;
				if (board[r][c] == 1) {
					for (int i = 1; c + i < 9; i++) {
						if (board[r][c+i] == 0) {
							count++;
						}
					}
				}
				if (count > max) {
					max = count;
				}
			}
		}
		System.out.println(max);
	}
}
