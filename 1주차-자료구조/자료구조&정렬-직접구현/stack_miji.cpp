

#include <iostream>

using namespace std;

template <class T>
class MyStack {
    int top; //스택의 가장 윗부분
    T data[10];
public:
    MyStack() {
        top = -1; //인덱스가 -1일때 스택은 비어있음
    };
    void push(T element) {
        if (top == 9) {
            cout << "STACK IS FULL. CANNOT ADD MORE" << endl;
            return;
        }
        top++;//인덱스 증가
        data[top] = element; // 원소 배열에 추가

       cout << data[top] << endl;
        

    
    };
    T pop() {
        if (top == -1) {
            cout << "STACK IS EMPTY" << endl;
        }
        T temp;
        temp = data[top--];
        cout << temp << endl;
        return temp;
        
    };
};


int main()
{
    MyStack<int> stack;
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.pop(); //3 출력

}

