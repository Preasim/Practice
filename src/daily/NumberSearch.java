package daily;


import java.util.stream.Stream;

class NumberSearch {
    public static void main(String[] args) {
        String str = "Hello6 9World 2,";

        String Wstr = str.replaceAll("[0-9\\s]", "");
        int intStr = Integer.parseInt(str.replaceAll("[^0-9]",""));
        int[] intStrArr = Stream.of(String.valueOf(intStr).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();


        double num = 0;
        for(int i=0; i<intStrArr.length; i++){
            num+=intStrArr[i];
        }
        num = num / Wstr.length();

        int result = Integer.parseInt(String.format("%.0f", num));
        System.out.println(result);
    }
}
