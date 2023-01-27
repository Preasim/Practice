package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class RemoveExtremes {
    public static void main(String[] args) {
        String[] arr = {"where", "is", "the", "longest", "word"};
        int shortestLen = 20;
        int longestLen = 0;
        int shortestIdx = 0;
        int longestIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() >= longestLen) {
                longestLen = arr[i].length();
                longestIdx = i;
            }
            if (arr[i].length() <= shortestLen) {
                shortestLen = arr[i].length();
                shortestIdx = i;
            }
        }
        String[] result = new String[arr.length - 2];
        int curIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != shortestIdx && i != longestIdx) {
                result[curIndex] = arr[i];
                curIndex++;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}