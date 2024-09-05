package softeer;
/**
 * GPT도 제대로 못 푸는디 -> 실패...
 * i번째의 요소 : 놓여있는 선물의 갯수
 * 양수 : 산타의 선물 공급처 // 음수 : 산타의 고객층 (줘야함)
 * 시작점을 잘 골라서 모든 선물 배달을 완료한 뒤(모든 인덱스의 값이 0이 되어야함) 다시 시작점으로 돌아와야함.
 * 최소 시간을 구해라.
 * 
 * DFS로 문제를 풀이해야함.
 */
import java.util.*;

public class L4_선물나눠주기 {

	static List<Integer>[] tree; // List를 요소로 갖는 배열[] tree
	static long[] a; //마을별 줄 수 있는 선물의 갯수-> 양수는 산타가 가져감 / 음수는 산타가 주고감
	static long totaltime;
	static long[] subTreeNeed; //한 마을을 시작으로 하는 서브트리에서 필요한 총 선물 수.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		//마을의 개수를 입력 받음
		int n = sc.nextInt();
		
		//tree[0] : 1번 마을과 연결되어있는 마을의 번호들을 ArrayList로
		tree = new ArrayList[n]; //트리 안에 ArrayList가 n개가 존재
		for(int i=0; i<n; i++) {
			//값 초기화
			tree[i] = new ArrayList<>(); // 각 마을 idx에 연결된 마을 리스트를 만들기 위해 초기화
		}
		
		//각 마을별 선물의 갯수를 기록
		for(int i=0; i<n; i++) a[i] = sc.nextLong();
		
		//각 마을에 연결되어있는 인접 마을을 tree에 채움(최초의 연결)
		for(int i=0; i<n; i++) {
			//양방향 연결이기에 바꿔서도 해줘햐함.
			int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            tree[v1].add(v2);
            tree[v2].add(v1);
		}
		
		//초기 상태에서의 최소의 totaltime;
		totaltime = 0;
		dfs(0, -1); // 시작 인덱스 0, 해당 인덱스의 직전 인덱스
		long result = totaltime;
//		calMin(0,-1);
		System.out.println(result);
		
		//추가정보 적용
		int q = sc.nextInt();
		for(int i=0; i<q; i++) {
			
			int x = sc.nextInt() -1; //선물 수를 더해줄 마을의 인덱스
			int y = sc.nextInt() -1; //선물 수를 빼 줄 마을의 인덱스
			
			long gift = sc.nextLong();
			
			a[x] += gift;
			a[y] -= gift;
			
			//변동된 정보로 다시 최소 시간
			dfs(0,-1); 
			
			result = totaltime;
			System.out.println(result);
		}
	}
	
	private static long dfs(int node, int parent) { 
		// node는 내가 있는 인덱스, parent 내가 거쳐왔던 직전의 인덱스
		
		long need = a[node]; // 현재 위치에서 존재하는 선물의 갯수
		// 만약 a[1] = 2라면 두번째 마을에서는 2개의 선물을  산타가 가져감
		for(int child:tree[node]) {
			//child = 현재 인덱스인 node에서 갈 수 있는 마을의 인덱스
			if(child != parent) {// 양방향 노드이므로 다시 갔던 곳으로 돌아가지 않기 위한 조건
				long childneed = dfs(child,node);
				need += childneed;
				totaltime += Math.abs(childneed);
			}
			
			if(parent != -1) {
//				totaltime += 
			}
		}
		return need;
		
	}

	static String input ="7\r\n"
			+ "0 1 -2 1 0 0 0\r\n"
			+ "1 2\r\n"
			+ "2 3\r\n"
			+ "3 4\r\n"
			+ "4 5\r\n"
			+ "3 6\r\n"
			+ "6 7\r\n"
			+ "2\r\n"
			+ "5 6 4\r\n"
			+ "1 7 2";


}
