package B1780;
/**
 * 종이의 갯수
 * 계속 3등분 -> 재귀.
 * 시작부분 
 * 3등분할때 각 부분의 시작점 :  0, n/3, (n/3) * 2
 * 9바이9일때 -> 0,3,6
 * 27바이27일때 ->0, 9, 18
 */
import java.util.*;
public class Main {
	static int[][] arr;
	static int[] cnt;
	
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 
		 StringBuilder sb = new StringBuilder();
		 arr = new int[n][n];
		 //cnt[0] = -1의 갯수
 		 cnt = new int[3];
		 
		 for(int i=0; i<n; i++) {
			 for(int j=0; j<n; j++) {
				 arr[i][j] = sc.nextInt();
			 }
		 }
		 
		 recurr(n,0,0);
		 
		 sb.append(cnt[0]).append("\n").append(cnt[1]).append("\n").append(cnt[2]);
		 System.out.println(sb.toString());

	}


	private static void recurr(int n, int i, int j) {
		
		//기저조건: 끝까지 갔을 경우.
		if(n==1) {
			//1개인 그룹으로까지 쪼개진 상황
			if(arr[i][j] == -1) {
				cnt[0]++;
			}
			else if(arr[i][j] == 0) {
				cnt[1]++;
			}
			else {
				cnt[2]++;
			}
			
			return;
		}
		
		//1. 덩어리의 요소가 모두 같은지 확인
		int tmp = arr[i][j];
		out:
		for(int k=0; k<n; k++) {
			for(int l=0; l<n; l++) {
				if(tmp != arr[i+k][j+l]) break out; //같지 않은 값이 나오면 이중반복문탈출
				
				if(k==n-1 && l==n-1) {
					//마지막 인덱스 까지 확인했는데 모두 같아서 반복문 탈출이 없다면 -> 모든 요소는 같다
					
					if(tmp== -1)cnt[0]++;
					else if(tmp == 0) cnt[1]++;
					else cnt[2]++;
					//해당 덩어리 탈출
					return;
					
				}
			}
		}
		
		//2. 덩어리의 값이 같지 않은 경우 -> 9개의 덩어리로 쪼갬 -> 9개의 시작점을 기점으로 다시 검사.
		for(int k=0; k<3; k++) {
			for(int l=0; l<3; l++) {
				//에러난 부분 : 기존 값에 더해줘야함
				int x = i+k*(n/3);
				int y = j+l*(n/3);
				//각자의 시작점에서 다시 처음부터 검사.
				//n=3일 때, (x,y) = ()
//				System.out.println("x " + x+ " y "+y);
				recurr(n/3, x, y);
			}
		}

	}

}
