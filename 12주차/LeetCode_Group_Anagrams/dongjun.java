/**
 *  @문제접근
 *  링크드해시맵을 사용해 풀었습니다.
 *  문자열을 정렬해 같은 애너그램일 경우 모두 같은 문자열로 만들고
 *  정렬된 문자열을 키로 하는 링크드해시맵에 값으로 추가합니다.
 *
 *  인풋데이터에 대해 위 작업이 모두 완료되면 해시맵을 순회하며
 *  answer 리스트에 차례로 담아서 반환합니다.
 *
 *  @성능
 *  Runtime: 7 ms
 *  Memory Usage: 42.4 MB
 *  시간복잡도: O( s * logs * N )  * s = 문자열의 길이, N = 입력배열의 크기
 */

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        List<List<String>> answer = new ArrayList<>();

        for(String nowString: strs){
            char[] chr = nowString.toCharArray();
            Arrays.sort(chr);
            String sortedString = String.valueOf(chr);

            if(!map.containsKey(sortedString)){
                List<String> set = new ArrayList<>();
                set.add(nowString);
                map.put(sortedString, set);
            }
            else{
                map.get(sortedString).add(nowString);
            }
        }

        map.forEach((key, value) -> {
            answer.add(value);
        });

        return answer;
    }
}
