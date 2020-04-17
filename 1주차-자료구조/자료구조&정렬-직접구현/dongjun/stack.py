import time

class Node:
    def __init__(self,data):
        self.data = data
        self.preNode = None

class LinkedStack:
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

s = LinkedStack()

start = time.time()
for i in range(1,11):
    s.push(i)

while not s.isEmpty():
    print(s.pop(),end=" ")

print()
ms = (time.time()-start) * 1000
print(f'{round(ms,2)}ms')