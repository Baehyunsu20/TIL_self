package 러국;

import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] paint_cnt = new int[n][3];
			//바꿀 수 있는 최소를 찾아야함.
			int answer = Integer.MAX_VALUE;
			
			for(int i=0; i<n; i++) {
				char[] input = sc.next().toCharArray();
				for(int j=0; j<m; j++) {
					if(input[j] == 'W') {
						paint_cnt[i][0]++;
					}
					else if(input[j] == 'B') {
						paint_cnt[i][1]++;
					}
					else if(input[j] == 'R') {
						paint_cnt[i][2]++;
					}
				}
			}
			//이제 i,j,k로 총 합이 N이 되게함. 근데 최소한 한줄은 있어야함.
			for(int i=1; i<n-1; i++) {
				for(int j=1; j<n-1; j++) {
					for(int k=1; k<n-1; k++) {
						
						int temp = 0;
						
						if(i+j+k == n) {
							
							for(int a=0; a<i; a++) {
								//a번째 줄에서의 갯수
								temp = temp + paint_cnt[a][1] + paint_cnt[a][2];
							}
							for(int a=i; a<i+j; a++) {
								temp = temp + paint_cnt[a][0] + paint_cnt[a][2];
								
							}
							for(int a=i+j; a<n; a++) {
								temp = temp + paint_cnt[a][0] + paint_cnt[a][1];
								
							}
							
							if(temp < answer) {
								answer = temp;
							}
							
							
						}
						
						
					}
				}
			}
			System.out.println("#"+t+" "+answer);

		}
		
		
		
	}
}
