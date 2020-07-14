"""
    연산자 우선순위
    1. *, /
    2. +, -
    3. (, )
    피연산자는 바로 정답문자열에 추가하고, 연산자는 연산자 우선순위에 따라,
    자신보다 같거나 높은 연산자는 연산자스택에서 pop하여 정답문자열에 넣은 후,
    연산자 스택에 push합니다.
    여는 괄호는 조건에 상관없이 무조건 연산자 스택에 push하고, 닫는 괄호의 경우
    연산자 스택에서 여는 괄호가 나올때까지 pop연산을 합니다.
    문자열을 다 순회한 후에는 연산자 스택에 남아 있는 데이터를 모두 정답 문자열에 붙입니다.
"""


import sys
from collections import deque

sys.stdin = open("input.txt", "r")


def close_bracket(opStack):
    """ 닫는 괄호를 만났을때 로직. """
    string = ''

    while opStack:
        peek = opStack.pop()
        if peek is '(':
            break
        string += peek

    return string


def push_mul_and_div(opStack, character):
    """ 곱셈과 나눗셈의 연산. """
    string = ''

    while opStack:
        peek = opStack[-1]
        if peek != '/' and peek != '*':
            break
        string += opStack.pop()
    opStack.append(character)

    return string


def push_default_ops(opStack, character):
    """ +, - 연산자의 경우. """
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

