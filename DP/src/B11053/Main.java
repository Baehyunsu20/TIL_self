package B11053;
/**
 * 
 * 까다롭군...
 * LIS문제("longest increasing subsequence")
6
10 20 10 30 20 50 
7
20 30 10 20 30 40 30

내 알고리즘의 "반례" 수열 -> {20, 30, 10, 20, 30, 40, 30} -> 인접한 경우만 생각하면 틀림(5가 출력되지만 답은 4)



 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1]; // 인덱스 1부터 시작.
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) arr[i] = sc.nextInt();
        
        int maxlen=1; // 일단 요소가 한개일때는 최대값으로 설정.
        
        for(int i=1; i<=n; i++) {
        	//i번째 요소를 포함한다고 가정
        	dp[i] = 1; 
        	for(int j=1; j<i; j++) {//범위 : i번째의 직전 요소만 고려
        		if(arr[i]>arr[j]) {
        			dp[i] = Math.max(dp[i], dp[j]+1); //j번째 요소가 현재 보다 작을 경우 수열에 포함.
        		}//i와 j번째 요소를 포함하는 수열의 최대값을 구하고 maxlen을 갱신
        	}
        	maxlen = Math.max(maxlen, dp[i]); //i번째 요소를 포함하는 최대 수열의 길이와 전체의 최댓값을 비교
        }
        
        System.out.println(maxlen);

    }
}
