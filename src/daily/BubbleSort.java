package daily;

import java.util.Arrays;

class BubbleSort {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] output = solution.createBubble(new int[]{2, 1, 5, 3, 2, 15, 21, 3});
    }
}

class Solution {
    public int[] createBubble(int[] arr){
        boolean swap = false;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }

            if(swap == false) break;
        }
        System.out.println(Arrays.toString(arr));

        return arr;
    }

}
