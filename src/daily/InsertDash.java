package daily;

import java.util.ArrayList;
import java.util.Arrays;

class InsertDash {
    public static void main(String[] args) {
        // 1. str 반복문으로 돌리기
        // 2. index i번째 값과 i+1값이 홀수일 경우
        // 3. 그 사이에 "-" 추가
        String str = "454793";
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str.split("")));
        for(int i=0; i<str.length();i++){
            int num = Integer.parseInt(list.get(i));
            int num2 = Integer.parseInt(list.get(i+1));
            if(num%2==1 && num2%2==1){
                list.add(i-1,"-");
            }
        }
        System.out.println(list);
    }
}
