package daily;

import java.util.Arrays;

public class ReadVertically {
    public static void main(String[] args) {
        String[] arr = {
                "hi",
                "wolrd"
        };

        String test = arr[0];
        String test2 = arr[1];
        String result = "";
        int count = 0;

        if(test.length() < test2.length()){
            count = test.length();
        } else {
            count = test2.length();
        }

        for(int i=0; i<count; i++){
                result += test.charAt(i);
                result += test2.charAt(i);

        }
        if(test.substring(count, test.length()).length() != 0){
            result += test.substring(count, test.length());
        } else {
            result += test2.substring(count, test2.length());
        }
        System.out.println(result);

    }
}
