package algorithm;

import java.util.Arrays;

class BoardGame {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}};
        String operation = "RRDLLD"; //U(상), D(하), L(좌), R(우)
        int result = 0;
        int rl = 0;
        int ud = 0;
        for(int i=0; i<operation.length(); i++){
            if(operation.charAt(i)=='R'){
                rl++;
                result += Integer.valueOf(board[ud][rl]);
            } else if (operation.charAt(i)=='L'){
                rl--;
                if(rl < 0) System.out.println("null");
                result += Integer.valueOf(board[ud][rl]);
            } else if (operation.charAt(i)=='D'){
                ud++;
                result += Integer.valueOf(board[ud][rl]);
            } else if (operation.charAt(i)=='U'){
                ud--;
                if(ud < 0) System.out.println("null");
                result += Integer.valueOf(board[ud][rl]);
            }
        }
        System.out.println(result);
    }
}
