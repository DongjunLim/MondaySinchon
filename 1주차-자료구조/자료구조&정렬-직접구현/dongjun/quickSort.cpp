#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <string.h>
#include <time.h>
#define MAX 1000001
using namespace std;


int quickSort(char* arr,int left,int right){
    
    //왼쪽 인덱스가 오른쪽 인덱스보다 크거나 같으면 탈출
    if(left >= right)
        return 1;
    
    //기준점 피봇값 설정
    int pivot = arr[right];
    
    //왼쪽, 오른쪽 인덱스 최초 설정
    int i = left;
    int j = right;
    
    char temp;
    
    //피봇값을 기준으로 정렬수행
    do{
        //왼쪽에서 오른쪽으로 이동하며 피봇값보다 큰 값을 찾음
        while(arr[i] < pivot)  i++;
        //오른쪽에서 왼쪽으로 이동하며 피봇값보다 큰 값을 찾음
        while(arr[j] > pivot)  j--;
        
        //왼쪽 인덱스가 오른쪽 인덱스보다 커지지 않은 상태면 값을 서로 바꿈
        if(i <= j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
     //i가 j보다 커지면 반복문 종료
    }while(i <= j);
    
    //반복문 종료 시점에서 i는 j보다 크다.
    //j를 포함하여 j보다 낮은 인덱스들의 값은 피봇값보다 작다. (분할성공)
    //i를 포함하여 i보다 높은 인덱스들의 값은 피보값보다 크다. (분할성공)
    
    //분할한 구간에서 다시 퀵정렬을 수행한다.
    return quickSort(arr, left, j) + quickSort(arr, i, right);
}


int main(int argv, char* argc[]){
    //테스트케이스 갯수를 받을 변수
    int T;
    
    //배열의 시작위치와 끝위치를 담는 변수
    int left, right;
    
    //시간측정을 위한 변수
    double libSortTime, mySortTime;
    clock_t start, end;
    
    //input data를 파일에서 읽어옴
    freopen("input.txt", "r", stdin);
    cin >> T;
    
    for(int tc=1; tc<=T; tc++){
        
        //입력을 담을 변수, 정렬 성능 비교를 위해 입력데이터를 복사해서 테스트할 두개의 변수 선언
        char input[MAX], mySortArr[MAX], libSortArr[MAX];
        
        cin >> input;
        
        //받은 입력데이터를 두 문자열 배열에 복사
        strcpy(mySortArr,input);
        strcpy(libSortArr, input);
        
        //시작, 끝위치 설정
        left = 0;
        right = int(strlen(input));
        
        
        //라이브러리 정렬함수 호출, 정렬알고리즘 앞뒤로 시간측정
        start = clock();
        sort(libSortArr,libSortArr+right);
        end = clock();
        
        //측정한 시간 밀리세컨드로 변환
        libSortTime = (double)(end-start)/1000;
        
        //직접짠 정렬함수 호출, 정렬알고리즘 앞뒤로 시간측정
        start = clock();
        quickSort(mySortArr,left,right);
        end = clock();
        
        //측정한 시간 밀리세컨드로 변환
        mySortTime = (double)(end-start)/1000;
        
        //결과 출력
        cout << "input: " << right << endl;
        cout << "라이브러리: " << libSortTime << "ms" << endl;
        cout << "내가 짠 코드: " << mySortTime << "ms" << endl << endl;
    }
    /*
     
     성능비교
     
     input: 100
     라이브러리: 0.004ms
     내가 짠 코드: 0.005ms

     input: 999
     라이브러리: 0.02ms
     내가 짠 코드: 0.05ms

     input: 10000
     라이브러리: 0.202ms
     내가 짠 코드: 0.551ms

     input: 100000
     라이브러리: 1.913ms
     내가 짠 코드: 5.783ms

     input: 1000000
     라이브러리: 19.626ms
     내가 짠 코드: 63.881ms
     
     */

    return 0;
}

