#include <stdio.h>
#include <iostream>
#include <cstring>
#define MAX 50
using namespace std;

struct Node
{
    char data;
    Node *preNode;
};

struct Stack
{
    Node *top;
};

void initStack(Stack*);
bool isEmpty(Stack*);
void pushBack(Stack* , int);
bool pop(Stack*);

int main(int argc, const char *argv[])
{
    Stack stack;
    int T;              //테스트 횟수
    char ps[MAX];       //입력을 받을 문자열 배열

    cin >> T;
    for (int tc = 1; tc < T + 1; tc++)
    {
        //스택 초기화
        initStack(&stack);

        //문자열 받음
        cin >> ps;
        
        //문자열 순회
        for(int i=0; i<strlen(ps); i++)
        {
            //')'는 pop
            if (ps[i] == ')')
            {
                //스택이 비어있는데 pop을 해야 할 경우 반복문 종료
                if (!(pop(&stack)))
                {
                    pushBack(&stack, ps[i]);    //반복문 종료 전에 스택에 값을 채워서 empty 방지
                    break;
                }
            }
            else
            {
                //'('는 스택에 push
                pushBack(&stack, ps[i]);
            }
        }
        //스택이 비어있으면 쌍이 맞으므로 YES 출력 아닐경우 NO 출력
        isEmpty(&stack) ? cout << "YES" : cout << "NO";
        cout << endl;
    }
}


void initStack(Stack *s)
{
    s->top = NULL;
}

bool isEmpty(Stack *s)
{
    return s->top == NULL;
}

void pushBack(Stack *s, int data)
{
    Node* newNode = (Node *)malloc(sizeof(Node));
    newNode->data = data;
    newNode->preNode = s->top;

    s->top = newNode;
    return;
}

bool pop(Stack *s)
{
    if (isEmpty(s))
    {
        return false;
    }
    Node* temp = s->top;
    s->top = s->top->preNode;
    free(temp);
    
    return true;
}
