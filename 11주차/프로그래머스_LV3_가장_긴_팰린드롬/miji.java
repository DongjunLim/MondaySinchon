class Solution
{
    public int solution(String s)
    {
        //int answer = 0;
        char[] ch = s.toCharArray();
		
		//가장 긴 문자열부터 검사
		for(int len = s.length(); len > 1; len--) {
			//시작 인덱스
			for(int first = 0; first + len <= s.length(); first++) {
				boolean check = true;
				
				//처음~문자열 길이의 반만큼 문자들을 비교
				for(int i=0; i<len/2; i++) {
					if(ch[first+i] != ch[first+len-i-1]) {
						check = false;
						break;
					}
				}
				if(check) {
					return len;
				}
			}
		}
        
        
        System.out.println("Hello Java");
        return 1;
    }
}
