package B1654;
/**
 * 
 * 정답 코드 시잉이ㅣ잉이ㅣㅇ발.
랜선의 길이 최소값 = 1, 랜선 길이의 최대값 = 입력의 최댓값 = max
이진 탐색
수의 범위 : 
이미 가지는 랜선의 갯수 k = 1부터 10000까지 가능
원하는 랜선의 갯수 n = 1부터 백만까지 가능

 */
import java.util.*;
public class Solution_이진탐색 {
	
	static int n, k;
	static long ans;//
	static long[] arr;
	
	public static void main(String[] args) {
		Scanner sc= new	Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		arr = new long[k]; //k개의 입력을 받아야함.
		long max = 0; //최대 길이
		for(int i=0; i<k; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]); // 입력 중 최대값을 구함.
		}
		
		ans = 1;
		//최소와 최소를 가지고 mid 값으로 판단.
//		System.out.println(max + "mx값");
		recurr(1,max);
		
		System.out.println(ans);
		
		
		
	}

	private static void recurr(long min, long max) {
		
		//기저 조건 : 다 쪼개고 둘이 같을 떄
		if(min >= max) {//재귀를 할때 범위에 1을 더했으니까 등호는 빼야함.
			return;
		}
		
		//mid길이로 쪼갰을 경우 n개이상의 랜선을 만들 수 있는가.
		//1. n개 이상 만들 수 있으면, 더 큰 값으로 재귀
		long mid = (min+max)/2;
		//
		int cnt = 0;
		for(int i=0; i<k; i++) {
			//각 랜선을 확인
			cnt += arr[i]/mid; //cnt개를 만들 수 있음.
		}

		if(cnt>=n) {//더 큰값으로 쪼개기
			//기존의 ans(n개를 만들 수 있는 최대길이와 비교해서 갱신)
			ans=mid; //수정부분
			//여기서 무한에 빠지는 듯
//			System.out.println("왜 무한 : "+mid +" "+ max);
			//mid=200이고, max=201이면 무한 루프에 빠짐.
			recurr(mid+1, max); //+- 1 안해주면 무한 루프 발생
		}
		else {//cnt가 더 작을 떄 -> 작은 값으로 쪼개야함.
			recurr(min, mid-1);
		}	
	}
}
