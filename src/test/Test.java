package test;

import java.util.ArrayList;
import java.util.Arrays;


class Test {
    public static void main(String[] args) {
        // 순열 요소가 인자로 주어질 경우, 인자 그대로 사용하면 되지만, 인자가 주어지지 않고
        // 문제 안에 포함되어 있을 경우 이런 식으로 직접 적어서 사용합니다.
        String[] lookup = new String[]{"A", "B", "C", "D", "E"};
        ArrayList<String[]> result = new ArrayList<>();

        for (int i = 0; i < lookup.length; i++) {
            for (int j = 0; j < lookup.length; j++) {
                for (int k = 0; k < lookup.length; k++) {
                    if (i == j || j == k || k == i) continue;
                    String[] input = new String[]{lookup[i], lookup[j], lookup[k]};
                    result.add(input);
                }
            }
        }
        System.out.println(Arrays.deepToString(result.toArray()));
    }
}
