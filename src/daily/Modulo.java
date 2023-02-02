package daily;

class Modulo {
    public static void main(String[] args) {
        int num1 = 123456789;
        int num2 = 67;
        int num3 = 0;
        if(num2==0) System.out.println("null");

        while(num1>=num3){
            num3 += num2;
        }
        num3 -= num2;
        int result = num1 - num3;
        System.out.println(result);
    }
}
