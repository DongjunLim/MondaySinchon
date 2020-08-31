import java.util.*;
//https://leetcode.com/problems/first-missing-positive/

class Solution2 {
    public int firstMissingPositive(int[] nums) {
        //Arrays.sort(nums); //0,1,2
        //3,4,-1,1
        if(nums.length == 0){ //배열이 없을 때
            return 1;
        
        }
        
        for(int i=0; i<nums.length; i++){ //i==1
            while(nums[i]>0 && nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){ 
                swap(nums , i , nums[i]-1);
            }
            
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i+1){ 
                return i+1; 
            }
        }
         return nums[nums.length-1]+1;  
        
    }
   public void swap(int arr[], int a, int b){
    int temp=arr[a];
    arr[a] = arr[b];
    arr[b]=temp;
    }
}
