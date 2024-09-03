package B2447;

/**
 * 랜선 자르기(실버2) -> 시간 초과.... -> 이진 탐색으로
 *
 * 
 */
import java.util.Scanner;


public class Main {
	static int n,k,answer, finalans;
	static int[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		int sum = 0;
		list = new int[k];
		
		for(int i=0; i<k; i++) {
			list[i] = sc.nextInt();
			sum += list[i];
		}
		answer = sum/n; //최대 길이, 여기서부터 한칸씩 내려옴. //갱신
//		System.out.println(answer);
		
		recurr(answer); // ans길이의 랜선들을 만들었을때, n개가 나오는가.
		
		System.out.println(finalans);
	}

	private static void recurr(int answer) { //하나씩 줄여 나감
		//1. 몇개를 만들 수 있는지 먼저 판단 
		//2. -> n개거나 그 이상이면 return;
		//3. n개 이하이면 ans--; recurr(ans); -> 다시 확인
		
		//1. 몇개까지 조각 랜선을 만들 수 있는지 만들 수 있는지 확인 // 총갯수=cnt
//		System.out.println("answer "+answer);
		int cnt = 0;
		for(int i=0; i<k; i++) {
			//랜선 하나를 선책
			//나눴을때 값이 존재할때까지. 1까지 허용.
			//딱 떨어지는 경우에도 몫은 존재. 0인 경우는 나눠지는 수가 더 작을 경우 밖에 없음
//			System.out.println("요소 "+list[i]);
			int tmp = list[i];
			while((tmp/answer) >= 1) {
				cnt++;
				tmp -= answer;
			}
		}
//		System.out.println(cnt);
		
		//2. cnt가 n개 이상일때 -> answer = cnt ; return;
		if(cnt>=n) {
//			System.out.println("정답 - answer "+answer);
//			answer = cnt;
			finalans = answer;

			return;
		}
		//3. n개보다 작으면 더 작은 값으로 나눠야함.
		else {
			recurr(answer-1);
			return;
		}
	}

}
