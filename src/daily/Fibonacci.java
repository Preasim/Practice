package daily;

import java.util.ArrayList;
import java.util.Arrays;

class Fibonacci {
    public static void main(String[] args) {
        FibonacciSolution fibonacciSolution = new FibonacciSolution();

        long output = fibonacciSolution.fibonacci(10);
        System.out.println("output : " + output);
    }
}

class FibonacciSolution {
    public int fibonacci(int num){
//        1번 풀이 ----------------
//        if(num==0) return 0;
//        if(num==1||num==2) return 1;
//        return fibonacci(num-1) + fibonacci(num-2);


        // 2번 풀이 -----------------------
//        if(num<2) {
//            return num;
//        } else {
//            long[] cache = new long[num+1];
//            Arrays.fill(cache, -1);
//            cache[0] = 0;
//            cache[1] = 1;
//
//            if(cache[num] != -1){
//                return (int) cache[num];
//            } else {
//                cache[num] = fibonacci(num-1) + fibonacci(num-2);
//                return (int) cache[num];
//            }
//        }

        // 3번 풀이 -----------------------

        ArrayList<Integer> memo = new ArrayList<>();
        memo.add(0);
        memo.add(1);

        return (int) aux(memo, num);
    }
    public long aux(ArrayList<Integer> memo, int num){
        if(memo.size() <= num) memo.add((int) (aux(memo, num-1) + aux(memo, num-2)));
        return memo.get(num);
    }
}