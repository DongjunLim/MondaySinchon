import sys
sys.stdin = open("./input.txt", "r")

#연결리스트 스택 구현
class Node:
    def __init__(self,data):
        self.data = data
        self.preNode = None

class Stack:
    def __init__(self):
        self.topNode = None

    def isEmpty(self):
        if not self.topNode:
            return True
        return False

    def push(self, data):
        newNode = Node(data)
        newNode.preNode = self.topNode
        self.topNode = newNode

    def pop(self):
        if self.isEmpty():
            return None

        tempNode = self.topNode.data
        self.topNode = self.topNode.preNode
        return tempNode

    def peek(self):
        if self.isEmpty():
            return None

        return self.topNode.data


#테스트 횟수 입력받음
T = int(input())

#테스트 횟수만큼 반복
for tc in range(1, T+1):

    #테스트케이스 입력받음, 각 문자 하나 하나를 리스트값으로 받음
    ps = list(map(str,input()))

    #스택 초기화
    s = Stack()

    #리스트 순회. x가 '('면 스택에 push, ')'면 pop
    for x in ps:
        if x == ')':

            #pop을 해야 하는데 스택이 비어있는경우
            if not s.pop():
                #스택에 push해서 빈스택 만들지 않고 break
                s.push(x)
                break
        else:
            s.push(x)

    #스택에 데이터가 남아있으면 NO, 없으면 YES 출력
    if s.isEmpty():
        print("YES")
    else:
        print("NO")