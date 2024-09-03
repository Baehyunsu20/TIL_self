package B9465;
/**
 * 스티커
 */
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			//하나의 테케
			int col=sc.nextInt(); //10만까지 가능
			int[][] arr = new int[2][col];
			
			for(int i=0; i<col; i++) {
				for(int k=0; k<2; k++) {
					arr[i][k]=sc.nextInt();//입력받기.
				}
			}
			
			//visited를 이용한 트리 탐색은 안되겠지?
			
			
			
			
		}
	}

}
