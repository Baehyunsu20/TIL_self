package Collection_0824;
import java.util.*;
import java.io.*;
/**
 * 들어갈 수 있는 문자 : *, + , ()
 */


public class 계산기3 {
	static Stack<Character> operator = new Stack<>();
	static Stack<Integer> number = new Stack<>();
	
	//map으로 우선순위 할당
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('*', 2);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input (8).txt"));
//		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			//총 10개의 테스트케이스
			
			operator = new Stack<>();
			number = new Stack<>();
			
			//인풋의 총길이
			int size = sc.nextInt();
			String line = sc.next();
			//후위표기식을 담을 배열
			ArrayList<Character> post = new ArrayList<>();
			
			for(int k=0; k<size; k++) {
				//문자열 하나를 가져옴
				char c=line.charAt(k);
				//숫자일 경우에는 후위연산 배열에 넣어줘야함
				if(c>='0' && c<='9') {
					//값을 배열에 넣어줌
					post.add(c);
				}
				else if(c=='(') {
					operator.add(c);
					
				}
				else if(c==')') {
					//열린괄호가 보일 때까지 내보냄
					while(operator.peek() != '('){
						post.add(operator.pop());
					}
					//마지막에 남은 열리 괄호 뺴기
					operator.pop();

				}
				else {
					//+, * 연산식이 나왔을 경우에는,
					//스택이 비어있지 않고, peek가 열린 괄호가 아니며, 우
					//우선순위가 낮은 연산자가 올떄까지 pop하고 나즁에 push
					while(!operator.isEmpty() && operator.peek() != '(' && map.get(operator.peek())>= map.get(c)) {
						post.add(operator.pop());
					}
					operator.push(c);
				}
				
			}
			//괄호로 차있는 스택을 비워줌.
			while(!operator.isEmpty()) {
				post.add(operator.pop());
			}//후위표기식 완성
			
			//후위표기식 계산
			for(int l=0; l<post.size(); l++) {
				char c = post.get(l);
				//숫자일 경우,
				if(c>='0' && c<='9') {
					int tmp = c - '0';
					number.add(tmp);
				}
				else {
					//연산자가 들어온 경우에는 앞의 두개의 수를 뺴서 연산하고 다시 넣어줌
					int num2 = number.pop();
					int num1 = number.pop();
					if(c=='*') {
						int ans = num1*num2;
						number.push(ans);
						
					}
					else {
						int ans = num1+num2;
						number.push(ans);
						
					}
					
				}
				
			}
			int answer = number.pop();
			
			System.out.println("#"+t+" "+answer);
			
			
			
			
			
			
			
		}
		
		
		
		
		
	}

}
