package B4963;

import java.util.*;

/**
 * 섬의 갯수 찾기 : 1은 땅, 0은 바다이다.
 * 입력의 마지막 줄에는 0이 두 개 주어진다.
 */

public class Main {
	//사방탐색을 위해 static으로 설정
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static int[][] table;
 	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		//임의의 N개 처리 -> while(입력이 존재하는 동안 = hasNext() _ boolean으로 판단)
		while(sc.hasNext()) {
			int width = sc.nextInt();
			int height = sc.nextInt();
			if(width ==0 && height ==0) {
				break;
			}
			table = new int[height][width]; //3, 2 -> 2줄. 3열
			
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {table[i][j] = sc.nextInt();}} //입력 완료.
			
			System.out.println(Arrays.deepToString(table));
			System.out.println("----");
			
			
			
			
		}
		
	}
	
	static String input = "1 1\r\n"
			+ "0\r\n"
			+ "2 2\r\n"
			+ "0 1\r\n"
			+ "1 0\r\n"
			+ "3 2\r\n"
			+ "1 1 1\r\n"
			+ "1 1 1\r\n"
			+ "5 4\r\n"
			+ "1 0 1 0 0\r\n"
			+ "1 0 0 0 0\r\n"
			+ "1 0 1 0 1\r\n"
			+ "1 0 0 1 0\r\n"
			+ "5 4\r\n"
			+ "1 1 1 0 1\r\n"
			+ "1 0 1 0 1\r\n"
			+ "1 0 1 0 1\r\n"
			+ "1 0 1 1 1\r\n"
			+ "5 5\r\n"
			+ "1 0 1 0 1\r\n"
			+ "0 0 0 0 0\r\n"
			+ "1 0 1 0 1\r\n"
			+ "0 0 0 0 0\r\n"
			+ "1 0 1 0 1\r\n"
			+ "0 0";

}
