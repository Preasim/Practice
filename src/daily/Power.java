package daily;

import java.util.Scanner;


// 두 수를 입력받아 거듭제곱을 리턴
class Power {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("base 입력");
        int base = scanner.nextInt();
        System.out.println("exponent 입력");
        int exponent = scanner.nextInt();

        PowerSolution powerSolution = new PowerSolution();
        System.out.println(powerSolution.power(base, exponent));

        scanner.close();
    }
}

class PowerSolution {
    public long power(int base, int exponent){
        if(exponent == 0) return 1;

        int half = exponent / 2;
        long temp = power(base, half);
        long result = (temp * temp) % 94906249;

        if(exponent % 2 == 1) return (base * result) % 94906249;
        else return result;
    }
}
