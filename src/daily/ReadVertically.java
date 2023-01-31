package daily;

import java.io.IOException;
import java.util.Arrays;

public class ReadVertically {
    public static void main(String[] args) throws IOException {
        String[] arrs = {
                "hello",
                "wolrd",
        };
        String str = new String(Arrays.toString(arrs));
        System.out.println(str);


//        for(int i=0; i<arrs.length; i++){
//            String[] test = new String[]{arrs[i]};
//            System.out.println(Arrays.toString(test));
//        }




//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        char[][] arr = new char[5][15];
//        for (int i = 0; i < 5; i++) {
//            String temp = br.readLine();
//            for (int j = 0; j < temp.length(); j++) {
//                arr[i][j]=temp.charAt(j);
//            }
//            for (int j = temp.length(); j < 15; j++) {
//                arr[i][j]=' ';
//            }
//        }
//
//        for (int i = 0; i < 15; i++) {
//            for (int j = 0; j < 5; j++) {
//                if(arr[j][i]!=' ') {
//                    sb.append(arr[j][i]);
//                }
//            }
//        }
//        System.out.println(sb);
    }
}
