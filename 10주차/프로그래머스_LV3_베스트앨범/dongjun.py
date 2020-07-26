"""
    해시로 풀었습니다.
"""

import operator


def solve(genres, plays):
    musics = dict()
    total = dict()
    answer = []
    for i in range(len(plays)):
        if genres[i] not in musics.keys():
            musics[genres[i]] = []
            total[genres[i]] = 0

        musics[genres[i]].append([plays[i], i])
        total[genres[i]] += plays[i]

    for x in musics:
        musics[x].sort(reverse=True)

    total = sorted(total.items(), key= operator.itemgetter(1), reverse=True)

    for genre, sm in total:
        cnt = 0
        for i, x in enumerate(musics[genre]):
            if cnt == 2:
                break
            temp = x
            for j in range(i+1, len(musics[genre])):
                temp2 = musics[genre][j]
                if temp[0] > temp2[0]:
                    break
                if temp[0] == temp2[0]:
                    musics[genre][j], musics[genre][i] = musics[genre][i], musics[genre][j]
                    temp = temp2
            answer.append(temp[1])
            cnt += 1

    return answer


def main():
    genres = ["classic", "pop", "classic", "classic"]
    plays = [800, 600, 0, 800]

    print(solve(genres, plays))


if __name__ == "__main__":
    main()
