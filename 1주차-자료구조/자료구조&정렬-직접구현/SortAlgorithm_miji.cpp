#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <iostream>

#define MAX_SIZE 60000   //데이터의 개수(60000개) 지정
#define SWAP(x,y,t) ((t)=(x), (x)=(y), (y)=(t))    //SWAP함수 설정
int original[MAX_SIZE];    //랜덤함수로 만든 데이터를 저장할 원본 배열
int list[MAX_SIZE];    //각 정렬 알고리즘에서 사용할 데이터 배열
int n; //데이터의 개수를 받는 전역변수 설정
int sorted[MAX_SIZE]; //합병정렬에서 사용할 데이터를 저장할 배열
clock_t start, finish, used_time = 0;    //실행 시간 측정을 위한 변수

using namespace std;

//합병정렬
void merge(int list[], int left, int mid, int right)
{
    int i, j, k, l;
    i = left, j = mid + 1; k = left;

    while (i <= mid && j <= right)
    {
        if (list[i] <= list[j]) //i가 j보다 작을 때
            sorted[k++] = list[i++]; //i에 해당하는 값을 대입
        else //i가 j보다 클 때
            sorted[k++] = list[j++]; //j에 해당하는 값을 대입
    }

    if (i > mid) //남아있는 값들을 일괄 복사(중간값 위)
        for (l = j; l <= right; l++)
            sorted[k++] = list[l];
    else //(중간값 아래)
        for (l = i; l <= right; l++)
            sorted[k++] = list[l];

    // 배열 sorted[](임시 배열)의 리스트를 배열 list[]로 재복사
    for (l = left; l <= right; l++)
        list[l] = sorted[l];
}

//각각 정렬된 배열들을 합침
void merge_sort(int list[], int left, int right)
{
    int mid;
    if (left < right)
    {
        mid = (left + right) / 2;
        merge_sort(list, left, mid); //왼쪽 부분 정렬
        merge_sort(list, mid + 1, right); //오른쪽 부분 정렬
        merge(list, left, mid, right); //합쳐서 정렬
    }
}

//퀵정렬
int partition(int list[], int left, int right)
{
    int pivot = list[left], tmp, low = left, high = right + 1;
    //두개의 포인터 low와 high가 서로 증가/감소하다가 엇갈릴때까지 반복함
    do {
        do
            low++;//low 인덱스 증가
        while (low <= right && list[low] < pivot);

        do
            high--; //high 인덱스 감소
        while (high >= left && list[high] > pivot);
        if (low < high) SWAP(list[low], list[high], tmp);//엇갈릴때 피봇과 j(high)값을 바꿔줌
    } while (low < high);

    SWAP(list[left], list[high], tmp);
    return high;
}


void quick_sort(int list[], int left, int right)
{
    if (left < right)
    {
        int q = partition(list, left, right);
        quick_sort(list, left, q - 1); //파티션으로 나뉜 왼쪽 부분을 원래 피봇을 제외하고 퀵 정렬함
        quick_sort(list, q + 1, right); //오른쪽 부분 퀵 정렬함
    }
}


//삽입 정렬
void insertion_sort(int list[], int n)
{
    int i, j, temp;
    cout << "삽입 정렬 중..." << endl;
    
    for (i = 1; i < n; i++)
    {
        temp = list[i];
        for (j = i - 1; j >= 0 && list[j] > temp; j--) //앞의 원소보단 크고, 뒤에 원소보단 작은 위치에 삽입
            list[j + 1] = list[j];
        list[j + 1] = temp;
    }
}

//원본 배열을 복사하는 함수
void CopyArr(void)
{
    int i;
    for (i = 0; i < n; i++)
        list[i] = original[i];
}

//실행 시간을 측정 및 출력하는 함수
void CalcTime(void)
{
    used_time = finish - start; //사용시간을 끝나는 시간-시작 시간으로 설정
    cout << "소요시간: " << (float)used_time / CLOCKS_PER_SEC << "sec" << endl; //초단위로 설정
}


int main()
{
    int i;

    n = MAX_SIZE;
    for (i = 0; i < n; i++) //랜덤 숫자 불러오기
        original[i] = rand();

    cout<<"데이터의 개수 :"<<n<<endl;

    //삽입정렬
    CopyArr();
    start = clock();
    insertion_sort(list, n);
    finish = clock();
    CalcTime();

    //합병정렬
    CopyArr();
    start = clock();
    cout << "합병 정렬 중..." << endl;
    merge_sort(list, 0, n);
    finish = clock();
    CalcTime();

    //퀵 정렬
    CopyArr();
    start = clock();
    cout << "퀵 정렬 중..." << endl;
    quick_sort(list, 0, n);
    finish = clock();
    CalcTime();
}
/* 결과 :

데이터의 개수 :60000
삽입 정렬 중...
소요시간: 1.655sec
합병 정렬 중...
소요시간: 0.01sec
퀵 정렬 중...
소요시간: 0.006sec
*/