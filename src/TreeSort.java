import java.util.*;

class TreeSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random r = new Random();
        for(int i = 0; i<arr.length; i++) {
            arr[i] = r.nextInt(89)+10;
        }

        Test test = new Test();

        System.out.println(Arrays.toString(arr));
        arr = test.treeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Test {
    private int[] addToArray(int[] arr, int el) {
        int[] newArr = Arrays.copyOf(arr, arr.length+1);
        newArr[newArr.length-1] = el;
        return newArr;
    }

    public int[] treeSort(int[] arr) {
        // 더 이상 쪼개지지 않을 때
        // 탈출 조건 - 빈 배열인 경우 탈출
        if(arr.length == 0) return new int[]{};
        if(arr.length == 1) return arr;

        // 더 쪼개질 때
        // 중앙(사라짐), 왼쪽, 오른쪽으로 구분

        int len = arr.length;
        int middleOfOrgArr = len/2;      // 짝수인 경우에는 오른쪽 기준
        int[] center = Arrays.copyOfRange(arr, middleOfOrgArr, middleOfOrgArr+1);   // 중앙 1개
        int[] left = new int[len-1];    // 중앙이 빠진 나머지만큼 선언
        int[] right = new int[len-1];    // 중앙이 빠진 나머지만큼 선언

        // 배열 크기 계산을 위해 왼쪽 / 오른쪽 카운트 각각 설정
        int leftCount = 0;
        int rightCount = 0;

        // 순회하면서 왼쪽/오른쪽 구분
        for(int i = 0; i<arr.length; i++ ) {
            if (i == middleOfOrgArr) continue;
            if (arr[i] < center[0]) left[leftCount++] = arr[i];
            else                    right[rightCount++] = arr[i];
        }

        int[] head = treeSort(Arrays.copyOf(left, leftCount));
        int[] tail = treeSort(Arrays.copyOf(right, rightCount));

        int[] dest = new int[head.length + tail.length + center.length];

        // 최종 배열에 왼쪽(head), 중앙, 오른쪽(tail) 합치기
        System.arraycopy(head, 0, dest, 0, head.length);
        System.arraycopy(center, 0, dest, head.length, center.length);
        System.arraycopy(tail, 0, dest, head.length+center.length, tail.length);

        return dest;
    }
}