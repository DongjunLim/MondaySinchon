#include <iostream>

using namespace std;

template <typename T>
class Node {
public:
	T data;
	Node<T>* next;
};

// ť ������ - ��ũ�� ����Ʈ, ���ø� ���
template <typename T>
class Queue {
public:
	Queue() {
		front = rear = NULL;
	}

	// enque rear�� �����ϸ� �����͸� �߰��Ѵ�.  
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

	// dequeue �� ���� �����͸� ����� ��ȯ�Ѵ�.
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