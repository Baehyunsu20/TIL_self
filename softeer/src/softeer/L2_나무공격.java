package softeer;
/**
 * 
6 8
0 0 1 0 0 0 1 0
0 0 0 1 0 0 0 0
0 0 1 0 0 1 1 0
0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0
1 5
2 6
 */
import java.util.*;

public class L2_나무공격 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int person = 0;
		int[][] arr = new int[n][m];
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				arr[r][c] = sc.nextInt();
				if(arr[r][c] ==1)person++;
			}
		}
//		System.out.println(Arrays.deepToString(arr));
		
		for(int t=1; t<=2; t++) { //두번의 나무 공격
			int L = sc.nextInt();
			int R = sc.nextInt();
			
			for(int i=L-1; i<R; i++) {
				for(int j=0; j<m; j++) {
					
					if(arr[i][j] == 1) {
						arr[i][j] = 0; //빼주고, 사람 수도 줄여줌.
						person--;
						break;
					}
				}
			}
			
		}
		System.out.println(person);
		
		
	}

}
