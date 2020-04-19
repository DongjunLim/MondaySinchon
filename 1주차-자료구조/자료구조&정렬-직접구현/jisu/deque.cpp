#include <iostream>
#include <sstream>

using namespace std;

template <typename T>
class Node {
public:
	T data;
	Node<T>* next;
	Node<T>* prev;
};

// 덱 구현부 - 링크드 리스트, 템플릿 사용
template <typename T>
class Deque {
private:
	Node<T> *front, *rear;
	int data_len = 0;

public:
	Deque() {
		front = rear = NULL;
		data_len = 0;
	}
	template <typename T>
	void push_front(T data) {
		Node<T>* node = new Node<T>;
		node->data = data;
		node->next = NULL;
		if (front == NULL) {
			rear = front = node;
		}
		else {
			node->next = front;
			front->prev = node;
			front = node;
		}

		data_len++;
	}
	template <typename T>
	void push_rear(int data) {
		Node<T> *node = new Node<T>;
		node->data = data;
		node->next = NULL;
		if (is_empty()) {
			front = rear = node;
		}
		else {
			rear->next = node;
			node->prev = rear;
			rear = rear->next;
		}
		data_len++;
	}
	template <typename T>
	void del_front() {
		if (front == NULL) {
			cout << -1;
		}
		else {
			Node<T>* temp = front;
			front = front->next;

			if (front == NULL) {
				rear = NULL;
			}
			else {
				front->prev = NULL;
			}
			free(temp);
			data_len--;
		}
	}

	template <typename T>
	void del_rear() {
		if (front == NULL) {
			cout << -1;
		}
		else {
			cout << rear->data;

			Node<T>* temp = rear;
			rear = rear->prev;

			if (rear == NULL) {
				front = NULL;
			}
			else {
				rear->next = NULL;
			}
			free(temp);
			data_len--;
		}
		cout << endl;
	}

	int get_front() {
		if (front == NULL) {
			return -1;
		}
		else {
			return front->data;
		}
	}

	int get_rear() {
		if (front == NULL) {
			return -1;
		}
		else {
			return rear->data;
		}
	}

	int is_empty() {
		if (front == NULL) {
			return 1;
		}
		else {
			return 0;
		}

	}

	int get_size() {
		return data_len;
	}
};



int main() {
	Deque<int> dq;
	// 테스트 부분
	cout << "size is" << dq.get_size() << endl;

	for (int i = 1; i <= 10; i++) {
		dq.push_front<int>(i);
		dq.push_rear<int>(i);
	}

	dq.get_front();
	dq.get_rear();

	cout << "size is" << dq.get_size() << endl;

	while (!dq.is_empty()) {
		dq.del_front<int>();
		dq.del_rear<int>();
	}
		

	cout << "size is" << dq.get_size() << endl;


	return 0;
}