//https://leetcode.com/problems/candy/submissions/

class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int ans = ratings.length;
        
        for(int i=1; i<ratings.length; i++){
            //if(candies[0] != null) ans = 1;
            if(ratings[i]> ratings[i-1]){ //현재 값이 왼쪽 값보다 더 많을 때
                candies[i]= candies[i-1]+1;
                ans += candies[i];
            }
            // else if(candies[i+1]> candies[i]){  //out of bands error 발생
            //     ans += candies[i+1]-candies[i] + 1;
            // }
        }
        
        for(int i = ratings.length-2; i>=0; i--){
            if(ratings[i]>ratings[i+1] && candies[i] <= candies[i+1]){  
                //조건 하나 더 필요, 현재 값이 다음 값(오른쪽)보다 더 클 때
                ans += candies[i+1]-candies[i] + 1;
                candies[i] = candies[i+1]+1; 
                
             }
        }
        return ans;
    }
}