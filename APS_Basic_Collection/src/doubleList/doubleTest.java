package doubleList;

class Node {
	String data; 
	Node prev;
	Node next;
}

class DoublelinkList {
	Node head;
	Node tail;
	int size;
	//생성자
	public DoublelinkList() {
		//비어있는 조건을 설정함.
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		
	}
	
	//메서드 생성
	
	//1. 삽입
	void addData(int i, String data) {
		if(i<0 || i>size) {
			return;
		}
		
		size++;
		
		//삽입 위치 전 노드를 찾음
		Node curr = head;
		for(int k=0; k<i; k++) {
			curr = curr.next;
		}
		
		Node newNode = new Node();
		newNode.data = data;
		newNode.next=curr.next;
		newNode.prev = curr;
		
		//기존 노드 수정
		curr.next.prev = newNode;
		curr.next = newNode;
		
	}
	
	//2. 삭제
	void removeData(int i) {
		if(i>=size || i<0) {
			return;
		}
		size--;
		
		//삭제할 노드 찾기 또는 삭제할 노드의 앞 노드 찾기
		//나는 앞 노드 찾기
		Node curr = head;
		for(int k=0; k<i; k++) {
			curr = curr.next;
		}
		//삭제할 원소의 앞부분 노드 = curr
		curr.next.next.prev = curr;
		curr.next = curr.next.next;

	}
	
	void printReverse() {
		Node curr = head.next;
//		String str = "";
		while(curr != tail) {
//			str = "<-" + curr.data + str;
			System.out.print(curr.data + "->" );
			curr = curr.next;
			
		}
		System.out.println();
	}
	
	
	
}

public class doubleTest {
	public static void main(String[] args) {
		DoublelinkList list = new DoublelinkList();
		list.addData(0, "현수");
		list.printReverse();
		list.addData(0, "미정");
		list.printReverse();
		list.addData(0, "상주");
		list.printReverse();
		list.removeData(0);
		list.printReverse();
		
	}
	

}
