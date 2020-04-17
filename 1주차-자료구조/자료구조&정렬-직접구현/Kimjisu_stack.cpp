#include <iostream>
#include <string>

using namespace std;

template <typename T>
class Node {
public:
	T data;
	Node<T>* next;
};

// 스택 구현부 - 링크드 리스트, 템플릿 사용
template <typename T>
class Stack{
public:
	Stack() {
		this->head = NULL;
	}
	~Stack() {}

	void push(T input_data){
		Node<T>* node = new Node<T>;
		if (this->is_empty()) {
			this->head = node;
			node->data = input_data;
			node->next = NULL;
		}
		else {
			node->data = input_data;
			node->next = this->head;
			this->head = node;
		}

	}

	void pop(){
		if (this->is_empty()) {
			cout << "underflow" << endl;
			
		}
		else {
			head = head->next;
			
		}
		
	}

	void top(){
		if (this->is_empty())
			cout << "NULL";
		else 
			cout << head->data;
	}

	bool is_empty(){
		if (head == NULL)
			return 1;
		else
			return 0;
	}

private:
	Node<T>* head;
};


int main(void) {
	int n;
	cin >> n;
	Stack<int> stk;
	string str;

	// 테스트 부분 : 입력에 해당하는 메소드 테스트
	for (int i = 0; i < n; i++) {
		cin >> str;
		if (str == "push") {
			int num;
			cin >> num;
			stk.push(num);
		}
		else if (str == "pop") {
			if (!stk.is_empty()) {
				stk.pop();
			}
			else {
				cout << "-1" << "\n";
			}
		}
		else if (str == "empty") {
			if (stk.is_empty()) {
				cout << "1" << "\n";
			}
			else {
				cout << "0" << "\n";
			}
		}
		else if (str == "top") {
			if (!stk.is_empty()) {
				stk.top();
			}
			else {
				cout << "-1" << "\n";
			}
		}
	}
	return 0;
}