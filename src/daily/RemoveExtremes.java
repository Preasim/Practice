package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class RemoveExtremes {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "def"};
        List<String> result = new ArrayList<>(Arrays.asList(arr));
        String max = "";
        String min = "";
        int test = arr[0].length();

        for(String s : arr){
            if(s.length() > max.length()){
                max = s;
            }
            if(s.length() <= test){
                min = s;
            }
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] == min){
                result.remove(2);
            }
            if(arr[i] == max){
                result.remove(3);
            }
        }
        System.out.println(result);
    }
}

//public class Solution {
//    public String[] removeExtremes(String[] arr) {
//        //입력된 문자열이 공백일때 null을 리턴합니다.
//        if(arr.length == 0) {
//            return null;
//        }
//        //최대 길이는 20, 최소 길이는 0으로 기본값을 설정합니다.
//        //가장 작은 인덱스와 가장 긴 문자열의 인덱스를 찾기위해 0으로 기본값을 설정합니다.
//        int shortestLen = 20;
//        int longestLen = 0;
//        int shortestIdx = 0;
//        int longestIdx = 0;
//
//        //배열의 길이만큼 순회합니다.
//        for (int i = 0; i < arr.length; i++) {
//            //해당 요소(문자열)이 longestLen보다 클때
//            if (arr[i].length() >= longestLen) {
//                //longestLen에 현재 문자열의 길이를 넣어주고, longestIdx에 현재 인덱스를 넣어줍니다.
//                longestLen = arr[i].length();
//                longestIdx = i;
//            }
//            //같은 방식으로 최소 문자열과 인덱스를 찾아 대입합니다.
//            if (arr[i].length() <= shortestLen) {
//                shortestLen = arr[i].length();
//                shortestIdx = i;
//            }
//        }
//        //결과를 넣어줄 새로운 배열을 선언합니다. 최소 문자열과 최대 문자열을 제외하기 떄문에 -2만큼의 배열을 선언합니다.
//        String[] result = new String[arr.length - 2];
//        int curIndex = 0;
//        //배열을 순회하며 결과를 넣어준 후
//        for (int i = 0; i < arr.length; i++) {
//            if (i != shortestIdx && i != longestIdx) {
//                result[curIndex] = arr[i];
//                curIndex++;
//            }
//        }
//        //결과를 리턴합니다.
//        return result;
//    }
//}