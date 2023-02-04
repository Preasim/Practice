package daily;

class ComputeSquareRoot {
    public static void main(String[] args) {
        int num = 6;

        double[] diffs = new double[]{1, 0.1, 0.01, 0.001};
        double base = 1;

        for(int i = 0; i < diffs.length; i++) {
            while (base * base < num) {
                base = base + diffs[i];
            }
            if(base * base == num) {
                System.out.println(String.format("%.2f", base));
            }else {
                base = base - diffs[i];
            }
        }
        System.out.println(String.format("%.2f", base));

//        double num2 = Math.sqrt(num);
//
//        String result = String.format("%.2f", num2);
//        System.out.println(result);
    }
}
