package daily;

import java.util.Arrays;

public class ReadVertically {
    public static void main(String[] args) {
        String[] arrs = {
                "hii",
                "wolrd"
        };
        String test = arrs[0];
        String test2 = arrs[1];
        String arr = "";


        for(int i=0; i<test.length(); i++){
                arr += test.charAt(i);
                arr += test2.charAt(i);

        }
        System.out.println(arr);

    }
}
