package graphMatrix;

import java.util.Arrays;

class GraphMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] output1 = solution.createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });
    }
}
class Solution {
    public int[][] createMatrix(int[][] edges) {
        int from; //시작 정점
        int to; // 도착 정점
        int direction; // 방향 여부
        int maxMatrix = Arrays.stream(edges)
                            .flatMapToInt(Arrays::stream)//일반 스트림을 IntStream으로 변환해주는 메서드.
                            .max()
                            .orElse(0); // edges값이 null이면 0 출력.
        // 리턴 할 인접행렬
        int[][] matrix = new int[maxMatrix+1][maxMatrix+1];

        for( int[] edge : edges ){
            from = edge[0];
            to = edge[1];
            direction = edge[2];

            matrix[from][to] = 1;
            if(direction==1)matrix[to][from] = 1;
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }
}


//    [0][1][2]
// [0]{a, d, 0},  a -> d
// [1]{a, c, 0},  a -> c
// [2]{b, d, 0},  b -> d
// [3]{c, b, 0},  c -> b

// {0, 2, 0}, a -> c          [0,0,1,0,0]
// {2, 4, 1}, c <-> e     =   [0,0,0,1,0]
// {1, 3, 1}, b <-> d         [0,1,0,0,1]
// {2, 1, 0}, c -> b          [0,1,0,0,0]
//                            [0,0,1,0,0]

//    a  b  c
// a	[0, 1, 1],  a->b , a->c       [0,1,0]
// b	[0, 0, 1],  b->c          =   [0,2,1]
// c	[1, 0, 0]   c->a              [1,2,0]

// 반복문으로 edges 돌면서 가장 큰 수 + 1 = maxMatrixSize
// 1. 0=a 1=b 2=c 3=d ...
// 2. 1번째 행 a , a[(a,b,c,d...)]
// int[][] matrix