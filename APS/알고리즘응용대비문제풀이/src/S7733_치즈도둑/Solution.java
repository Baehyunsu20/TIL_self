package S7733_치즈도둑;

import java.util.*;

class Solution{
	
	static int[][] cheese;
	static boolean[][] visited;
	static int n;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();
		for(int t=1; t<= T; t++) {
			n = sc.nextInt(); // 한변의 길이
			cheese = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) cheese[i][j] = sc.nextInt();
			} //치즈조각 입력 완료

			 int maxChunks = 0;  // 가장 많은 덩어리 개수 저장

	            // 1부터 100일까지 요정이 치즈를 갉아먹는 것을 시뮬레이션
	            for (int day = 0; day <= 100; day++) {
	                visited = new boolean[n][n];  // 방문 여부 초기화
	                int chunkCount = 0;  // 현재 덩어리 개수

	                // 모든 치즈 칸을 탐색하며 덩어리 찾기
	                for (int i = 0; i < n; i++) {
	                    for (int j = 0; j < n; j++) {
	                        // 덩어리 탐색
	                        if (cheese[i][j] > day && !visited[i][j]) {
	                            dfs(i, j, day);  // DFS로 덩어리 탐색
	                            chunkCount++;  // 덩어리 개수 증가
	                        }
	                    }
	                }

	                // 가장 많은 덩어리 개수 저장
	                maxChunks = Math.max(maxChunks, chunkCount);
	            }

	            // 출력
	            System.out.println("#" + t + " " + maxChunks);
	        }

	        sc.close();
	    }

	    // DFS로 치즈 덩어리 탐색
	    public static void dfs(int x, int y, int day) {
	        visited[x][y] = true;  // 방문 처리

	        // 네 방향으로 이동하며 덩어리 탐색
	        for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];

	            // 범위 내에 있고, 아직 방문하지 않았으며, 현재 날짜에 갉아먹히지 않은 치즈라면
	            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && cheese[nx][ny] > day) {
	                dfs(nx, ny, day);  // 재귀적으로 탐색
	            }
	        }
	    }
		
		
	
	static String input ="2\r\n"
			+ "2\r\n"
			+ "1 2\r\n"
			+ "2 1\r\n"
			+ "5\r\n"
			+ "6 8 2 6 2\r\n"
			+ "3 2 3 4 6\r\n"
			+ "6 7 3 3 2\r\n"
			+ "7 2 5 3 6\r\n"
			+ "8 9 5 2 7";
	
}