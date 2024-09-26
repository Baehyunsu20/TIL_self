package S1952_수영장;
import java.util.*;
/**
 * DP로 문제 풀기 
 * 월별 DP 배열 만들기
 */

public class Solution {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int[] cost = new int[4]; // 1일, 1달, 3달, 1년
			int[] dp = new int[13]; //1월부터 12월까지
			int[] plan = new int[13]; //1월부터 12월까지
			
			//이용권별 가격(cost)와 이용계획(plan)을 입력받음
			for(int i=0; i<4; i++) cost[i] = sc.nextInt();
			for(int i=1; i<=12; i++) plan[i] = sc.nextInt();
			
			//동적계획으로 가장 적은 비용을 가질 수 있는 이용권의 총합을 각 월별 저장
			
			//1. 초기값 설정
			// 하루 이용권, 한달 이용권 중 더 작은 값을 넣음
			dp[1] = Math.min(plan[1] * cost[0], cost[1]); //1월
			dp[2] = dp[1] + Math.min(plan[2] * cost[0], cost[1]); //2월
			
			
			for(int mon=3; mon<=12; mon++) {
				
				int[] tmp = new int[3];
				//직전값과 1일권
				tmp[0] = dp[mon-1] +(plan[mon] * cost[0]);
				//직전값과 한달권
				tmp[1] = dp[mon-1] + cost[1];
				//3달전 최소값 + 3달권
				tmp[2] = dp[mon-3] + cost[2];
				
				//3개의 값 중 최솟값 구하기
				int m=tmp[0];
				for(int i:tmp)m=Math.min(m, i);
				
				dp[mon] = m;
			}
			
			int ans = Math.min(dp[12], cost[3]);
			System.out.println("#"+t+" "+ans);
			
			
		}
		
		
	}
	
	
	
	static String  input = "10\r\n"
			
			+ "10 40 100 300\r\n"
			+ "0 0 2 9 1 5 0 0 0 0 0 0\r\n"
			
			+ "10 100 50 300\r\n"
			+ "0 0 0 0 0 0 0 0 6 2 7 8\r\n"
			
			+ "10 70 180 400\r\n"
			+ "6 9 7 7 7 5 5 0 0 0 0 0\r\n"
			
			+ "10 70 200 550\r\n"
			+ "0 0 0 0 8 9 6 9 6 9 8 6\r\n"
			
			+ "10 80 200 550\r\n"
			+ "0 8 9 15 1 13 2 4 9 0 0 0\r\n"
			
			+ "10 130 360 1200\r\n"
			+ "0 0 0 15 14 11 15 13 12 15 10 15\r\n"
			
			+ "10 180 520 1900\r\n"
			+ "0 18 16 16 19 19 18 18 15 16 17 16\r\n"
			
			+ "10 100 200 1060\r\n"
			+ "12 9 11 13 11 8 6 12 8 7 15 6\r\n"
			
			+ "10 170 500 1980\r\n"
			+ "19 18 18 17 15 19 19 16 19 15 17 18\r\n"
			
			+ "10 200 580 2320\r\n"
			+ "12 28 24 24 29 25 23 26 26 28 27 22";


}
