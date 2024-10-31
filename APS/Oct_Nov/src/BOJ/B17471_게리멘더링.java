package BOJ;

import java.util.*;

// BFS와 DFS를 활용하네,,
//입력을 어떻게 받아올 것인가
//출력 : 두 선거구의 인구 차이의 최솟값, 나눌 수 없는 경우는 -1

public class B17471_게리멘더링 {
	static int ans = Integer.MAX_VALUE;
	//ArrayList안에 ArrayList존재
	static ArrayList<ArrayList<Integer>> list;
	static List<Integer> popular;
	static int n;
	static Queue<Integer> queue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //구역의 갯수
		
		//초기화
		list = new ArrayList<ArrayList<Integer>>();
		popular = new ArrayList<>();
		
		//인구수만 읽어옴
		for(int i=0; i<n; i++) popular.add(sc.nextInt());
		//연결된 선거구를 순차적으로 읽어옴
		for(int i=0; i<n; i++) {
			int num = sc.nextInt(); //몇개와 연결 되었는지
			ArrayList<Integer> link = new ArrayList<>();
			for(int j=0; j<num; j++) {
				link.add(sc.nextInt());
			}
			//이중리스트 구현
			list.add(link);
		}//입력 완료
		
		bfs();
		System.out.println(ans);
	}
	private static void bfs() {
		//0번째 -> 1번구역부터시작
		
		
		
		
	}

}
