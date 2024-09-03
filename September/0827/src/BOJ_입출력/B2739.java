package BOJ_입출력;
import java.util.*;

public class B2739 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%s * %s = %s\n", n,i,(n*i));
		}
		
	}

}
