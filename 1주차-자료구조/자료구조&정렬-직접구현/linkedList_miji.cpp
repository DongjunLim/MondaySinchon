#include <iostream>

using namespace std;

class List
{
	class Node {
		public:
			int data;
			Node* nextNode;
		};

	void valid(int count); //예외처리를 하기 위한 함수
	int count;
	Node* Head = new Node; // 헤드 노드

public:
	List(); //생성자
	int get(int index); //해당 인덱스 데이터 출력
	void add(int Data); //맨 앞에 새로운 노드 추가
	void add(int Count, int Data); //해당 인덱스에 새로운 노드 추가
	int size(); //리스트 길이 리턴
	void set(int Index, int Data); //데이터값 변경
	void remove(int Index); //해당 인덱스 삭제
	bool isEmpty(); //객체가 비어있는지 확인

};

List::List() {
	Head->nextNode = NULL;
	List::count = 0;
}

int List::get(int index) {//해당 인덱스 데이터 출력
	try {
		valid(index);
	}
	catch (const char* msg) { //에러 출력
		cout << msg << endl;
		return -1;
	}

	Node* temp = Head; //헤드를 템프 포인터 변수에 대입
	for (int i = 0; i <= index; i++) { //인덱스까지 반복
		temp = temp->nextNode; //템프 변수에 다음 노드 포인터 대입
	}
	return temp->data; //템프가 가르키는 값 리턴
}

void List::valid(int count) { //객체 존재여부
	if (count > List::count) {
		throw "Error";
	}
}

void List::add(int Data) { //해당 데이터를 맨 앞에 대입
	Node* newNode = new Node; //새로운 노드 생성
	newNode->data = Data; //입력 데이터를 노드에 대입
	newNode->nextNode = NULL; //다음 포인터는 널 값으로 설정

	if (Head->nextNode == NULL) { //데이터가 하나만 존재했다면 입력데이터가 첫 데이터로 설정
		Head->nextNode = newNode;
	}
	else { //아니라면
		Node* temp = Head; //템프에 헤드 값 대입
		while (temp->nextNode != NULL) {
			temp = temp->nextNode; //템프의 다음 노드를 템프로 대입하고
		}
		temp->nextNode = newNode; //입력 데이터를 템프의 다음노드로 대입
	}
	List::count++;
}

void List::add(int index, int Data) { //해당 데이터를 해당 인덱스에 대입
	try {
		valid(index);
	}
	catch (const char* msg) {
		cout << msg << endl;
		return;
	}

	Node* newNode = new Node; 
	newNode->data = Data;
	newNode->nextNode = NULL;

	if (Head->nextNode == NULL) {
		Head->nextNode = newNode;
	}
	else {
		Node* temp = Head;
		for (int i = 0; i < count; i++) {
			temp = temp->nextNode;
		}
		newNode->nextNode = temp->nextNode;
		temp->nextNode = newNode;
	}
	List::count++;
}

void List::set(int index, int Data) {//데이터값 변경
	try {
		valid(index);
	}
	catch (const char* msg) {
		cout << msg << endl;
		return;
	}

	Node* temp = Head;
	for (int i = 0; i <= index; i++) {
		temp = temp->nextNode;
	}
	temp->data = Data; //변경된 데이터 저장
}

int List::size() {
	return List::count;
}

void List::remove(int index){ //해당 인덱스 데이터 삭제
	try {
		valid(index);
	}
	catch (const char* msg) {
		cout << msg << endl;
		return ;
	}

	Node* temp = Head;
	Node* remove = Head;
	for (int i = 0; i <= index; i++) { //해당 인덱스까지 반복
		temp = temp->nextNode;
		remove = remove->nextNode;
	}
	remove = remove->nextNode;

	temp->nextNode = remove->nextNode; //리무브의 다음노드를 템프의 다음노드로 대입
	remove->nextNode = NULL;
	delete remove; //리무브 삭제
	List::count--;
}

bool List::isEmpty() {
	Node* head = Head;
	if (head->nextNode == NULL) {
		return true;
	}
	else {
		return false;
	}
}

int main() {
	List test;

	test.add(10);
	test.add(20);
	test.add(30);
	test.add(3,40); //10,20,30,40
	test.remove(0); //20,30,40
	test.set(0,100); //100,30,40

	for (int i = 0; i < test.size(); i++) {
		cout << "데이터: " << test.get(i) << endl;
	}

	cout << "사이즈: " << test.size() << endl;
	
	

	return 0;
	
}
/* 결과:
데이터: 100
데이터: 30
데이터: 40
사이즈: 3

*/