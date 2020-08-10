/*
-해시맵 이용해서 키:정렬한 문자열, 값: 원래 문자열로 값을 추가해 리턴함
-res에 하나씩 대입해서 리턴
-12ms
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
         HashMap<String, List<String>> map = new HashMap<String, List<String>>(); 
		List<List<String>> res = new ArrayList<>();
        
        if(strs.length==0 || strs==null) {
            return res;
        }
        
        Arrays.sort(strs);
        
        
        
		for(String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch); //알파벳 순서로 정렬
			
			String s = String.valueOf(ch);
            
			if(map.containsKey(s)) { //맵이 정렬된 문자열 s를 키값으로 가지고 있다면
				map.get(s).add(str); //원래 문자열(정렬되기 전) 값을  추가함
			}else { //그 외 경우 새로운 리스트 생성, 맵에 추가
				List<String> temp = new ArrayList<String>();
				temp.add(str);
				map.put(s,temp); 
			}
			
		}
		
		for(List<String> value: map.values()) {
			res.add(value); //res에 답 추가
		}
		
		return res;
        
    }
}
