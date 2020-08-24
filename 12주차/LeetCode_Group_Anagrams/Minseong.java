package Algorithm.MondaySinchon.LeetGroupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    static HashMap<String, List> map;

    static int count[];

    public List<List<String>> groupAnagrams(String[] strs) {

        map = new HashMap<>();

        count = new int[26];

        for (String s : strs){
            Arrays.fill(count, 0);

            for (char c : s.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder stringBuilder = new StringBuilder("");

            for (int i = 0; i < 26; i++){
                stringBuilder.append('#');
                stringBuilder.append(count[i]);
            }

            String key  = stringBuilder.toString();

            if (!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}