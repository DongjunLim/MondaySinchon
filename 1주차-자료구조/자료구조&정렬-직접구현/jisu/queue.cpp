#include <iostream>

using namespace std;

template <typename T>
class Node {
public:
	T data;
	Node<T>* next;
};

// 큐 구현부 - 링크드 리스트, 템플릿 사용
template <typename T>
class Queue {
public:
	Queue() {
		front = rear = NULL;
	}

	// enque rear를 갱신하며 데이터를 추가한다.  
	void enqueue(T data) {
		Node<T> *node = new Node<T>;
		node->data = data;
		node->next = NULL;
		if (is_empty()) {
			front = rear = node;
		}
		else {
			rear->next = node;
			rear = rear->next;
		}
		data_len++;
	}

	// dequeue 맨 앞의 데이터를 지우며 반환한다.
	template <typename T>
	T dequeue() {

		if (is_empty()) {
			cout << "error" << endl;
			return 0;
		}

		Node<T> *del = front;
		T temp = del->data;
		front = del->next;
		free(del);
		data_len--;
		return temp;
	}

	int size() {
		return data_len;
	}

	bool is_empty() {
		return data_len == 0;
	}

private:
	Node<T> *front, *rear;
	int data_len = 0;
};

int main() {

	Queue<int> q;

	cout << "size is" << q.size() << endl;

	for (int i = 1; i <= 10; i++)
		q.enqueue(i);

	cout << "size is" << q.size() << endl;
	
	while (!q.is_empty())
		cout << q.dequeue<int>() << endl;

	cout << "size is" << q.size() << endl;

}