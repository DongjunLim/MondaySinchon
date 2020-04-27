import sys

# 비밀번호에 모음 1개, 자음 2개인지 확인하기 위한 모음배열
consonant = ['a','e','u','i','o']

answer = []

# 비밀번호 길이 L과 후보알파벳 갯수 C를 입력받음
L ,C = map(int, input().split())

# 후보알파벳 문자를 배열로 입력받음
arr = list(map(str, input().split()))

# 정답을 오름차순으로 정렬해야 하기 때문에 후보 알파벳을 정렬해 놓는다.
arr.sort()

# 백트래킹 함수, idx = 비밀번호 입력 갯수, string = 만들고 있는 비밀번호 문자열
def find(idx, string):
    global L
    global answer
    global arr
    global last

    # 비밀번호를 다 만들었으면 비밀번호 조건에 해당하는지 확인하고 해당하면 정답배열에 push하고 리턴
    if idx == L:
        if checkCondition(string):
            answer.append(string)
        return
    lastIdx = last+idx
    # 오름차순으로 정렬된 arr배열을 idx 번부터 끝까지 순회
    for x in arr[idx:lastIdx]:
        # 오름차순으로 만들기 위해 만들고 있는 비밀번호의 가장 끝자리보다 입력값이 큰지 확인한다.
        if string[-1] < x:
            string += x
            find(idx + 1, string)
            string = string[:-1]
    return

# 비밀번호 조건에 부합하는지 확인하는 함수
def checkCondition(string):
    global consonant
    isConsonant = False
    isVowel = 0

    for i,x in enumerate(string):
        if x in consonant:
            isConsonant = True
        else:
            isVowel += 1

    if isConsonant and isVowel > 1:
        return True
    return False

# 비밀번호를 만들때 사용할 문자열 변수
string = ''
last = C-L+1
# 첫 문자는 for문으로 입력하고 그 이후부터 find 내에서 추가한다.
for x in arr[:last]:
    string += x
    find(1,string)
    string = string[:-1]

# 결과 출력
for i in answer:
    print(i)
