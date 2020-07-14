"""
    ������ �켱����
    1. *, /
    2. +, -
    3. (, )
    �ǿ����ڴ� �ٷ� ���乮�ڿ��� �߰��ϰ�, �����ڴ� ������ �켱������ ����,
    �ڽź��� ���ų� ���� �����ڴ� �����ڽ��ÿ��� pop�Ͽ� ���乮�ڿ��� ���� ��,
    ������ ���ÿ� push�մϴ�.
    ���� ��ȣ�� ���ǿ� ������� ������ ������ ���ÿ� push�ϰ�, �ݴ� ��ȣ�� ���
    ������ ���ÿ��� ���� ��ȣ�� ���ö����� pop������ �մϴ�.
    ���ڿ��� �� ��ȸ�� �Ŀ��� ������ ���ÿ� ���� �ִ� �����͸� ��� ���� ���ڿ��� ���Դϴ�.
"""


import sys
from collections import deque

sys.stdin = open("input.txt", "r")


def close_bracket(opStack):
    """ �ݴ� ��ȣ�� �������� ����. """
    string = ''

    while opStack:
        peek = opStack.pop()
        if peek is '(':
            break
        string += peek

    return string


def push_mul_and_div(opStack, character):
    """ ������ �������� ����. """
    string = ''

    while opStack:
        peek = opStack[-1]
        if peek != '/' and peek != '*':
            break
        string += opStack.pop()
    opStack.append(character)

    return string


def push_default_ops(opStack, character):
    """ +, - �������� ���. """
    string = ''

    while opStack:
        peek = opStack[-1]
        if peek == '(':
            break
        opStack.pop()
        string += peek

    opStack.append(character)

    return string


def solution(s):
    ops = ['*', '+', '-', '/', '(', ')']
    opStack = deque()
    answer = ""

    for char in s:
        if char not in ops:
            answer += char

        elif char == '*' or char == '/':
            answer += push_mul_and_div(opStack, char)

        elif char == '(':
            opStack.append(char)

        elif char == ')':
            answer += close_bracket(opStack)

        else:
            answer += push_default_ops(opStack, char)

    while opStack:
        answer += opStack.pop()

    return answer


def main():
    s = input()

    print(solution(s))

    return


if __name__ == '__main__':
    main()

