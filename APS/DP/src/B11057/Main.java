package B11057;
/**
 * 오르막수 -> (재귀)시간 초과 시불.
 * 수의 길이 -> 문자열의 길이 n만 주어지고 
 * 0~9까지의 조합을 만들고
 * 다 만들었을때, sort와 값이 같을때만.
 */
import java.util.*;

public class Main {
	static int n;
	static int[] num;
	static long cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		num = new int[n];// 0부터 9까지의 숫자.
		//첫인덱스와 끝인덱스 = 첫번쨰 숫자로 0도 가능
		recurr(0,0,9);
		
		System.out.println(cnt%10007);
	}

	private static void recurr(int idx, int start, int end) {
		if(idx==n) { 
			cnt++; //n길이의 숫자 배열 완성.
//			System.out.println(Arrays.toString(num));
			return;
		}
		
		
		//start-end의 숫자를 하나 고름
		for(int i=start; i<=end; i++) {
			num[idx] = i; // 범위 안의 숫자를 넣음
			recurr(idx+1, i, end);
		}
	}

}
