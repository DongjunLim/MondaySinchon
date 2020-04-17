import time
import sys

class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
        self.pre = None

class LinkedQueue:
    def __init__(self):
        self.front = None
        self.rear = None

    def isEmpty(self):
        return True if not self.front else False

    def enQueue(self,data):
        newNode = Node(data)
        if self.front:
            newNode.pre = self.rear
        else:
            self.front = newNode
        if self.rear:
            self.rear.next = newNode
        self.rear = newNode

    def deQueue(self):
        if self.isEmpty():
            return None

        returnData = self.front.data
        temp = self.front
        self.front = self.front.next
        del temp
        return returnData


Q = LinkedQueue()

start = time.time()
for i in range(10):
    Q.enQueue(i)

while not Q.isEmpty():
    print(Q.deQueue(),end= " ")
print()
ms = (time.time() - start)*1000
print(f'{round(ms,2)}ms')