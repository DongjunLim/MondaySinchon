/**
 *  @��������
 *  ��ũ���ؽø��� ����� Ǯ�����ϴ�.
 *  ���ڿ��� ������ ���� �ֳʱ׷��� ��� ��� ���� ���ڿ��� �����
 *  ���ĵ� ���ڿ��� Ű�� �ϴ� ��ũ���ؽøʿ� ������ �߰��մϴ�.
 *
 *  ��ǲ�����Ϳ� ���� �� �۾��� ��� �Ϸ�Ǹ� �ؽø��� ��ȸ�ϸ�
 *  answer ����Ʈ�� ���ʷ� ��Ƽ� ��ȯ�մϴ�.
 *
 *  @����
 *  Runtime: 7 ms
 *  Memory Usage: 42.4 MB
 *  �ð����⵵: O( s * logs * N )  * s = ���ڿ��� ����, N = �Է¹迭�� ũ��
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
