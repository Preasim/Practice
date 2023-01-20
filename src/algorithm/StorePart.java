package algorithm;

class StorePart {
    public static void main(String[] args) {
        int k = 49272;
        int count =0;
        int[] changes = {500,100,50,10,1};
        for(int i=0; i<changes.length;i++){
            if(k>0){
                int a = k/changes[i];
                int b = k%changes[i];
                k = b;
                count += a;
            }
        }
        System.out.println(count);
    }
}
