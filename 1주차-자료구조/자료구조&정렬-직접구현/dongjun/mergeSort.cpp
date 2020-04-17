
/* ------------------------------------------------------------
 
 성능비교
 
 input: 100
 라이브러리: 0.005ms
 내가 짠 코드: 0.01ms

 input: 999
 라이브러리: 0.033ms
 내가 짠 코드: 0.116ms

 input: 10000
 라이브러리: 0.213ms
 내가 짠 코드: 1.156ms

 input: 100000
 라이브러리: 2.264ms
 내가 짠 코드: 14.177ms

 input: 1000000
 라이브러리: 19.635ms
 내가 짠 코드: 132.607ms
 
-------------------------------------------------------------*/

#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <string.h>
#include <time.h>
#define MAX 1000001
using namespace std;


//결합 알고리즘
int combine(char* arr, int start, int mid, int end){
    
    //임시저장 배열 선언
    char tempArr[MAX];
    
    //배열인덱스 위치를 저장할 변수 선언
    int i=start,j=mid, k=0;
    
    //mid를 기준으로 좌우배열은 무조건 정렬된 상태이다.
    //mid를 기준으로 왼쪽 부분배열과 오른쪽 부분배열을 합친다.
    //인덱스 순회가 좌우배열 중 한쪽만 끝나도 반복문 종료
    while(i < mid && j <= end){
        if(arr[i] < arr[j])
            tempArr[k++] = arr[i++];
        else
            tempArr[k++] = arr[j++];
    }
    
    //인덱스 순회가 덜 끝난 배열이 있으면 나머지를 임시배열에 채운다.
    while(i < mid) tempArr[k++] = arr[i++];
    while(j <= end) tempArr[k++] = arr[j++];
    
    //여기를 기점으로 임시배열에 정렬 완료.
    
    //정렬된 임시배열을 원래배열에 옮긴다.
    for(int i=0; i<=(end-start); i++){
        arr[start+i] = tempArr[i];
    }
    return 1;
}

//합병정렬 알고리즘
int mergeSort(char* arr,int left,int right){
    //왼족과 오른쪽이 같다는건 분할할게 없다는 의미므로 함수 종료
    if (left >= right)  return 1;
    
    //배열범위 분할을 위해 중간위치 인덱스 mid 변수 선언
    int mid = ((left + right)/2);
    
    //재귀호출로 정렬할 배열 범위 분할
    mergeSort(arr,left,mid);
    mergeSort(arr, mid+1, right);
    
    //분할한 배열 결합
    combine(arr,left,mid+1,right);
    
    return 1;
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
        mergeSort(mySortArr,left,right-1);
        end = clock();
        
        //측정한 시간 밀리세컨드로 변환
        mySortTime = (double)(end-start)/1000;
        
        //결과 출력
        cout << "input: " << right << endl;
        cout << "라이브러리: " << libSortTime << "ms" << endl;
        cout << "내가 짠 코드: " << mySortTime << "ms" << endl << endl;

    }


    return 0;
}

