package Collection_0824;

class Node {
	String data;
	Node link;
}

class singleLinkedList {
	Node head;
	int size;
	
	singleLinkedList() {
		//더미값을 지정
		//indx=0은 head와 첫번째 요소 사이
		head = new Node();
	}
	
	//추가
	void addData(int i, String data) {
		
		if(i>size || i<0) return;
		
		//새로 정의
		Node newNode = new Node();
		newNode.data = data;
		
		size++;
		//직전 노드 curr를 찾기 위한 순회
		Node curr=head;
		for(int k=0; k<i; k++) {
			curr = curr.link; 
		}
		newNode.link = curr.link;
		curr.link = newNode;
		
		

	}
	
	//삭제
	void removeData(int i) {
		if(i<0 || i>=size) {
			System.out.println("잘못된 입력");
			return;
		}
		size--;
		//삭제할 직전의 node까지 가야함.
		Node curr = head;
		for(int k=0; k<i; k++) {
			curr = curr.link;
		}
		curr.link = curr.link.link;
		
	}
	
	//조회
	void printAll() {
		//첫번째 데이터 요소
		Node curr = head.link;
		while(curr != null) {
			System.out.print(curr.data + "->");
			//마지막 원소의 경우, curr이 null이 되고, 다음 턴에서 반복을 빠져나감
			curr = curr.link;
		}
		System.out.println();
	}
	
		
	
	
	

}


public class singleLinked{
	public static void main(String[] args) {
		singleLinkedList list = new singleLinkedList();
		
		list.addData(0, "현수");
		list.addData(1, "혜원");
		list.addData(1, "민서");
		list.printAll();
		list.addData(2, "보성");
		list.printAll();

	
}
}
