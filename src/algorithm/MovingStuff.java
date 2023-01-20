package algorithm;

import java.util.Arrays;

class MovingStuff {
    public static void main(String[] args) {
        int[] stuff = {42, 25, 60, 73, 103, 167}; //[25, 42, 60, 73, 103, 167]
        int limit = 187;

        Arrays.sort(stuff);
        int light = 0;
        int heavy = stuff.length-1;
        int count = 0;

        while(light < heavy){
            if(stuff[light] + stuff[heavy] <= limit){
                light++;
                heavy--;
                count++;
                System.out.println("count : "+count);
            } else {
                heavy--;
            }
        }
        System.out.println(stuff.length - count);
    }
}
