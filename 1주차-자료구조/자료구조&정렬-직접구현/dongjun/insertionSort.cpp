
/* ------------------------------------------------------------
 
 성능비교: 삽입정렬
 
 input: 100
 라이브러리: 0.004ms
 내가 짠 코드: 0.011ms

 input: 999
 라이브러리: 0.019ms
 내가 짠 코드: 0.859ms

 input: 10000
 라이브러리: 0.204ms
 내가 짠 코드: 83.761ms

 input: 100000
 라이브러리: 1.963ms
 내가 짠 코드: 8196.29ms

 input: 1000000
 라이브러리: 19.432ms
 내가 짠 코드: 804023ms
 
 ---------------------------------------------------------------------
 
 성능비교: 선택정렬
 
 input: 100
 라이브러리: 0.005ms
 내가 짠 코드: 0.008ms

 input: 999
 라이브러리: 0.04ms
 내가 짠 코드: 0.886ms

 input: 10000
 라이브러리: 0.201ms
 내가 짠 코드: 79.852ms

 input: 100000
 라이브러리: 1.923ms
 내가 짠 코드: 7456.89ms

 input: 1000000
 라이브러리: 19.791ms
 내가 짠 코드: 759686ms
 
-------------------------------------------------------------*/

#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <string.h>
#include <time.h>
#define MAX 1000001
using namespace std;



//선택정렬
int selectionSort(char* arr,int length){
    
    int i=0;
    int minIdx = i;
    char minVal, temp;
    while(i < length){
        minIdx = i;
        minVal = arr[i];
        for(int j=i+1; j < length; j++){
            if(arr[j] < minVal){
                minVal = arr[j];
                minIdx = j;
            }
        }
        temp = arr[i];
        arr[i++] = arr[minIdx];
        arr[minIdx] = temp;
    }
    return 1;
}

//삽입정렬
int insertionSort(char* arr, int length){
    int j,k;
    char temp;
    for(int i=1; i < length; i++){
        j = i-1;
        
        //arr[i]가 들어가야 할 자리를 찾는 반복문
        while(j > -1){
            if(arr[i] > arr[j]){
                break;
            }
            j--;
        }
        
        //이동이 없으면 스킵
        if(i != 1 && j == i-1)  continue;
        
        k = i;
        
        //삽입을 위해 j+2부터 i사이의 값을 한칸씩 민다.
        temp = arr[i];
        while(k > j+1){
            arr[k] = arr[k-1];
            k--;
        }
        //j+1 인덱스에 arr[i] 삽입
        arr[j+1] = temp;
    }
    return 1;
}


int main(int argv, char* argc[]){
    //테스트케이스 갯수를 받을 변수
    int T;
    
    //배열의 시작위치와 끝위치를 담는 변수
    int right;
    
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
        
        //끝위치 설정
        right = int(strlen(input));
        
        
        //라이브러리 정렬함수 호출, 정렬알고리즘 앞뒤로 시간측정
        start = clock();
        sort(libSortArr,libSortArr+right);
        end = clock();
        
        //측정한 시간 밀리세컨드로 변환
        libSortTime = (double)(end-start)/1000;
        
        //직접짠 정렬함수 호출, 정렬알고리즘 앞뒤로 시간측정
        start = clock();
        insertionSort(mySortArr,right);
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

