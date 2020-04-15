#include <stdio.h>
#include <iostream>
#include <cstring>
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

//스택구현
void initStack(Stack *s);
bool isEmpty(Stack *s);
void pushBack(Stack *s, int data);
bool pop(Stack* s);
char peek(Stack* s);


int main(int argc, const char *argv[])
{
    //커서 기준 좌, 우 데이터를 담을 스택 선언
    Stack leftStack, rightStack;
    int T;
    cin >> T;
    
    for (int tc = 1; tc < T + 1;tc++)
    {
        //input 데이터를 담을 string변수 L, 출력변수 answer 선언
        string L,answer;
        cin >> L;
        
        //인풋데이터 순회
        for(int i=0; i<L.size(); i++)
        {
            switch(L[i])
            {
                //백스페이스일때, 왼쪽스택의 마지막 데이터 삭제
                case '-':
                    if(!isEmpty(&leftStack))
                        pop(&leftStack);
                    break;
                //'<' 일때 왼쪽 스택의 마지막 데이터를 오른쪽 스택에 push
                case '<':
                    if(!isEmpty(&leftStack))
                    {
                        pushBack(&rightStack,peek(&leftStack));
                        pop(&leftStack);
                    }
                    break;
                //'>' 일때 오른쪽 스택의 마지막 데이터를 왼쪽 스택에 push
                case '>':
                    if(!isEmpty(&rightStack))
                    {
                        pushBack(&leftStack, peek(&rightStack));
                        pop(&rightStack);
                    }
                    break;
                //일반 문자일 경우 왼쪽스택에 데이터 push
                default:
                    pushBack(&leftStack, L[i]);
                    break;
            }
        }
        
        //왼쪽 스택의 데이터를 꺼내 오른쪽 스택에 합친다.
        while(!isEmpty(&leftStack))
        {
            pushBack(&rightStack,peek(&leftStack));
            pop(&leftStack);
        }
        
        
        //오른쪽 스택의 데이터를 꺼내 answer 문자열 끝에 붙인다.
        while(!isEmpty(&rightStack))
        {
            answer += peek(&rightStack);
            pop(&rightStack);
        }
        
        //결과 출력
        cout << answer <<endl;
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

char peek(Stack* s)
{
    return isEmpty(s) ? 0 : s->top->data;
}

