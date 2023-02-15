package daily;


import java.util.Arrays;

class LargestProductOfThree {
    public static void main(String[] args) {

        int[] arr = {-1, 2, -5, 7};
        Arrays.sort(arr);

        int positive = arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];
        int negative = arr[arr.length-1]*arr[0]*arr[1];
        System.out.println(Math.max(positive, negative));
    }
}
