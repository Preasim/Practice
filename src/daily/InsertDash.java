package daily;

import java.util.ArrayList;
import java.util.Arrays;

class InsertDash {
    public static void main(String[] args) {
        // 1. str 반복문으로 돌리기
        // 2. index i번째 값과 i+1값이 홀수일 경우
        // 3. 그 사이에 "-" 추가
        String str = "454793";

//        if(str.length() == 0) {
//            return null;
//        }
        String result = "" + str.charAt(0);

        for(int i = 1; i < str.length(); i++) {
            int preNumber = Character.getNumericValue(str.charAt(i - 1)) % 2;
            int curNumber = Character.getNumericValue(str.charAt(i)) % 2;
            if(preNumber != 0 && curNumber != 0) {
                result = result + "-";
            }
            result = result + str.charAt(i);
        }
        System.out.println(result);
    }
}
