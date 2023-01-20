package print;

import java.util.*;
import java.util.stream.Collectors;

class Ex01 {

    /**
     * 여러가지로 자유 테스트를 해보시려면
     * 이 아래 final static int 상수만 고치면 됩니다 !
     */
    final static int MAX_DOCUMENT_COUNT = 20;
    final static int MAX_DOCUMENT_VOLUME = 10;
    final static int MIN_BUFFERSIZE = 2;
    final static int MAX_BUFFERSIZE = 5;


    public static void main(String[] args) {
        Solution sol = new Solution();

        // 과제 출력 예시
        int[] arr2 = new int[] {7, 4, 5, 6};
        System.out.println("arr2 : " + Arrays.toString(arr2));
        System.out.println("총 시간 : " + sol.queuePrinter(2, 10, arr2));

        System.out.println("-".repeat(30));

        Test test = new Test(
                MAX_DOCUMENT_COUNT,
                MAX_DOCUMENT_VOLUME,
                MIN_BUFFERSIZE,
                MAX_BUFFERSIZE
        );
        test.createRandomArr();
        int[] arr = test.getArr();
        int bufferSize = test.getBufferSize();
        int capacities = test.getCapacities();

        // 자유 랜덤 테스트
        System.out.println(
                "bufferSize : " + bufferSize +
                        "\t\tcapacities : " + capacities +
                        "\t\tarr : " + Arrays.toString(arr));
        System.out.println("총 시간 : " + sol.queuePrinter(bufferSize, capacities, arr));
    }
}

class Test {
    private int[] arr;
    private int bufferSize;
    private int capacities;

    public int[] getArr() { return arr; }
    public int getBufferSize() { return bufferSize; }
    public int getCapacities() { return capacities; }


    private int maxDocumentCount;
    private int maxDocumentVolume;
    private int minBufferSize;
    private int maxBufferSize;
    Test(int maxDocumentCount, int maxDocumentVolume,
         int minBufferSize, int maxBufferSize) {

        this.maxDocumentCount = maxDocumentCount;
        this.maxDocumentVolume = maxDocumentVolume;
        this.minBufferSize = minBufferSize;
        this.maxBufferSize = maxBufferSize;
    }

    public void createRandomArr() {
        arr = new int[maxDocumentCount];
        Random r = new Random();
        for(int i = 0; i<arr.length; i++) {
            arr[i] = r.nextInt(maxDocumentVolume)+1;
        }
        this.bufferSize = r.nextInt(maxBufferSize - minBufferSize + 1) + minBufferSize;
        this.capacities = r.nextInt(
                maxDocumentVolume * (maxBufferSize - minBufferSize) + 1)
                +maxDocumentVolume;
    }
}


class Solution {
    public int queuePrinter(int bufferSize, int capacities, int[] documents) {
        // TODO:
        // 프린터의 인쇄 작업 목록의 크기와 최대 용량을 가정하고
        // 각기 다른 용량의 문서를 차례대로 인쇄하여 모든 문서가 인쇄되는데
        // 최소 몇 초가 걸리는지 테스트하기로 했습니다.

        // 인쇄 작업 목록은 칸으로 이루어져 있습니다.
        // 각 칸에는 한 개의 문서만 위치할 수 있습니다.
        // 문서는 1초에 한 칸만 이동할 수 있습니다.
        // 인쇄 작업 목록의 크기는 bufferSize 이고
        // 최대 용량 capacities 만큼 문서를 담을 수 있습니다.

        // 버퍼 사이즈2, 버퍼 수용량 10 이라면
        //초  버퍼   대기열
        // 0 [0, 0] [7, 4, 5, 6]
        // 1 [0, 7] [4, 5, 6]
        // 2 [7, 0] [4, 5, 6]
        // 3 [0, 4] [5, 6]
        // 4 [4, 5] [6]
        // 5 [5, 0] [6]
        // 6 [0, 6] []
        // 7 [6, 0] []
        // 8 [0, 0] []

        Queue<Integer> qBuffer = new LinkedList<>();    // 버퍼를 큐로 변환
        Queue<Integer> qDocuments = Arrays.stream(documents)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        for( int i = 0; i < bufferSize; i++ ) qBuffer.add(0);   // 버퍼의 공간만큼 0으로 초기화

        int result = 0;     // 총 걸린 시간

        // qDocuments 대기자료가 없고 + 버퍼가 비어있으면 = 작업을 완료한 것임 !
        while ( !(qDocuments.isEmpty() && getSumOfqBuffer(qBuffer) == 0) ) {
            //      작업 내용을 가져와야한다.
            qBuffer.poll();     // 버퍼에 있는 것을 뽑아서 출력
            result++;           // 뽑으면서 걸리는 시간 증가

            // 1. 만약 버퍼에 여유공간이 있다면
            //      -> 현재 버퍼 내의 용량 총합 + 다음 작업 용량 > 총용량 (capacities)
            // 추가할 작업이 없으면 Doc큐에서 뽑을 수 없으니 예외처리함
            // 데이터를 참조하는 메서드와 동시에 사용하면 위험함
            if(!qDocuments.isEmpty()) {
                // 버퍼 총용량 넘어가나?
                if (getSumOfqBuffer(qBuffer) + qDocuments.peek() <= capacities)
                    qBuffer.add(qDocuments.poll());     // Doc에서 데이터를 뽑아서 버퍼에 추가한다
                else qBuffer.add(0);     // 버퍼 용량 초과로 새로운 작업 추가할 수 없을 때는 0을 리필해준다
            } else qBuffer.add(0);

            // 현재 시간과 함께 큐 상태를 시각적으로 보여주기 위해 추가함
            System.out.printf("%3d", result);
            System.out.println("  " + qBuffer.toString() + qDocuments.toString());
        }

        return result;
    }

    /**
     * 입력받은 큐에 있는 데이터의 총합을 리턴해준다
     * @param qBuffer Integer 타입의 자료형이 담긴 큐
     * @return        총합
     */
    private int getSumOfqBuffer(Queue<Integer> qBuffer) {
        return qBuffer.stream().mapToInt(e->e).sum();
    }
}
