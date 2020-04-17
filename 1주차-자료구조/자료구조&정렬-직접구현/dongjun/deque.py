import time
import sys

class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
        self.pre = None

class LinkedDeque:
    def __init__(self):
        self.front = None
        self.rear = None

    def isEmpty(self):
        return True if not self.front or not self.rear else False

    def pushBack(self,data):
        newNode = Node(data)
        if not self.isEmpty():
            newNode.pre = self.rear
        else:
            self.front = newNode
        if self.rear:
            self.rear.next = newNode
        self.rear = newNode

    def pushFront(self,data):
        newNode = Node(data)
        if not self.isEmpty():
            newNode.next = self.front
            self.front.pre = newNode
        else:
            self.rear = newNode
        self.front = newNode

    def popBack(self):
        if self.isEmpty():
            return None
        returnData = self.rear.data
        temp = self.rear

        self.rear = self.rear.pre
        del temp
        return returnData

    def popFront(self):
        if self.isEmpty():
            return None

        returnData = self.front.data
        temp = self.front
        self.front = self.front.next
        del temp
        return returnData

Q = LinkedDeque()

start = time.time()
for i in range(10):
    Q.pushFront(i)

while not Q.isEmpty():
    print(Q.popBack(),end=" ")
print()
ms = (time.time() - start)*1000
print(f'{round(ms,2)}ms')