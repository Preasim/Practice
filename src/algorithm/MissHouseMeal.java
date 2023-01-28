package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class MissHouseMeal {
    public static void main(String[] args) {
        String[] sideDishes = {"eggroll", "kimchi", "fishSoup"};

        //search 함수에서 사용할 빈 스택을 선언
        Stack<String> stack = new Stack<>();

        //결과를 담을 ArrayList를 선언
        ArrayList<String[]> result = new ArrayList<>();

        // 재료들을 오름차순으로 정렬.
        Arrays.sort(sideDishes);

        // 빈 스택과 0 번째 인덱스, 정렬된 재료로 구성된 배열, 결과를 담을 List를 인자로 받는 재귀 함수를 실행
        result = search(stack, 0, sideDishes, result);

        //결과를 오름차순 순서로 정렬
        result.sort(Comparator.comparing(Arrays::toString));
        return result;
    }

    public ArrayList<String[]> search(Stack<String> stack, int idx, String[] sideDishes, ArrayList<String[]> result){
        // 탈출 조건
        if(idx >= sideDishes.length){
            // 만약, idx와 sideDishes의 길이가 같거나 크다면(마지막까지 검토한 경우) 스택을 배열로 변환한 후, 해당 스택을 result에 넣음.
            String[] arr = stack.toArray(new String[0]);
            result.add(arr);
            return result;
        } else {
            //idx가 부분집합에 포함된 경우
            stack.push(sideDishes[idx]);
            search(stack, idx+1, sideDishes, result);

            //idx가 부분집합에 포함되지 않은 경우
            stack.pop();
            search(stack, idx+1, sideDishes, result);
        }
        System.out.println(result);
        return result;
    }
}
