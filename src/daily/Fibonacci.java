package daily;

import java.util.Arrays;

class Fibonacci {
    public static void main(String[] args) {
        FibonacciSolution fibonacciSolution = new FibonacciSolution();

        long output = fibonacciSolution.fibonacci(30);
        System.out.println("output : " + output);
    }
}

class FibonacciSolution {
    public long fibonacci(int num){
//        if(num==0) return 0;
//        if(num==1||num==2) return 1;
//        return fibonacci(num-1) + fibonacci(num-2);

        if(num<2) {
            return num;
        } else {
            long[] cache = new long[num+1];
            Arrays.fill(cache, -1);
            cache[0] = 0;
            cache[1] = 1;

            if(cache[num] != -1){
                return cache[num];
            } else {
                cache[num] = fibonacci(num-1) + fibonacci(num-2);
                return cache[num];
            }
        }

    // ㅈㄴ 개빡셈;;
    }
}