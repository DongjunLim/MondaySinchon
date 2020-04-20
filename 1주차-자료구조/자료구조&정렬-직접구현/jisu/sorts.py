

# NlogN 쪼개고 합치면서 정렬함 (재귀로 구현)
def merge_sort(arr):
    def sort(low, high):
        # 더 이상 정렬할 것이 없을 경우 종료
        if high - low < 2:
            return
        # 입력 받은 l, h의 중간값으로 좌 우 재귀
        mid = (low + high) // 2
        sort(low, mid)
        sort(mid, high)
        # 재귀로 나뉘어지며 arr 자체를 합병 정렬
        merge(low, mid, high)

    def merge(low, mid, high):
        temp = []

        l, h = low, mid
        # low -> mid / mid -> high 리스트의 개별 원소를 비교하여 작을 경우 temp로 옮김 (이 때 한 리스트가 끝날 경우 중지)
        while l < mid and h < high:
            if arr[l] < arr[h]:
                temp.append(arr[l])
                l += 1
            else:
                temp.append(arr[h])
                h += 1
        # 남은 리스트의 값을 맨뒤에 추가함
        while l < mid:
            temp.append(arr[l])
            l += 1
        while h < high:
            temp.append(arr[h])
            h += 1
        # 리스트 갱신
        for i in range(low, high):
            arr[i] = temp[i-low]
      
    return sort(0, len(arr))

# NlogN pivot을 갱신하며 자리를 바꿔줌 (재귀로 구현)
def quick_sort(arr):
    def sort(low, high):
        if high <= low:
            return
        # 재귀로 나뉘어지며 arr 자체의 pivot을 찾으며 정렬
        pivot = partition(low, high)
        sort(low, pivot - 1)
        sort(pivot, high)

    def partition(low, high):
        # 입력받은 l,h의 중앙값을 pivot으로 함
        pivot = arr[(low + high) // 2]
        # l이 h에 도달할 때까지
        while low <= high:
            #  arr[low]가 pivot보다 작을 경우 (올바른 위치에 있는 경우) low를 반복해서 증가
            while arr[low] < pivot:
                low += 1
            #  arr[high]가 pivot보다 클 경우 (올바른 위치에 있는 경우) high을 반복해서 감소
            while arr[high] > pivot:
                high -= 1
            # 위 과정을 통해 pivot보다 클 경우에 low를, 작을 경우에 high를 각각 위치시킴

            # low 가 high보다 작거나 같을 때 값을 바꿔주고 다음 수에 해당 과정 반복
            if low <= high:
                arr[low], arr[high] = arr[high], arr[low]
                low, high = low + 1, high - 1
        # pivot == low == high
        return low

    return sort(0, len(arr) - 1)

# N^2 정렬 범위를 늘려가며 자리를 바꿔줌
def insertion_sort(arr):
    for end in range(1, len(arr)):
        i = end
        # 해당 범위 내에서 뒤에서부터 반복함
        while i > 0 and arr[i - 1] > arr[i]:
            arr[i - 1], arr[i] = arr[i], arr[i - 1]
            i -= 1
