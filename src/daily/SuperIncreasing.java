package daily;

class SuperIncreasing {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 13, 54};
        int count = arr.length-1;
        int plus = 0;
        boolean result = true;

        for(int i=arr.length-1; i>=0; i--){
            for(int j=0; j<count; j++){
                plus += arr[j];

                 if (arr[i] <= plus) {
                    result = false;
                }

            }
            count--;
            plus = 0;
        }
        System.out.println(result);
    }
}
