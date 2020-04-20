
#include <iostream>


using namespace std;

template<typename T>
class Node { //노드 생성 클라스

public: 
	 T value; 
	  Node* next; 
	  
	  Node() :value(0), next(nullptr) {}; 
	  ~Node() {};

  
};

template<typename T>
class Queue { //큐 생성 클라스
public:
	Queue() :head(nullptr), tail(nullptr), size(0) {}; //헤드와 테일은 널포인터로 설정, 사이즈 0으로 설정
	~Queue() {}; 
	void push(T _value);  //push data
	T pop(); //pop data
	bool empty();
	Node<T>* head, * tail; //헤드와 테일 포인터변수로 선언
	int size; //큐 크기

};

template<typename T>
bool Queue<T>::empty() {
	if (tail == nullptr) { //아무것도 없을 때
		return true;
	}
	else {
		return false;
	}
}

template<typename T>
void Queue<T>::push(T _value) {
	Node<T>* newNode = new Node<T>; //새로운 노드 생성
	newNode->value = _value; // 새로운 노드에 새로우 값 대입
	if (empty()) {
		head = tail = newNode; //비어있었다면 헤드와 테일 둘 다 새로운 노드를 가르킴
	}
	else {//비어있지 않다면
		tail->next = newNode; 
		tail = tail->next;// 원래 테일을 다음 노드로 설정
	}
	size++;
}

template<typename T>
T Queue<T>::pop() {
	
	if (empty()) { //비어있다면
		cout << "NO DATA TO POP!" << endl;
	}
	else { //비어있지 않다면
		Node<T>* pointer = head; //헤드를 포인터 변수에 대입
		T value = head->value; //헤드의 값을 벨류에 대입

		if (head == tail) { //헤드와 테일이 같다면(자료가 하나만 남았다면)
			head = tail = nullptr; //둘 다 널 포인터 설정
		}
		else { 
			pointer = pointer->next; //포인터의 다음값을 포인터 변수에 대입
			delete(head); //원래 헤드값 삭제
			head = pointer; //포인터값을 헤드에 대입
		}

		return value;
	}

	size--;
}






int main()
{
	Queue<int> Q;
	Q.push(1);
	Q.push(2);
	Q.push(3);
	Q.push(4);
	Q.push(5);


	cout << Q.pop() << endl;
	cout << Q.pop() << endl;
	cout << Q.pop() << endl;
	cout << Q.pop() << endl;
	cout << Q.pop() << endl;
	cout << Q.pop() << endl;


	return 0;
}

/*
결과값:
1
2
3
4
5
NO DATA TO POP!
*/