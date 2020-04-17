import time

class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
        self.pre = None

class DoubleLinkedList:
    def __init__(self):
        self.head = None

    def insert(self,data):
        if not self.head:
            self.head = Node(data)
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next = Node(data)
            temp.next.pre = temp
        return

    def update(self,data,idx):
        if not self.head:
            return None
        temp =self.head
        for i in range(idx):
            if not temp.next:
                print("인덱스 범위 초과")
                return None
            temp = temp.next
        temp.data = data

    def delete(self,idx):
        if not self.head:
            return None
        temp = self.head
        for i in range(idx):
            if not temp.next:
                print("인덱스 범위 초과")
                return None
            temp = temp.next
        temp.pre.next = temp.next
        temp.next.pre = temp.pre
        del temp

    def printList(self):
        if not self.head:
            return None
        temp = self.head
        print(temp.data, end=" ")
        while temp.next:
            temp = temp.next
            print(temp.data, end=" ")
        print()

L = DoubleLinkedList()

for i in range(1,11):
    L.insert(i)


L.printList()
L.delete(3)
L.printList()
L.update(99,6)
L.printList()

