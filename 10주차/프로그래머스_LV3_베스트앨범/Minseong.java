package Algorithm.MondaySinchon.ProgrammersBestAlbum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

//우선순위 : 인기장르중 재생 횟수 순서대로이고 같은 횟수일땐 고유번호가 낮은 노래를 우선
class Solution {

    static ArrayList<songOrder> songOrderArrayList;
    static ArrayList<Integer> bestArrayList;

    static HashMap<String, Integer> genreMap;
    static HashMap<String, Integer> bestMap;


    class songOrder implements Comparable<songOrder>{

        int playCount, id;
        String genre;

        songOrder(int playCount, int id, String genre) {
            this.playCount = playCount;
            this.id = id;
            this.genre = genre;
        }

        @Override
        public int compareTo(songOrder o) {
            //재생횟수가 같을때, 고유번호비교하여 순서를 정함
            if (this.playCount == o.playCount){
                return this.id - o.id;
            }
            else {
                //다를경우, 재생횟수를 비교하여 순서를 정함
                return -(this.playCount - o.playCount);
            }
        }
    }
    //해시맵을 쓰는 방법
    public int[] solution(String[] genres, int[] plays) {
      //일단 arraylist를 만들고
      //해시안에 장르를 키, 재생횟수를 밸류로 넣어준다
      //같은장르가 있을땐 재생횟수를 더해준다

        songOrderArrayList = new ArrayList<>();
        bestArrayList = new ArrayList<>();
        genreMap = new HashMap<>();
        bestMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++){
            int playCount = plays[i];
            int id = i;
            String genre = genres[i];

            songOrderArrayList.add(new songOrder(playCount, id, genre));

            if (!genreMap.containsKey(genre)){
                genreMap.put(genre, playCount);
            }
            else {
                genreMap.put(genre, genreMap.get(genre) + playCount);
            }
        }
        Collections.sort(songOrderArrayList, new Comparator<songOrder>() {
            @Override
            public int compare(songOrder o1, songOrder o2) {
                //장르가 같을때, songOrder의 compareTo 메서드로 들어가 순서를 정함
                if (o1.genre.equals(o2.genre)){
                    return o1.compareTo(o2);
                }
                else {
                    //다를때 장르맵의 밸류값으로 순서를 정함
                    return -(genreMap.get(o1.genre) - genreMap.get(o2.genre));
                }
            }
        });


        for (songOrder songOrder : songOrderArrayList){

            if (!bestMap.containsKey(songOrder.genre)){
                bestMap.put(songOrder.genre, 1);
                bestArrayList.add(songOrder.id);
            }
            else {
                int genreCount = bestMap.get(songOrder.genre);
                if (genreCount >= 2){
                    continue;
                }
                else {
                    bestMap.put(songOrder.genre, genreCount + 1);
                    bestArrayList.add(songOrder.id);
                }

            }
        }






        int[] answer = new int[bestArrayList.size()];
        for (int i = 0; i < answer.length; i++){
            answer[i] = bestArrayList.get(i);
        }
        return answer;
    }
}